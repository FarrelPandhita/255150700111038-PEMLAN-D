// Rumus: Rata-rata sederhana (Tugas + Kuis + UTS + UAS) / 4
public class Pemlan extends MataKuliah {
    public Pemlan() {
        super("Pemlan");
    }

    public double hitungNilaiAkhir() {
        nilaiAkhir = (tugas + kuis + uts + uas) / 4.0;
        return nilaiAkhir;
    }
}
