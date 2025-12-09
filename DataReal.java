import java.util.ArrayList;
import java.util.Scanner;
public class DataReal {

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
        public int getHarga() { return harga; }
        public String getPesawat() { return pesawat; }
        public int getbulan() { return bulan; }
        public int getTanggal() { return tanggal; } 
    }

    public static ArrayList<Flight> inputData() {
        Scanner input = new Scanner(System.in);
        ArrayList<Flight> list = new ArrayList<>();
           while (true) {
            System.out.println("\n--- Input Data Penerbangan (ketik 'stop' untuk selesai) ---");
            System.out.print("ID: ");
            String id = input.next();

            if (id.equalsIgnoreCase("stop")) {
                break;
            }

            System.out.print("Pesawat: ");
            String pesawat = input.next();
            System.out.print("Asal: ");
            String asal = input.next();
            System.out.print("Tujuan: ");
            String tujuan = input.next();
            System.out.print("Harga: ");
            int harga = input.nextInt();
            System.out.print("Tanggal: ");
            int tanggal = input.nextInt();
            System.out.print("Bulan: ");
            int bulan = input.nextInt();

            list.add(new Flight(id, pesawat, asal, tujuan, harga, tanggal, bulan));
        }

        return list;
    }

    public static void main(String[] args) {
        ArrayList<Flight> data = inputData();
    }
}