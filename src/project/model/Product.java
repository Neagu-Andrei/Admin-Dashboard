package project.model;

import java.util.Scanner;

public class Product {
    private String name;
    private int code;
    private SalesPrice price;
    private String description;
    private Category category;

    public Product() {
        this.price = new SalesPrice();
        this.category = new Category();
    }


    public Product(String name, int code, SalesPrice price, String description, Category category) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public SalesPrice getPrice() {
        return price;
    }

    public void setPrice(SalesPrice price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void readProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Numele produsului: ");
        this.name = scanner.nextLine();
        //scanner.nextLine();
        System.out.println("Citeste codul produsului: ");
        this.code = scanner.nextInt();
        this.price.readSalesPrice();
        System.out.println("Citeste descrierea");
        this.description = scanner.nextLine();
        scanner.nextLine();
        this.category.readCategory();
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", code=" + code +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
