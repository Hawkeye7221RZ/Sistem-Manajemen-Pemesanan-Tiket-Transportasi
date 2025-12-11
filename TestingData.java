import java.util.Scanner;

public class TestingData {

    // ===== CLASS FLIGHT =====
    static class Flight {
        String id;
        String pesawat;
        String asal;
        String tujuan;
        int harga;
        String tanggal;

        public Flight(String id, String pesawat, String asal, String tujuan, int harga, String tanggal) {
            this.id = id;
            this.pesawat = pesawat;
            this.asal = asal;
            this.tujuan = tujuan;
            this.harga = harga;
            this.tanggal = tanggal;
        }

        public String getId() { return id; }
        public String getPesawat() { return pesawat; }
        public String getAsal() { return asal; }
        public String getTujuan() { return tujuan; }
        public int getHarga() { return harga; }
        public String getTanggal() { return tanggal; }

        public String toString() {
            return "\nID: " + id +
                   "\nPesawat: " + pesawat +
                   "\nAsal: " + asal +
                   "\nTujuan: " + tujuan +
                   "\nHarga: Rp " + harga +
                   "\nTanggal: " + tanggal +
                   "\n--------------------------";
        }
    }

    // ===== CLASS BOOKING =====
    static class Booking {
        String nama;
        Flight flight;

        public Booking(String nama, Flight flight) {
            this.nama = nama;
            this.flight = flight;
        }

        public String toString() {
            return "Nama: " + nama + "\nDetail: " + flight.toString();
        }
    }

    // ===== TANPA ARRAYLIST =====
    static Flight[] flights = new Flight[100];      // kapasitas maksimum
    static Booking[] bookings = new Booking[100];  // kapasitas maksimum

    static int flightCount = 0;
    static int bookingCount = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ============== DATA DEFAULT ==============
        flights[flightCount++] = new Flight("F001", "Garuda", "Jakarta", "Bali", 1200000, "25-12-2025");
        flights[flightCount++] = new Flight("F002", "Lion Air", "Bandung", "Surabaya", 850000, "10-01-2026");
        flights[flightCount++] = new Flight("F003", "AirAsia", "Jakarta", "Singapore", 1500000, "05-02-2026");
        flights[flightCount++] = new Flight("F004", "CitiLink", "Jakarta", "Pontianak", 2000000, "21-02-2026");

        // ============== MENU UTAMA ==============
        while (true) {
            System.out.println("\n=== SISTEM PEMESANAN TIKET PESAWAT ===");
            System.out.println("1. Lihat Semua Penerbangan");
            System.out.println("2. Cari Penerbangan");
            System.out.println("3. Pesan Tiket");
            System.out.println("4. Riwayat Pemesanan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1 -> tampilkanSemua();
                case 2 -> cariPenerbangan(input);
                case 3 -> pesanTiket(input);
                case 4 -> tampilkanRiwayat();
                case 5 -> {
                    System.out.println("Terima kasih!");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }

    // ====== TAMPILKAN SEMUA ======
    static void tampilkanSemua() {
        System.out.println("\n--- DAFTAR PENERBANGAN ---");
        for (int i = 0; i < flightCount; i++) {
            System.out.println(flights[i]);
        }
    }

    // ====== CARI PENERBANGAN ======
    static void cariPenerbangan(Scanner input) {
        System.out.print("Masukkan asal: ");
        String asal = input.nextLine();

        System.out.print("Masukkan tujuan: ");
        String tujuan = input.nextLine();

        boolean ditemukan = false;

        for (int i = 0; i < flightCount; i++) {
            if (flights[i].getAsal().equalsIgnoreCase(asal) &&
                flights[i].getTujuan().equalsIgnoreCase(tujuan)) {

                System.out.println("\nPenerbangan ditemukan:");
                System.out.println(flights[i]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada penerbangan dengan rute tersebut.");
        }
    }

    // ====== PESAN TIKET ======
    static void pesanTiket(Scanner input) {
        System.out.print("Masukkan ID penerbangan: ");
        String id = input.nextLine();

        Flight selected = null;

        for (int i = 0; i < flightCount; i++) {
            if (flights[i].getId().equalsIgnoreCase(id)) {
                selected = flights[i];
                break;
            }
        }

        if (selected == null) {
            System.out.println("Penerbangan tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan nama pemesan: ");
        String nama = input.nextLine();

        bookings[bookingCount++] = new Booking(nama, selected);
        System.out.println("Tiket BERHASIL dipesan!");
    }

    // ====== TAMPILKAN RIWAYAT ======
    static void tampilkanRiwayat() {
        System.out.println("\n--- RIWAYAT PEMESANAN ---");

        if (bookingCount == 0) {
            System.out.println("Belum ada pemesanan.");
            return;
        }

        for (int i = 0; i < bookingCount; i++) {
            System.out.println(bookings[i]);
        }
    }
}
