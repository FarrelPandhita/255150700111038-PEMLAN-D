import java.io.FileReader;

public class BacaFileError {
    public static void main(String[] args) throws Exception {

        FileReader reader = new FileReader("data.txt");

        int karakter;

        while ((karakter = reader.read()) != -1) {
            System.out.print((char) karakter);
        }

        reader.close();
    }
}