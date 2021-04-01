package project.model;

import java.util.Scanner;

public class Price {
    private Double purchasePrice;
    private Discount discount;
    private Float VAT;

    public Price() {
        this.discount = new Discount();

    }

    public Price(Double purchasePrice, Float VAT) {
        this.purchasePrice = purchasePrice;
        this.VAT = VAT;
    }

    public Price(Double purchasePrice, Discount discount, Float VAT) {
        this.purchasePrice = purchasePrice;
        this.discount = discount;
        this.VAT = VAT;
    }

    public Double getSalesPrice() { return purchasePrice; }

    public void setSalesPrice(Double purchasePrice) { this.purchasePrice = purchasePrice; }

    public Float getVAT() { return VAT; }

    public void setVAT(Float VAT) { this.VAT = VAT; }

    public Discount getDiscount() { return discount; }

    public void setDiscount(Discount discount) { this.discount = discount; }

    public void readPrice(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pretul de cumparare: ");
        this.purchasePrice = scanner.nextDouble();
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
