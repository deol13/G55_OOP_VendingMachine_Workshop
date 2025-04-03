package se.lexicon.Option2.model;

import java.util.Objects;

public class Drink implements Product{
    private int id;
    private double price;
    private String productName;

    private boolean carbonated;

    public Drink(double price, String productName, boolean carbonated) {
        setPrice(price);
        setProductNAme(productName);
        setCarbonated(carbonated);
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
    }

    public boolean isCarbonated() {
        return carbonated;
    }

    public void setCarbonated(boolean carbonated) {
        this.carbonated = carbonated;
    }

    @Override
    public String examine() {
        return use() + ", Carbonated: " + isCarbonated();
    }

    @Override
    public String use() {
        return "ID: " + getId() + ", Product Name: " + getProductName() + ", Price: " + getPrice();
    }
}
