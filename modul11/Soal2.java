import java.util.*;

public class Soal2 {
    
    // Custom method untuk menghitung frekuensi nilai dari hasil binary search
    public static int hitungFrekuensiBinary(List<Integer> list, int target) {
        int idx = Collections.binarySearch(list, target);
        if (idx < 0) return 0; // Tidak ditemukan
        
        int count = 1;
        // Hitung duplikat di sebelah kiri index
        int left = idx - 1;
        while (left >= 0 && list.get(left) == target) {
            count++;
            left--;
        }
        // Hitung duplikat di sebelah kanan index
        int right = idx + 1;
        while (right < list.size() && list.get(right) == target) {
            count++;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        // A. Implementasi ArrayList (Memisah Atribut)
        List<Integer> tinggiTimB = new ArrayList<>(Arrays.asList(170, 167, 165, 166, 168, 175, 172, 171, 168, 169));
        List<Integer> beratTimA = new ArrayList<>(Arrays.asList(50, 60, 56, 55, 58, 71, 68, 56, 72, 56));
        List<Integer> tinggiTimA = new ArrayList<>(Arrays.asList(168, 170, 165, 168, 172, 170, 169, 165, 171, 166));
        List<Integer> beratTimB = new ArrayList<>(Arrays.asList(66, 60, 59, 58, 60, 70, 66, 68, 65, 60));

        // Syarat mutlak binarySearch: Collection harus diurutkan terlebih dahulu (Ascending)
        Collections.sort(tinggiTimB);
        Collections.sort(beratTimA);

        // B. Mencari jumlah pemain Tim B dengan TB 168 cm dan 160 cm
        System.out.println("Jumlah pemain Tim B tinggi 168 cm: " + hitungFrekuensiBinary(tinggiTimB, 168));
        System.out.println("Jumlah pemain Tim B tinggi 160 cm: " + hitungFrekuensiBinary(tinggiTimB, 160));

        // C. Mencari jumlah pemain Tim A dengan BB 56 kg dan 53 kg
        System.out.println("\nJumlah pemain Tim A berat 56 kg: " + hitungFrekuensiBinary(beratTimA, 56));
        System.out.println("Jumlah pemain Tim A berat 53 kg: " + hitungFrekuensiBinary(beratTimA, 53));

        // D. Memeriksa apakah ada yang sama antara Tim A dan Tim B (Menggunakan Disjoint)
        // Disjoint mereturn true jika TIDAK ada irisan. Return false jika ADA nilai yang sama.
        boolean adaTinggiSama = !Collections.disjoint(tinggiTimA, tinggiTimB);
        boolean adaBeratSama = !Collections.disjoint(beratTimA, beratTimB);

        System.out.println("\nApakah ada kesamaan tinggi badan antara Tim A dan Tim B? " + (adaTinggiSama ? "Ya" : "Tidak"));
        System.out.println("Apakah ada kesamaan berat badan antara Tim A dan Tim B? " + (adaBeratSama ? "Ya" : "Tidak"));
    }
}
