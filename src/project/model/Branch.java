package project.model;

import java.util.ArrayList;


public class Branch {
    private static int number = 0;
    private Adress adress;
    private ArrayList<Product> products;
    private ArrayList<Invoice> invoices;


    public Branch(){
        this.adress = new Adress();
        this.products = new ArrayList<>();
        this.invoices = new ArrayList<>();
    }

    public Branch(Adress adress, ArrayList<Product> products, ArrayList<Invoice> invoices) {
        this.number++;
        this.adress = adress;
        this.products = products;
        this.invoices = invoices;
    }

    public Adress getAdress() { return adress; }

    public void setAdress(Adress adress) { this.adress = adress; }

    public int getNumber() { return number; }

    public void addInvoice(Invoice invoice){
        ArrayList<Product> productsInInvoice = invoice.getProducts();
        for (Product product1: productsInInvoice)
            for (Product product2:this.products)
                if (product1.getCode() == product2.getCode()){
                    product2.setQuantity(product2.getQuantity() - product1.getQuantity());
                }
        this.invoices.add(invoice);
    }

    public void addProduct(Product product){
        boolean sem = false;
        for (Product product1: this.products)
            if (product.getCode() == product1.getCode()){
                product1.setQuantity(product1.getQuantity() + product.getQuantity());
                sem = true;
                break;
            }
        if (!sem){
            this.products.add(product);
        }
    }

    @Override
    public String toString() {
        return "Branch{" +
                "adress=" + adress +
                ", products=" + products +
                ", invoices=" + invoices +
                '}';
    }
}
