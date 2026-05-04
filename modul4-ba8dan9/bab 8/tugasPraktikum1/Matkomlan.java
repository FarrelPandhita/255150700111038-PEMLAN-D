// Rumus: Tugas 25%, Kuis 15%, UTS 30%, UAS 30%
public class Matkomlan extends MataKuliah {
    public Matkomlan() {
        super("Matkomlan");
    }

    public double hitungNilaiAkhir() {
        nilaiAkhir = (tugas * 0.25) + (kuis * 0.15) + (uts * 0.3) + (uas * 0.3);
        return nilaiAkhir;
    }
}
