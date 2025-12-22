package SMPTT;

import java.util.Scanner;

public class utama {
    static Scanner sc = new Scanner(System.in);
    public static void prosesPilihan(int pilihan) {
        switch (pilihan) {
            case 1:
                data.tambahFlight();
                break;
            case 2:
                penampilan_data.tampilkanSemuaFlight();
                break;
            case 3:
                pencarian_data.cariFlight();
                break;
            case 4:
                pencarian_data.carirute();
                break;
            case 5:
                pengubahan_data.editFlight();
                break;
            case 6:
                Hapus_penerbangan.hapusFlight();
            case 7:
                tampilkanPesanKeluar();
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }

    public static void tampilkanHeader(String judul) {
        System.out.println("\n=== " + judul + " ===");
    }

      public static void tampilkanMenu() {
         System.out.println("\n=== SISTEM DATA PENERBANGAN ===");
        System.out.println("1. Tambah Penerbangan");
        System.out.println("2. Tampilkan Semua Penerbangan");
        System.out.println("3. Cari Penerbangan by ID");
        System.out.println("4. Cari Penerbangan by Rute");
        System.out.println("5. Edit Penerbangan");
        System.out.println("6. Hapus Penerbangan");
        System.out.println("7. Keluar");
        System.out.print("Pilih menu: ");
    }

     public static void tampilkanPesanKeluar() {
        System.out.println("\n=================================");
        System.out.println("Terima kasih telah menggunakan sistem!");
        System.out.println("=================================");
    }

    public static void pesan_kembali_menu(){
        System.out.println("\n=================================");
        System.out.println("Kembali ke menu utama");
        System.out.println("=================================");
    }

    public static void jalankanProgram() {
        int pilihan;
        do {
            tampilkanMenu();
            pilihan = sc.nextInt();
            sc.nextLine();
            prosesPilihan(pilihan);
        } while (pilihan != 7);
    }

    public static void main(String[] args) {
        jalankanProgram();
        sc.close();
    }
}

