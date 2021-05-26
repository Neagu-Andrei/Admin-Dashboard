package project.model;

import java.util.Scanner;

public class SalesPrice {
    private Double salesPrice;

    public SalesPrice() { }

    public SalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public void readSalesPrice(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Citeste pretul de vanzare: ");
        this.salesPrice = scanner.nextDouble();
    }

    @Override
    public String toString() {
        return "SalesPrice{" +
                "salesPrice=" + salesPrice +
                '}';
    }
}
