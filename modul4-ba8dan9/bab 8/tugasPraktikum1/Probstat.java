// Rumus: Tugas 10%, Kuis 20%, UTS 30%, UAS 40%
public class Probstat extends MataKuliah {
    public Probstat() {
        super("Probstat");
    }

    public double hitungNilaiAkhir() {
        nilaiAkhir = (tugas * 0.1) + (kuis * 0.2) + (uts * 0.3) + (uas * 0.4);
        return nilaiAkhir;
    }
}
