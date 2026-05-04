// Kelas abstrak sebagai blueprint untuk semua mata kuliah
public abstract class MataKuliah {
    protected String nama;
    protected int tugas, kuis, uts, uas;
    protected double nilaiAkhir;

    public MataKuliah(String nama) {
        this.nama = nama;
    }

    public void setNilai(int tugas, int kuis, int uts, int uas) {
        this.tugas = tugas;
        this.kuis = kuis;
        this.uts = uts;
        this.uas = uas;
    }

    // Setiap mata kuliah memiliki rumus perhitungan yang berbeda
    public abstract double hitungNilaiAkhir();

    public String getNama() {
        return nama;
    }

    public double getNilaiAkhir() {
        return nilaiAkhir;
    }
}
