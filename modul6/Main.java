public class Main {
    public static void main(String[] args) {
        Manusia people;

        // 1a. Laki-laki telah menikah
        people = new Manusia("Budi", "111", true, true);
        System.out.println(people);
        System.out.println();

        // 1b. Perempuan telah menikah
        people = new Manusia("Siti", "222", false, true);
        System.out.println(people);
        System.out.println();

        // 1c. Belum menikah
        people = new Manusia("Andi", "333", true, false);
        System.out.println(people);
        System.out.println();

        // 2a. IPK < 3
        people = new MahasiswaFILKOM("225150420000001", 2.75, "Rizky", "444", true, false);
        System.out.println(people);
        System.out.println();

        // 2b. IPK 3.0 - 3.5
        people = new MahasiswaFILKOM("215150320000001", 3.25, "Dewi", "555", false, false);
        System.out.println(people);
        System.out.println();

        // 2c. IPK 3.5 - 4.0
        people = new MahasiswaFILKOM("235150720000001", 3.85, "Fajar", "666", true, false);
        System.out.println(people);
        System.out.println();

        // 3a. Lama bekerja 2 tahun, anak 2
        people = new Pekerja(5000, 2024, 1, 1, 2, "Hendra", "777", true, true);
        System.out.println(people);
        System.out.println();

        // 3b. Lama bekerja 9 tahun
        people = new Pekerja(6000, 2017, 1, 1, 0, "Ratna", "888", false, false);
        System.out.println(people);
        System.out.println();

        // 3c. Lama bekerja 20 tahun, anak 10
        people = new Pekerja(8000, 2006, 1, 1, 10, "Agus", "999", true, true);
        System.out.println(people);
        System.out.println();

        // 4. Manager, lama bekerja 15 tahun, gaji $7500
        people = new Manager("IT", 7500, 2011, 1, 1, 0, "Diana", "1010", false, true);
        System.out.println(people);
    }
}
