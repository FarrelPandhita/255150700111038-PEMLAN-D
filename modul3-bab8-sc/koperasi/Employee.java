package koperasi;

// class Employee
public class Employee implements Payable {

    private int registrationNumber;
    private String name;
    private int salaryPerMonth;
    private Invoice[] invoices;

    public Employee(int registrationNumber, String name, int salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }

    @Override
    public int getPayableAmount() {
        int totalBelanja = 0;
        for (Invoice inv : invoices) {
            totalBelanja += inv.getPayableAmount();
        }
        return salaryPerMonth - totalBelanja;
    }

    public void display() {
        System.out.println("=== Data Karyawan ===");
        System.out.println("No Registrasi: " + registrationNumber);
        System.out.println("Nama: " + name);
        System.out.println("Gaji per bulan: " + salaryPerMonth);
        System.out.println();

        System.out.println("=== Detail Belanja ===");
        for (Payable p : invoices) { // polimorfisme
            ((Invoice) p).display();
        }

        System.out.println("Total Gaji setelah potongan: " + getPayableAmount());
    }
}