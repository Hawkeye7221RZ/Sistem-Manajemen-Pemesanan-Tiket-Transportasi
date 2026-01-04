package SMPTT;

import java.util.Scanner;

import SMPTT.data.Flight;

public class pencarian_data {

    static Scanner sc = new Scanner(System.in);

   
    public static void cariFlight() {
        utama.tampilkanHeader("CARI PENERBANGAN BY ID");
        
        if (data.isDataKosong()) {
            System.out.println("Belum ada data penerbangan.");
            return;
        }

        String id = data.inputString("Masukkan ID: ");
        int index = cariIndexById(id);

        if (index != -1) {
            System.out.println("\nPenerbangan ditemukan:");
            tampilkanDetailFlight(data.flights[index]);
        } else {
            System.out.println(" Penerbangan dengan ID " + id + " tidak ditemukan.");
        }
    }

    public static int cariIndexById(String id) {
        for (int i = 0; i < data.count; i++) {
            if (data.flights[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public static void carirute(){
        utama.tampilkanHeader("CARI PENERBANGAN BY RUTE");
        
        if (data.isDataKosong()) {
            System.out.println("Belum ada data penerbangan.");
            return;
        }

        String asal = data.inputString("Masukkan Kota Asal: ");
        String tujuan = data.inputString("Masukkan Kota Tujuan: ");
        boolean ditemukan = false;

        System.out.println("\nHasil pencarian untuk rute " + asal + " | " + tujuan + ":");
        for (int i = 0; i < data.count; i++) {
            if (data.flights[i].getAsal().equalsIgnoreCase(asal) && data.flights[i].getTujuan().equalsIgnoreCase(tujuan)) {
                tampilkanDetailFlightSingkat(data.flights[i]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada penerbangan ditemukan untuk rute tersebut.");
        }
    }

     public static void tampilkanDetailFlightSingkat(Flight x) {
        System.out.println(x.getId() + " | " + x.getAsal() + " | " + x.getTujuan() + 
                         " | Rp " + x.getHarga() + " | " + x.getTanggal());
    }

    public static void tampilkanDetailFlight(Flight x) {
        System.out.println("\nID: " + x.getId());
        System.out.println("Pesawat: " + x.getPesawat());
        System.out.println("Asal: " + x.getAsal());
        System.out.println("Tujuan: " + x.getTujuan());
        System.out.println("Harga: Rp " + x.getHarga());
        System.out.println("Tanggal keberangkatan: " + x.getTanggal());
        System.out.println("----------------------------------");
    }
}
