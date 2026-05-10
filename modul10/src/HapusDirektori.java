import java.io.File;

public class HapusDirektori {
    public static void main(String[] args) {

        File direktori = new File("contohFolder");

        if (direktori.exists() && direktori.isDirectory()) {

            File[] daftarFile = direktori.listFiles();

            if (daftarFile != null) {

                for (File file : daftarFile) {

                    if (file.isFile()) {
                        file.delete();
                    }

                }
            }

            if (direktori.delete()) {
                System.out.println("Direktori berhasil dihapus.");
            } else {
                System.out.println("Direktori gagal dihapus.");
            }

        } else {
            System.out.println("Direktori tidak ditemukan.");
        }
    }
}