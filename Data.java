import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Flight> flights = new ArrayList<Flight>();

        System.out.print("Masukkan jumlah data penerbangan: ");
        int jumlah = input.nextInt();
        input.nextLine(); // clear buffer

        for(int i = 0; i < jumlah; i++){
            System.out.println("Data penerbangan ke-" + (i + 1));

            System.out.print("Masukkan kode penerbangan: ");
            String kode = input.nextLine();

            System.out.print("Masukkan asal penerbangan: ");
            String asal = input.nextLine();

            System.out.print("Masukkan tujuan penerbangan: ");
            String tujuan = input.nextLine();

            System.out.print("Masukkan waktu penerbangan: ");
            String waktu = input.nextLine();

            // masukkan ke ArrayList
            flights.add(new Flight(kode, asal, tujuan, waktu));
        }

        // Optional: Menampilkan semua input
        System.out.println("\n=== DATA PENERBANGAN ===");
        for (Flight f : flights) {
            System.out.println(f);
        }
    }
}
