package project.model;

import java.util.Set;

public class Distribuitor extends Company {

    private Set<Product> products;

    public Distribuitor() {}

    public Distribuitor(String name, Adress adress, String contactPerson, String email, int contactNumber, Set<Product> products) {
        super(name, adress, contactPerson, email, contactNumber);
        this.products = products;
    }

    public Set<Product> getProducts() { return products; }

    public void setProducts(Set<Product> products) { this.products = products; }
}
