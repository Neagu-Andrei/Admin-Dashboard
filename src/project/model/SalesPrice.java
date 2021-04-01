package project.model;

import java.util.Scanner;

public class SalesPrice extends Price {
    private Double salesPrice;

    public SalesPrice() { }

    public SalesPrice(Double purchasePrice, Discount discount, Float VAT, Double salesPrice) {
        super(purchasePrice, discount, VAT);
        this.salesPrice = salesPrice;
    }

    public Double getPurchasePrice() {
        return salesPrice;
    }

    public void setPurchasePrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public void readSalesPrice(){
        Scanner scanner = new Scanner(System.in);
        this.readPrice();
        System.out.println("Citeste pretul de vanzare: ");
        this.salesPrice = scanner.nextDouble();
    }
}
