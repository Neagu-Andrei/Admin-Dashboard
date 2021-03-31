package project.model;

import java.util.ArrayList;

enum Tip{
    Storage,
    POS
}


public class Branch {
    private Tip tip;
    private Adress adress;
    private ArrayList<Product> products;
    private ArrayList<Invoice> invoices;


    public Branch(){ }

    public Branch(Tip tip, Adress adress, ArrayList<Product> products, ArrayList<Invoice> invoices) {
        this.tip = tip;
        this.adress = adress;
        this.products = products;
        this.invoices = invoices;
    }

    public Tip getTip() { return tip; }

    public void setTip(Tip tip) { this.tip = tip; }

    public Adress getAdress() { return adress; }

    public void setAdress(Adress adress) { this.adress = adress; }

    public ArrayList<Product> getStockAfterClose(){
        switch (this.tip){
            case POS:
                for (Product product: this.products) {
                    for (Invoice invoices: this.invoices){
                        
                    }
                }
        }
    }

    @Override
    public String toString() {
        return "Branch{" +
                "tip=" + tip +
                ", adress=" + adress +
                ", products=" + products +
                '}';
    }
}
