package se.lexicon.Option2.model;

import java.util.Objects;

public class SnackBar implements Product {
    private int id;
    private double price;
    private String productName;

    private boolean nuts;

    public SnackBar(double price, String productName, boolean nuts) {
        setPrice(price);
        setProductNAme(productName);
        setNuts(nuts);
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

    public boolean isNuts() {
        return nuts;
    }

    public void setNuts(boolean nuts) {
        this.nuts = nuts;
    }

    @Override
    public String examine() {
        return use() + ", Nuts: " + isNuts();
    }

    @Override
    public String use() {
        return "ID: " + getId() + ", Product Name: " + getProductName() + ", Price: " + getPrice();
    }
}
