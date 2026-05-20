import java.util.*;

class Pemain {
    String nama;
    int tinggi;
    int berat;

    public Pemain(String nama, int tinggi, int berat) {
        this.nama = nama;
        this.tinggi = tinggi;
        this.berat = berat;
    }

    @Override
    public String toString() {
        return nama + " (Tinggi: " + tinggi + "cm, Berat: " + berat + "kg)";
    }
}

class SortByTinggiAsc implements Comparator<Pemain> {
    public int compare(Pemain a, Pemain b) { return a.tinggi - b.tinggi; }
}

class SortByBeratAsc implements Comparator<Pemain> {
    public int compare(Pemain a, Pemain b) { return a.berat - b.berat; }
}

public class Soal1 {
    public static void main(String[] args) {
        List<Pemain> timA = new ArrayList<>(Arrays.asList(
            new Pemain("A1", 168, 50), new Pemain("A2", 170, 60), new Pemain("A3", 165, 56),
            new Pemain("A4", 168, 55), new Pemain("A5", 172, 58), new Pemain("A6", 170, 71),
            new Pemain("A7", 169, 68), new Pemain("A8", 165, 56), new Pemain("A9", 171, 72),
            new Pemain("A10", 166, 56)
        ));

        List<Pemain> timB = new ArrayList<>(Arrays.asList(
            new Pemain("B1", 170, 66), new Pemain("B2", 167, 60), new Pemain("B3", 165, 59),
            new Pemain("B4", 166, 58), new Pemain("B5", 168, 60), new Pemain("B6", 175, 70),
            new Pemain("B7", 172, 66), new Pemain("B8", 171, 68), new Pemain("B9", 168, 65),
            new Pemain("B10", 169, 60)
        ));

        // A. Sorting Tinggi Badan
        Collections.sort(timA, new SortByTinggiAsc());
        System.out.println("Tim A Tinggi Asc: " + timA);
        Collections.sort(timA, Collections.reverseOrder(new SortByTinggiAsc()));
        System.out.println("Tim A Tinggi Desc: " + timA);

        // B. Sorting Berat Badan
        Collections.sort(timB, new SortByBeratAsc());
        System.out.println("\nTim B Berat Asc: " + timB);
        Collections.sort(timB, Collections.reverseOrder(new SortByBeratAsc()));
        System.out.println("Tim B Berat Desc: " + timB);

        // C. Nilai Maksimum dan Minimum
        Pemain maxTinggiA = Collections.max(timA, new SortByTinggiAsc());
        Pemain minTinggiA = Collections.min(timA, new SortByTinggiAsc());
        System.out.println("\nTim A - Max Tinggi: " + maxTinggiA + ", Min Tinggi: " + minTinggiA);

        // D. Copy Tim B ke Tim C
        List<Pemain> timC = new ArrayList<>(Arrays.asList(new Pemain[timB.size()]));
        Collections.copy(timC, timB);
        System.out.println("\nTim C (Hasil Copy dari Tim B): " + timC);
    }
}
