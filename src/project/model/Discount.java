package project.model;

public class Discount {
    private Float discount;
    private String discountDescription;

    public Discount() { }

    public Discount(Float discount, String discountDescription) {
        this.discount = discount;
        this.discountDescription = discountDescription;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public String getDiscountDescription() {
        return discountDescription;
    }

    public void setDiscountDescription(String discountDescription) {
        this.discountDescription = discountDescription;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discount=" + discount +
                ", discountDescription='" + discountDescription + '\'' +
                '}';
    }
}
