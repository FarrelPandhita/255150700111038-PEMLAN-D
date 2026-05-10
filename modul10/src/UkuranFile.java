import java.io.File;

public class UkuranFile {
    public static void main(String[] args) {

        File file = new File("test.txt");

        if (file.exists()) {

            double ukuranByte = file.length();

            if (ukuranByte < 1024 * 1024) {

                double ukuranKB = ukuranByte / 1024;
                System.out.printf("Ukuran file: %.2f KB%n", ukuranKB);

            } else {

                double ukuranMB = ukuranByte / (1024 * 1024);
                System.out.printf("Ukuran file: %.2f MB%n", ukuranMB);

            }

        } else {
            System.out.println("File tidak ditemukan.");
        }
    }
}