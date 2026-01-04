package SMPTT;

import java.util.Scanner;

public class data {
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

        public static boolean isDataPenuh() {
        return count >= flights.length;
    }

    public static boolean isDataKosong() {
        return count == 0;
    }

        public static void tambahFlight() {
        utama.tampilkanHeader("TAMBAH PENERBANGAN");
        
        if (isDataPenuh()) {
            System.out.println("Data penuh! Tidak bisa menambah penerbangan.");
            return;
        }

        Flight flight = inputDataFlight();
        flights[count] = flight;
        count++;
        System.out.println("Data penerbangan berhasil ditambahkan!");
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
}
