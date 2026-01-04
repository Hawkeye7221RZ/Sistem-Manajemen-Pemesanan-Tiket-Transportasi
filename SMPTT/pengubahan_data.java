package SMPTT;

import java.util.Scanner;

public class pengubahan_data {

    static Scanner sc = new Scanner(System.in);

    public static void ui_edit(){
        System.out.println("\nData apa yang akan diubah?");
        System.out.println("-----------------------------");
        System.out.println("1. Edit ID");
        System.out.println("2. Edit Pesawat");
        System.out.println("3. Edit Asal");
        System.out.println("4. Edit Tujuan");
        System.out.println("5. Harga");
        System.out.println("6. Tanggal");
        System.out.println("7. Kembali ke menu utama");

        System.out.print("Pilih: ");
    }
    
    public static void editFlight(){
        utama.tampilkanHeader("EDIT PENERBANGAN");

        if (data.isDataKosong()) {
            System.out.println("Belum ada data penerbangan.");
            return;
        }
        

        String id = data.inputString("Masukkan ID penerbangan yang akan diubah: ");
        int index = pencarian_data.cariIndexById(id);
        int pilihan = 0;

        if (index != -1){
            System.out.println("Data:");
            pencarian_data.tampilkanDetailFlight(data.flights[index]);
            do{
                ui_edit();
                pilihan = sc.nextInt();
                sc.nextLine();
                System.out.println("--------------------------");
                ubah(pilihan, index);
                System.out.println("--------------------------");
            }while(pilihan != 7);
        }else{
            System.out.println("Penerbangan dengan ID " + id + " tidak ditemukan.");
        }
    }


    public static void ubah(int pilihan, int index){
        if (pilihan == 1) {
            System.out.print("ID baru: ");
            data.flights[index].id = sc.nextLine();
        }else if (pilihan == 2){
            System.out.print("Pesawat baru: ");
            data.flights[index].pesawat = sc.nextLine();
        } else if (pilihan == 3){
            System.out.print("Asal baru: ");
            data.flights[index].asal = sc.nextLine();
        }else if (pilihan == 4){
            System.out.print("Tujuan baru: ");
            data.flights[index].tujuan = sc.nextLine();
        }else if (pilihan == 5){
            System.out.print("Harga baru: ");
            data.flights[index].harga = sc.nextInt();
        }else if (pilihan == 6){
            System.out.print("Tanggal baru: ");
            data.flights[index].tanggal = sc.nextLine();
        }else if (pilihan == 7){
            utama.pesan_kembali_menu();
        }else{
            System.out.println("Pilihan tidak valid!");
        }
    }
}
