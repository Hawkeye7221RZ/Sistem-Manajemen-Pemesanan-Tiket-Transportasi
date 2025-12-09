import java.util.Scanner;
public class Data1 {

    static class Flight {
        String id;
        String pesawat;
        String asal;
        String tujuan;
        int harga;
        String tanggal;

        public Flight(String inputId, String inputPesawat,
                      String inputAsal, String inputTujuan,
                      int inputHarga, String inputTanggal) {

            id = inputId;
            pesawat = inputPesawat;
            asal = inputAsal;
            tujuan = inputTujuan;
            harga = inputHarga;
            tanggal = inputTanggal;
        }

        public String getId() {
            return id;
        }
    }

    public static void main(String[] args) {

        Flight f1 = new Flight(
                "GA123",
                "Garuda Indonesia",
                "Jakarta",
                "Bali",
                1500000,
                "10 Desember 2025"
        );

        // Print data untuk memastikan
        System.out.println("ID        : " + f1.getId());
        System.out.println("Pesawat   : " + f1.pesawat);
        System.out.println("Asal      : " + f1.asal);
        System.out.println("Tujuan    : " + f1.tujuan);
        System.out.println("Harga     : " + f1.harga);
        System.out.println("Tanggal   : " + f1.tanggal);
    }
}
