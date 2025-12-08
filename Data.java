import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    static class Flight {
        String id;
        String pesawat;
        String asal;
        String tujuan;
        double harga;
        String tanggal;

        public Flight(String inputid, String inputpesawat, String inputasal, String inputtujuan, double inputharga, String inputtanggal) {
            id = inputid;
            pesawat = inputpesawat;
            asal = inputasal;
            tujuan = inputtujuan;
            harga = inputharga;
            tanggal = inputtanggal;
        }

        public String getId() { return id; }
        public String getAsal() { return asal; }
        public String getTujuan() { return tujuan; }

        public String toString() {
            return "\nID: " + id +
                   "\nPesawat: " + pesawat +
                   "\nAsal: " + asal +
                   "\nTujuan: " + tujuan +
                   "\nHarga: Rp " + harga +
                   "\nTanggal: " + tanggal +
                   "\n---------------------------";
        }
    }

    static class Booking {
        String nama;
        Flight flight;

        public Booking(String nama, Flight flight) {
            this.nama = nama;
            this.flight = flight;
        }

        public String toString() {
            return "Nama: " + nama + "\nDetail Penerbangan: " + flight.toString();
        }
    }



    static ArrayList<Flight> flights = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        flights.add(new Flight("F001", "Garuda", "Jakarta", "Bali", 1200000, "25-12-2025"));
        flights.add(new Flight("F002", "Lion Air", "Bandung", "Surabaya", 850000, "10-01-2026"));
        flights.add(new Flight("F003", "AirAsia", "Jakarta", "Singapore", 1500000, "05-02-2026"));
