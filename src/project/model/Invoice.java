package project.model;

import java.util.Date;
import java.util.List;

public class Invoice {
    private Date date;
    private Double sum;
    private List<Product> products;

    public Invoice() { }

    public Invoice(Date date, Double sum, List<Product> products) {
        this.date = date;
        this.sum = sum;
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
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
