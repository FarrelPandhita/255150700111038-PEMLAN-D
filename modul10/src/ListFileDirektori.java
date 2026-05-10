import java.io.File;

public class ListFileDirektori {
    public static void main(String[] args) {

        File direktori = new File(".");

        File[] daftarFile = direktori.listFiles();

        if (daftarFile != null) {

            System.out.println("Daftar file dalam direktori:");

            for (File file : daftarFile) {
                System.out.println(file.getName());
            }

        } else {
            System.out.println("Direktori tidak ditemukan.");
        }
    }
}