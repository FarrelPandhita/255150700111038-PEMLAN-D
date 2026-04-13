public class Main {
    public static void main(String[] args) {
        Kue kue[] = new Kue[20];
        for (int i = 0; i < kue.length; i++) {
            if (i % 2 == 0) {
                kue[i] = new KuePesanan("Kue Pesanan " + (i + 1), 10000, 1.5 + (i * 0.1));
            } else {
                kue[i] = new KueJadi("Kue Jadi " + (i + 1), 20000, 5 + i);
            }
        }
        System.out.println("=== Daftar Semua Kue ===");
        for (Kue k : kue) {
            String jenis = (k instanceof KuePesanan) ? "Kue Pesanan" : "Kue Jadi";
            System.out.println(k.toString() + " - Jenis: " + jenis);
        }
        System.out.println("============================================\n");
        
        double totalHargaSemua = 0;
        for (Kue k : kue) {
            totalHargaSemua += k.hitungHarga();
        }
        System.out.printf("Total harga semua jenis kue: Rp%.2f\n", totalHargaSemua);

        double totalHargaPesanan = 0;
        double totalBeratPesanan = 0;
        for (Kue k : kue) {
            if (k instanceof KuePesanan) {
                totalHargaPesanan += k.hitungHarga();
                totalBeratPesanan += ((KuePesanan) k).getBerat();
            }
        }
        System.out.printf("\nTotal harga Kue Pesanan: Rp%.2f\n", totalHargaPesanan);
        System.out.printf("Total berat Kue Pesanan: %.2f\n", totalBeratPesanan);
        
        
        double totalHargaJadi = 0;
        double totalJumlahJadi = 0;
        for (Kue k : kue) {
            if (k instanceof KueJadi) {
                totalHargaJadi += k.hitungHarga();
                totalJumlahJadi += ((KueJadi) k).getJumlah();
            }
        }
        System.out.printf("\nTotal harga Kue Jadi: Rp%.2f\n", totalHargaJadi);
        System.out.printf("Total jumlah Kue Jadi: %.2f\n", totalJumlahJadi);
        
        Kue kueTermahal = kue[0];
        for (Kue k : kue) {
            if (k.hitungHarga() > kueTermahal.hitungHarga()) {
                kueTermahal = k;
            }
        }
        System.out.println("\nKue dengan harga akhir terbesar:");
        System.out.printf("%s | Harga Akhir: Rp%.2f\n", kueTermahal.toString(), kueTermahal.hitungHarga());
    }
}
