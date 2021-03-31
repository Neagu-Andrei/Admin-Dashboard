package project.model;

public class Price {
    private Double salesPrice;
    private Double purchasePrice;
    private Discount discount;
    private Float VAT;

    public Price() { }

    public Price(Double salesPrice, Float VAT) {
        this.salesPrice = salesPrice;
        this.VAT = VAT;
    }

    public Price(Double salesPrice, Discount discount, Float VAT) {
        this.salesPrice = salesPrice;
        this.discount = discount;
        this.VAT = VAT;
    }

    public Price(Double salesPrice, Double purchasePrice, Discount discount, Float VAT) {
        this.salesPrice = salesPrice;
        this.purchasePrice = purchasePrice;
        this.discount = discount;
        this.VAT = VAT;
    }

    public Double getPurchasePrice() { return purchasePrice; }

    public void setPurchasePrice(Double purchasePrice) { this.purchasePrice = purchasePrice; }

    public Double getSalesPrice() { return salesPrice; }

    public void setSalesPrice(Double salesPrice) { this.salesPrice = salesPrice; }

    public Float getVAT() { return VAT; }

    public void setVAT(Float VAT) { this.VAT = VAT; }

    @Override
    public String toString() {
        return "Price{" +
                "salesPrice=" + salesPrice +
                ", purchasePrice=" + purchasePrice +
                ", VAT=" + VAT +
                '}';
    }
}
