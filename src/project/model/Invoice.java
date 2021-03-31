package project.model;

import java.util.ArrayList;
import java.util.Date;

public class Invoice {
    private Date date;
    private Double sum;
    private ArrayList<Product> products;

    public Invoice(ArrayList<Product> products) {
        this.date = new Date();
        this.products = products;
        setSum();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSum() {
        for (int i=0; i<= products.size(); i++){
            sum += products.get(i).getPrice().getPurchasePrice();
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public int findProduct(Product product){
        for (int i=0;i<this.products.size();i++){
            if (product.getCode() ==products.get(i).getCode())
                return i;
        }
        return -1;
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
        this.sum += product.getPrice().getPurchasePrice();
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "date=" + date +
                ", sum=" + sum +
                ", products=" + products +
                '}';
    }

}
