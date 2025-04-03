package se.lexicon.Option2.model;

import java.util.Objects;

public class Chips implements Product{
    private int id;
    private double price;
    private String productName;

    private boolean ribbed;

    public Chips(double price, String productName, boolean ribbed) {
        setPrice(price);
        setProductNAme(productName);
        setRibbed(ribbed);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) { this.id = id; }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public void setProductNAme(String productName) {
        Objects.requireNonNull(productName, "ProductName should not be null!");
        if(productName.trim().isEmpty()) throw new IllegalArgumentException("ProductName should not be empty.");
        this.productName = productName;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        Objects.requireNonNull(price, "Price should not be null!");
        if(price <= 0 ) throw new IllegalArgumentException("Price should not be 0 or lower.");
        this.price = price;
    }

    public boolean isRibbed() {
        return ribbed;
    }

    public void setRibbed(boolean ribbed) {
        this.ribbed = ribbed;
    }

    @Override
    public String examine() {
        return use() + ", Carbonated: " + isRibbed();
    }

    @Override
    public String use() {
        return "ID: " + id + ", Product Name: " + productName + ", Price: " + price;
    }
}
