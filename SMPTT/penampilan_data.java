package SMPTT;

public class penampilan_data{
     public static void tampilkanSemuaFlight() {
        utama.tampilkanHeader("DAFTAR PENERBANGAN");
        
        if (data.isDataKosong()) {
            System.out.println("Belum ada data penerbangan.");
            return;
        }

        for (int i = 0; i < data.count; i++) {
            pencarian_data.tampilkanDetailFlight(data.flights[i]);
        }
        System.out.println("Total: " + data.count + " penerbangan");
    }
}