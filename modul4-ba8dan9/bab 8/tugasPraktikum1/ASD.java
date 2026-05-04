// Rumus: Tugas 15%, Kuis 25%, UTS 25%, UAS 35%
public class ASD extends MataKuliah {
    public ASD() {
        super("ASD");
    }

    public double hitungNilaiAkhir() {
        nilaiAkhir = (tugas * 0.15) + (kuis * 0.25) + (uts * 0.25) + (uas * 0.35);
        return nilaiAkhir;
    }
}
