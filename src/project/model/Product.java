package project.model;

public class Product {
    private String name;
    private int code;
    private Price price;
    private String description;
    private int quantity;
    private Category category;

    public Product() { }

    public Product(String name, int code, Price price, String description, Category category) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public Product(String name, int code, Price price, String description, int quantity, Category category) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
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

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", code=" + code +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
