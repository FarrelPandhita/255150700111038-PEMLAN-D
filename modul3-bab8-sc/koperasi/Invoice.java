package koperasi;

// class Invoice
public class Invoice implements Payable {

    private String productName;
    private int quantity;
    private int pricePerItem;

    public Invoice(String productName, int quantity, int pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    @Override
    public int getPayableAmount() {
        return quantity * pricePerItem;
    }

    public void display() {
        System.out.println("Produk: " + productName);
        System.out.println("Jumlah: " + quantity);
        System.out.println("Harga per item: " + pricePerItem);
        System.out.println("Total: " + getPayableAmount());
        System.out.println();
    }
}