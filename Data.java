import java.util.Scanner;

public class Data {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah data penerbangan: ");
        int jumlah = input.nextInt();
        input.nextLine(); 

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

            flights.add(new Flight(kode, asal, tujuan, waktu));
        }

        System.out.println("\n=== DATA PENERBANGAN ===");
        for (Flight f : flights) {
            System.out.println(f);
        }
    }
}
