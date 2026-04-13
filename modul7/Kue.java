public abstract class Kue{
    private String nama;
    private double harga;

    public Kue(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public abstract double hitungHarga();
    
    public String toString(){
        return String.format("Nama: %s, Harga Akhir: %.2f", nama, hitungHarga());
    }
    public double getHarga() {
        return harga;
    }
    public String getNama() {
        return nama;
    }
}