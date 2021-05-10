package project.model;

import java.util.Scanner;

public class ProductQuantity extends Product{
    private int quantity;


    public ProductQuantity() { }

    public ProductQuantity(String name, int code, SalesPrice price, String description, int quantity, Category category, int quantity1) {
        super(name, code, price, description, quantity, category);
        this.quantity = quantity1;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void readProduct() {
        Scanner scanner = new Scanner(System.in);
        super.readProduct();
        System.out.println("Numarul de produse: ");
        this.quantity = scanner.nextInt();
        scanner.nextLine();
    }

    @Override
    public String toString() {
        return "ProductQuantity{" +
                "quantity=" + quantity +
                '}';
    }
}
