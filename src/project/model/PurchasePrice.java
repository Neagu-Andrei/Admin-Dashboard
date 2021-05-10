package project.model;

import java.util.Scanner;

public class PurchasePrice extends SalesPrice {
    private Double purchasePrice;
    private Discount discount;
    private Float VAT;

    public PurchasePrice() {
        this.discount = new Discount();

    }

    public PurchasePrice(Double salesPrice, Double purchasePrice, Float VAT, Discount discount) {
        super(salesPrice);
        this.purchasePrice = purchasePrice;
        this.VAT = VAT;
        this.discount = new Discount(discount);
    }

    public PurchasePrice(Double purchasePrice, Discount discount, Float VAT) {
        this.purchasePrice = purchasePrice;
        this.discount = discount;
        this.VAT = VAT;
    }

    public Float getVAT() { return VAT; }

    public void setVAT(Float VAT) { this.VAT = VAT; }

    public Discount getDiscount() { return discount; }

    public void setDiscount(Discount discount) { this.discount = discount; }

    public void readPrice(){
        Scanner scanner = new Scanner(System.in);
        this.readSalesPrice();
        System.out.println("Pretul de cumparare: ");
        this.purchasePrice = scanner.nextDouble();
        System.out.println("Tva-ul aplicat produsului: ");
        this.VAT = scanner.nextFloat();
        discount.readDiscount();
        System.out.println("");
    }
    @Override
    public String toString() {
        return "Price{" +
                "purchasePrice=" + purchasePrice +
                ", discount=" + discount +
                ", VAT=" + VAT +
                '}';
    }
}
