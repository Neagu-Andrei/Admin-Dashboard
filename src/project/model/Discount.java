package project.model;

import java.util.Scanner;

public class Discount {
    private Float discount;
    private String discountDescription;

    public Discount() { }

    public Discount(Float discount) { this.discount = discount; }

    public Discount(String discountDescription) { this.discountDescription = discountDescription; }

    public Discount(Float discount, String discountDescription) {
        this.discount = discount;
        this.discountDescription = discountDescription;
    }

    public Float getDiscount() { return discount; }

    public void setDiscount(Float discount) { this.discount = discount; }

    public String getDiscountDescription() { return discountDescription; }

    public void setDiscountDescription(String discountDescription) { this.discountDescription = discountDescription; }

    public void readDiscount(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti discount ul: ");
        this.discount = scanner.nextFloat();
        System.out.println("Introduceti o descriere a discountului: ");
        this.discountDescription = scanner.nextLine();
        scanner.nextLine();
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discount=" + discount +
                ", discountDescription='" + discountDescription + '\'' +
                '}';
    }
}
