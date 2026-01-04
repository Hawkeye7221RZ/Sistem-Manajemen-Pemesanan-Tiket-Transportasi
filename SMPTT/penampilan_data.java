package SMPTT;

import java.util.Scanner;

import SMPTT.data.Flight;

public class penampilan_data{
    static Scanner sc = new Scanner(System.in);

    public static void tampilkanSemuaFlight() {
        utama.tampilkanHeader("DAFTAR PENERBANGAN");
        
        if (data.isDataKosong()) {
            System.out.println("Belum ada data penerbangan.");
            return;
        }

        int pilihan;
        int sort;
        String pilihan_asc;
        

        for (int i = 0; i < data.count; i++) {
            pencarian_data.tampilkanDetailFlight(data.flights[i]);
        }
        System.out.println("Total: " + data.count + " penerbangan");

        do {
            menu_penampilan();
            pilihan = sc.nextInt();
            sc.nextLine();
            if(pilihan == 1){
                sorting_menu();
                sort = sc.nextInt();
                sc.nextLine();
                asc_or_desc();
                pilihan_asc = sc.next();
                sc.nextLine();
                boolean ascending = pilihan_asc.equalsIgnoreCase("A");
                sorting(sort,ascending);
            }
        } while (pilihan != 2);
    }

    public static void menu_penampilan(){
        System.out.println("-----------------------------");
        System.out.println("1. Sort");
        System.out.println("2. Kembali ke menu utama");

        System.out.print("Pilihan: ");
    }

    public static void sorting_menu(){
        System.out.println("\nSorting");
        System.out.println("-----------------------------");
        System.out.println("1. ID");
        System.out.println("2. Pesawat");
        System.out.println("3. Asal");
        System.out.println("4. Tujuan");
        System.out.println("5. Harga");
        System.out.println("6. Tanggal");

        System.out.print("Sort by: ");
    }

    public static void asc_or_desc(){
        System.out.print("Ascending or Descending? (A/D): ");
    }
    public static void sorting(int sort, boolean ascending){
        int n = data.count;
        if (sort == 1) {
            System.out.print("\nSort by id ");
            if(ascending){
                System.out.println(" - Ascending");
            }else{
                System.out.println(" - Descending");
            }
            System.out.println("----------------------------------");
            for (int i = 0; i < n - 1;i++){
                int min_index = i;
                for (int j = i + 1; j < n;j++){
                    if(ascending){
                        if(data.flights[j].id.compareTo(data.flights[min_index].id) < 0){
                        min_index = j;
                        }
                    }else{
                        if(data.flights[j].id.compareTo(data.flights[min_index].id) > 0){
                        min_index = j;
                        }
                    }
                }
                Flight temp = data.flights[min_index];
                data.flights[min_index] = data.flights[i];
                data.flights[i] = temp;
            }
            for (int i = 0; i < data.count; i++) {
                pencarian_data.tampilkanDetailFlight(data.flights[i]);
                }
            System.out.println("Total: " + data.count + " penerbangan");

        }else if (sort == 2){
            System.out.print("\nSort by pesawat ");
            if(ascending){
                System.out.println(" - Ascending");
            }else{
                System.out.println(" - Descending");
            }
            System.out.println("----------------------------------");
            for (int i = 0; i < n - 1;i++){
                int min_index = i;
                for (int j = i + 1; j < n;j++){
                    if(ascending){
                        if(data.flights[j].pesawat.compareTo(data.flights[min_index].pesawat) < 0){
                        min_index = j;
                        }
                    }else{
                        if(data.flights[j].pesawat.compareTo(data.flights[min_index].pesawat) > 0){
                        min_index = j;
                        }
                    }
                }
                Flight temp = data.flights[min_index];
                data.flights[min_index] = data.flights[i];
                data.flights[i] = temp;
            }
            for (int i = 0; i < data.count; i++) {
                pencarian_data.tampilkanDetailFlight(data.flights[i]);
                }
            System.out.println("Total: " + data.count + " penerbangan");
        } else if (sort == 3){
            System.out.print("\nSort by asal ");
            if(ascending){
                System.out.println(" - Ascending");
            }else{
                System.out.println(" - Descending");
            }
            System.out.println("----------------------------------");
            for (int i = 0; i < n - 1;i++){
                int min_index = i;
                for (int j = i + 1; j < n;j++){
                    if(ascending){
                        if(data.flights[j].asal.compareTo(data.flights[min_index].asal) < 0){
                        min_index = j;
                        }
                    }else{
                        if(data.flights[j].asal.compareTo(data.flights[min_index].asal) > 0){
                        min_index = j;
                        }
                    }
                }
                Flight temp = data.flights[min_index];
                data.flights[min_index] = data.flights[i];
                data.flights[i] = temp;
            }
            for (int i = 0; i < data.count; i++) {
                pencarian_data.tampilkanDetailFlight(data.flights[i]);
                }
            System.out.println("Total: " + data.count + " penerbangan");
        }else if (sort == 4){
            System.out.print("\nSort by tujuan ");
            if(ascending){
                System.out.println(" - Ascending");
            }else{
                System.out.println(" - Descending");
            }
            System.out.println("----------------------------------");
            for (int i = 0; i < n - 1;i++){
                int min_index = i;
                for (int j = i + 1; j < n;j++){
                    if(ascending){
                        if(data.flights[j].tujuan.compareTo(data.flights[min_index].tujuan) < 0){
                        min_index = j;
                        }
                    }else{
                        if(data.flights[j].tujuan.compareTo(data.flights[min_index].tujuan) > 0){
                        min_index = j;
                        }
                    }
                }
                Flight temp = data.flights[min_index];
                data.flights[min_index] = data.flights[i];
                data.flights[i] = temp;
            }
            for (int i = 0; i < data.count; i++) {
                pencarian_data.tampilkanDetailFlight(data.flights[i]);
                }
            System.out.println("Total: " + data.count + " penerbangan");
        }else if (sort == 5){
            System.out.print("\nSort by harga ");
            if(ascending){
                System.out.println(" - Ascending");
            }else{
                System.out.println(" - Descending");
            }
            System.out.println("----------------------------------");
            for (int i = 0; i < n - 1;i++){
                int min_index = i;
                for (int j = i + 1; j < n;j++){
                    if(ascending){
                        if(data.flights[j].harga < data.flights[min_index].harga){
                        min_index = j;
                        }
                    }else{
                        if(data.flights[j].harga > data.flights[min_index].harga){
                        min_index = j;
                        }
                    }
                }
                Flight temp = data.flights[min_index];
                data.flights[min_index] = data.flights[i];
                data.flights[i] = temp;
            }
            for (int i = 0; i < data.count; i++) {
                pencarian_data.tampilkanDetailFlight(data.flights[i]);
                }
            System.out.println("Total: " + data.count + " penerbangan");
        }else if (sort == 6){
            System.out.print("\nSort by tanggal ");
            if(ascending){
                System.out.println(" - Ascending");
            }else{
                System.out.println(" - Descending");
            }
            System.out.println("----------------------------------");
            for (int i = 0; i < n - 1;i++){
                int min_index = i;
                for (int j = i + 1; j < n;j++){
                    if(ascending){
                        if(data.flights[j].tanggal.compareTo(data.flights[min_index].tanggal) < 0){
                        min_index = j;
                        }
                    }else{
                        if(data.flights[j].tanggal.compareTo(data.flights[min_index].tanggal) > 0){
                        min_index = j;
                        }
                    }
                }
                Flight temp = data.flights[min_index];
                data.flights[min_index] = data.flights[i];
                data.flights[i] = temp;
            }
            for (int i = 0; i < data.count; i++) {
                pencarian_data.tampilkanDetailFlight(data.flights[i]);
                }
            System.out.println("Total: " + data.count + " penerbangan");
        }else{
            System.out.println("Pilihan tidak valid!");
        }
    }
}