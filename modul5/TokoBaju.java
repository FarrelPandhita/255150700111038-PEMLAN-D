import java.util.Scanner;
public class TokoBaju {
    static final int hargaJaketA = 100000;
    static final int hargaJaketB = 125000;
    static final int hargaJaketC = 175000;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalHargaA, totalHargaB, totalHargaC  = 0;
        System.out.println("Mau beli Jaket A berapa: ");
        int jumlahBeliA = sc.nextInt();

        System.out.println("Mau beli Jaket B berapa: ");
        int jumlahBeliB = sc.nextInt();

        System.out.println("Mau beli Jaket C berapa: ");
        int jumlahBeliC = sc.nextInt();


        totalHargaA = (jumlahBeliA > 100) ? (jumlahBeliA * 95000) : (jumlahBeliA * hargaJaketA);
        totalHargaB = (jumlahBeliB > 100) ? (jumlahBeliB * 120000) : (jumlahBeliB * hargaJaketB);
        totalHargaC = (jumlahBeliC > 100) ? (jumlahBeliC * 160000) : (jumlahBeliC * hargaJaketC);


        System.out.println("total harga jaket A:  "+ totalHargaA);
        System.out.println("total harga jaket B:  "+ totalHargaB);
        System.out.println("total harga jaket C:  "+ totalHargaC);

    }
}
