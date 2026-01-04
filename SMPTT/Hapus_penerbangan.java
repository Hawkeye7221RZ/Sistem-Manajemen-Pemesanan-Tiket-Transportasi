package SMPTT;

import java.util.Scanner;

public class Hapus_penerbangan {
    static Scanner sc = new Scanner(System.in);

    public static void hapusFlight() {
        utama.tampilkanHeader("HAPUS PENERBANGAN");

        if (data.isDataKosong()) {
            System.out.println("Belum ada data penerbangan.");
            return;
        }

        String id = data.inputString("Masukkan ID penerbangan yang akan dihapus: ");
        int index = pencarian_data.cariIndexById(id);

        if (index != -1) {
            System.out.print("Apakah anda yakin ingin menghapus data ini? (Y/N): ");
            String konfirmasi = sc.nextLine();
            
            if (konfirmasi.equalsIgnoreCase("Y")) {
                for (int i = index; i < data.count - 1; i++) {
                    data.flights[i] = data.flights[i + 1];
                }
                data.flights[data.count - 1] = null;
                data.count--;
                System.out.println("Data penerbangan berhasil dihapus!");
            } else {
                System.out.println("Penghapusan dibatalkan.");
            }
        } else {
            System.out.println("Penerbangan dengan ID " + id + " tidak ditemukan.");
        }
    }
}
