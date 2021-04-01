package project.model;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Distribuitor extends Company {

    private HashSet<Product> products;

    public Distribuitor() {
        this.products = new HashSet<Product>();

    }

    public Distribuitor(String name, Adress adress, String contactPerson, String email, int contactNumber, HashSet<Product> products) {
        super(name, adress, contactPerson, email, contactNumber);
        this.products = products;
    }

    public HashSet<Product> getProducts() { return products; }

    public void setProducts(HashSet<Product> products) { this.products = products; }

    public void readDistribuitor(){
        Scanner scanner = new Scanner(System.in);
        this.readCompany();
        System.out.println("Numarul de produse ale distribuitorului: ");
        int numarProduse = scanner.nextInt();
        for (int i=0; i<numarProduse;i++){
            Product product = new Product();
            product.readProduct();
            this.products.add(product);
        }
    }
}
