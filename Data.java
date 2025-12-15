import java.util.Scanner;

public class Data {

    static class Flight {
        String id;
        String pesawat;
        String asal;
        String tujuan;
        int harga;
        String tanggal;

        public Flight(String iinputd, String inputpesawat, String inputasal, String inputtujuan, int inputharga, String inputtanggal) {
            id = iinputd;
            pesawat = inputpesawat;
            asal = inputasal;
            tujuan = inputtujuan;
            harga = inputharga;
            tanggal = inputtanggal;
        }

        public String getId() { return id; }
        public String getPesawat() { return pesawat; }
        public String getAsal() { return asal; }
        public String getTujuan() { return tujuan; }
        public int getHarga() { return harga; }
        public String getTanggal() { return tanggal; }

    }

    static Flight[] flights = new Flight[100];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void tampilkanDetailFlight(Flight x) {
        System.out.println("\nID: " + x.getId());
        System.out.println("Pesawat: " + x.getPesawat());
        System.out.println("Asal: " + x.getAsal());
        System.out.println("Tujuan: " + x.getTujuan());
        System.out.println("Harga: Rp " + x.getHarga());
        System.out.println("Tanggal keberangkatan: " + x.getTanggal());
        System.out.println("--------------------------");
    }

    public static void tampilkanDetailFlightSingkat(Flight x) {
        System.out.println(x.getId() + " | " + x.getAsal() + " | " + x.getTujuan() + 
                         " | Rp " + x.getHarga() + " | " + x.getTanggal());
    }

    public static void tampilkanMenu() {
        System.out.println("\n=== SISTEM DATA PENERBANGAN ===");
        System.out.println("1. Tambah Penerbangan");
        System.out.println("2. Tampilkan Semua Penerbangan");
        System.out.println("3. Cari Penerbangan by ID");
        System.out.println("4. Cari Penerbangan by Rute");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu: ");
    }

    public static void tampilkanHeader(String judul) {
        System.out.println("\n=== " + judul + " ===");
    }

    public static String inputString(String a) {
        System.out.print(a);
        return sc.nextLine();
    }

    public static int inputInt(String b) {
        System.out.print(b);
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    public static Flight inputDataFlight() {
        String id = inputString("ID: ");
        String pesawat = inputString("Pesawat: ");
        String asal = inputString("Asal: ");
        String tujuan = inputString("Tujuan: ");
        int harga = inputInt("Harga: ");
        String tanggal = inputString("Tanggal (DD-MM-YYYY): ");
        
        return new Flight(id, pesawat, asal, tujuan, harga, tanggal);
    }

    public static boolean isDataPenuh() {
        return count >= flights.length;
    }

    public static boolean isDataKosong() {
        return count == 0;
    }

    public static int cariIndexById(String id) {
        for (int i = 0; i < count; i++) {
            if (flights[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public static void tambahFlight() {
        tampilkanHeader("TAMBAH PENERBANGAN");
        
        if (isDataPenuh()) {
            System.out.println("Data penuh! Tidak bisa menambah penerbangan.");
            return;
        }

        Flight flight = inputDataFlight();
        flights[count] = flight;
        count++;
        System.out.println("Data penerbangan berhasil ditambahkan!");
    }

    public static void tampilkanSemuaFlight() {
        tampilkanHeader("DAFTAR PENERBANGAN");
        
        if (isDataKosong()) {
            System.out.println("Belum ada data penerbangan.");
            return;
        }

        for (int i = 0; i < count; i++) {
            tampilkanDetailFlight(flights[i]);
        }
        System.out.println("Total: " + count + " penerbangan");
    }

    public static void cariFlight() {
        tampilkanHeader("CARI PENERBANGAN BY ID");
        
        if (isDataKosong()) {
            System.out.println("Belum ada data penerbangan.");
            return;
        }

        String id = inputString("Masukkan ID: ");
        int index = cariIndexById(id);

        if (index != -1) {
            System.out.println("\nPenerbangan ditemukan:");
            tampilkanDetailFlight(flights[index]);
        } else {
            System.out.println(" Penerbangan dengan ID " + id + " tidak ditemukan.");
        }
    }
    public static void carirute(){
        tampilkanHeader("CARI PENERBANGAN BY RUTE");
        
        if (isDataKosong()) {
            System.out.println("Belum ada data penerbangan.");
            return;
        }

        String asal = inputString("Masukkan Kota Asal: ");
        String tujuan = inputString("Masukkan Kota Tujuan: ");
        boolean ditemukan = false;

        System.out.println("\nHasil pencarian untuk rute " + asal + " | " + tujuan + ":");
        for (int i = 0; i < count; i++) {
            if (flights[i].getAsal().equalsIgnoreCase(asal) || flights[i].getTujuan().equalsIgnoreCase(tujuan)) {
                tampilkanDetailFlightSingkat(flights[i]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada penerbangan ditemukan untuk rute tersebut.");
        }
    }
    public static void prosesPilihan(int pilihan) {
        switch (pilihan) {
            case 1:
                tambahFlight();
                break;
            case 2:
                tampilkanSemuaFlight();
                break;
            case 3:
                cariFlight();
                break;
            case 4:
                carirute();
                break;
            case 5:
                tampilkanPesanKeluar();
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }

    public static void tampilkanPesanKeluar() {
        System.out.println("\n=================================");
        System.out.println("Terima kasih telah menggunakan sistem!");
        System.out.println("=================================");
    }

    public static void jalankanProgram() {
        int pilihan;
        do {
            tampilkanMenu();
            pilihan = sc.nextInt();
            sc.nextLine();
            prosesPilihan(pilihan);
        } while (pilihan != 5);
    }

    public static void main(String[] args) {
        jalankanProgram();
        sc.close();
    }
}