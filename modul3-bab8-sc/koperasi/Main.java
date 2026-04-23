package koperasi;

// class Main
public class Main {
    public static void main(String[] args) {

        Invoice inv1 = new Invoice("Beras", 2, 50000);
        Invoice inv2 = new Invoice("Minyak", 1, 30000);
        Invoice inv3 = new Invoice("Gula", 3, 15000);

        Invoice[] daftarInvoice = {inv1, inv2, inv3};

        Employee emp = new Employee(101, "el coder", 2000000, daftarInvoice);

        emp.display();
    }
}