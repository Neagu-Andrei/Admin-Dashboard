package project.model;

import java.util.ArrayList;
import java.util.Scanner;


public class Branch {
    private static int number = 0;
    private Adress adress;
    private ArrayList<ProductQuantity> products;
    private ArrayList<Invoice> invoices;


    public Branch(){
        this.adress = new Adress();
        this.products = new ArrayList<>();
        this.invoices = new ArrayList<>();
        number++;
    }

    public Branch(Adress adress, ArrayList<ProductQuantity> products, ArrayList<Invoice> invoices) {
        this.number++;
        this.adress = new Adress(adress);
        this.products = products;
        this.invoices = invoices;
    }

    public Adress getAdress() { return adress; }

    public void setAdress(Adress adress) { this.adress = adress; }

    public int getNumber() { return number; }

    public void addInvoice(Invoice invoice){
        ArrayList<ProductQuantity> productsInInvoice = invoice.getProducts();
        for (ProductQuantity product1: productsInInvoice)
            for (ProductQuantity product2:this.products)
                if (product1.getCode() == product2.getCode()){
                    product2.setQuantity(product2.getQuantity() - product1.getQuantity());
                }
        this.invoices.add(invoice);
    }

    public void addProduct(ProductQuantity product){
        boolean sem = false;
        for (ProductQuantity product1: this.products)
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

    public void readBranch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Citeste adresa branch-ului: ");
        this.adress.readAdress();
        System.out.println("Numarul de produse al branchului: ");
        int numarProduse = scanner.nextInt();
        for (int i=0; i<numarProduse;i++){
            ProductQuantity product = new ProductQuantity();
            product.readProduct();
            this.products.add(product);
        }
    }
}
