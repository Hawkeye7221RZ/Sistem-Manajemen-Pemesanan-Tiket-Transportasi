import java.util.ArrayList;
import java.util.Scanner;
public class Data1 {

    static class Flight {
        String id;
        String pesawat;
        String asal;
        String tujuan;
        int harga;
        int bulan;
        int tanggal;

        public Flight(String inputId, String inputPesawat,
                      String inputAsal, String inputTujuan,
                      int inputHarga, int inputTanggal, int inputbulan) {

            id = inputId;
            pesawat = inputPesawat;
            asal = inputAsal;
            tujuan = inputTujuan;
            harga = inputHarga;
            bulan = inputbulan;
            tanggal = inputTanggal;
        }

        public String getId() { return id; }
        public String getAsal() { return asal; }
        public String getTujuan() { return tujuan; }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Flight> list = new ArrayList<>();
        int jumlahh = input.nextInt();
        
        
        for (int i = 0; i < jumlahh; i++) {
            System.out.println("\n----Penerbangan ke-" + (i + 1)+ "----");
            System.out.print("ID: ");
            String id = input.next();
            System.out.print("Pesawat: ");
            String pesawat = input.next();
            System.out.print("Asal: ");
            String asal = input.next();
            System.out.print("Tujuan: ");
            String tujuan = input.next();
            System.out.print("Harga: ");
            int harga = input.nextInt();
            System.out.print("Tanggal: ");
            String tanggal = input.next();

             list.add(new Flight(id, pesawat, asal, tujuan, harga, tanggal));
        }
            System.out.println("===== Data Penerbangan =====");
            int jumlah= input.nextInt();
            for (Flight f : list) {
                System.out.println("\n---------------------------");
                System.out.println("ID: " + f.getId());
                System.out.println("Asal: " + f.getAsal());
                System.out.println("Tujuan: " + f.getTujuan());
            }
        }
    }