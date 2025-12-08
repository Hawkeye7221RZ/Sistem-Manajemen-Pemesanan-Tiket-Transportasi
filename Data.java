import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    static class Flight {
        String id;
        String pesawat;
        String asal;
        String tujuan;
        double harga;
        String tanggal;

        public Flight(String id, String pesawat, String asal, String tujuan, double harga, String tanggal) {
            this.id = id;
            this.pesawat = pesawat;
            this.asal = asal;
            this.tujuan = tujuan;
            this.harga = harga;
            this.tanggal = tanggal;
        }

        public String getId() { return id; }
        public String getAsal() { return asal; }
        public String getTujuan() { return tujuan; }

        public String toString() {
            return "\nID: " + id +
                   "\nPesawat: " + pesawat +
                   "\nAsal: " + asal +
                   "\nTujuan: " + tujuan +
                   "\nHarga: Rp " + harga +
                   "\nTanggal: " + tanggal +
                   "\n---------------------------";
        }
    }

    static class Booking {
        String nama;
        Flight flight;

        public Booking(String nama, Flight flight) {
            this.nama = nama;
            this.flight = flight;
        }

        public String toString() {
            return "Nama: " + nama + "\nDetail Penerbangan: " + flight.toString();
        }
    }



    static ArrayList<Flight> flights = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        flights.add(new Flight("F001", "Garuda", "Jakarta", "Bali", 1200000, "25-12-2025"));
        flights.add(new Flight("F002", "Lion Air", "Bandung", "Surabaya", 850000, "10-01-2026"));
        flights.add(new Flight("F003", "AirAsia", "Jakarta", "Singapore", 1500000, "05-02-2026"));

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
                    System.out.println("Terima kasih sudah menggunakan sistem!");
                    return;
                }
                default -> System.out.println("Pilihan salah!");
            }
        }
    }

    static void tampilkanSemua() {
        System.out.println("\n--- DAFTAR PENERBANGAN ---");
        for (Flight f : flights) {
            System.out.println(f);
        }
    }

    static void cariPenerbangan(Scanner input) {
        System.out.print("Masukkan asal: ");
        String asal = input.nextLine();

        System.out.print("Masukkan tujuan: ");
        String tujuan = input.nextLine();

        boolean ditemukan = false;
        for (Flight f : flights) {
            if (f.getAsal().equalsIgnoreCase(asal) && f.getTujuan().equalsIgnoreCase(tujuan)) {
                System.out.println("\nPenerbangan ditemukan:");
                System.out.println(f);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada penerbangan dengan rute tersebut.");
        }
    }

    static void pesanTiket(Scanner input) {
        System.out.print("Masukkan ID penerbangan: ");
        String id = input.nextLine();

        Flight selected = null;

        for (Flight f : flights) {
            if (f.getId().equalsIgnoreCase(id)) {
                selected = f;
                break;
            }
        }

        if (selected == null) {
            System.out.println("Penerbangan tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan nama pemesan: ");
        String nama = input.nextLine();

        bookings.add(new Booking(nama, selected));
        System.out.println("Tiket BERHASIL dipesan!");
    }

    static void tampilkanRiwayat() {
        System.out.println("\n--- RIWAYAT PEMESANAN ---");
        if (bookings.isEmpty()) {
            System.out.println("Belum ada pemesanan.");
            return;
        }

        for (Booking b : bookings) {
            System.out.println(b);
        }
    }
}