package se.lexicon.model;

import java.util.Objects;

public abstract class Product {

    private static int sequencer = 0;
    private int id;
    private double price;
    private String productName;

    public Product(double price, String productName) {
        id = getNextId();
        setPrice(price);
        setProductName(productName);
    }

    private static int getNextId() {
        return ++sequencer;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price <= 0) throw new IllegalArgumentException("Price needs to be larger then 0");
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        //Objects.requireNonNull(productName, "Product Name should not be null!");
        if(productName == null || productName.trim().isEmpty()) throw new IllegalArgumentException("Product name can't be null or empty.");
        this.productName = productName;
    }

    // Detail information about the product
    public abstract String examine();

    // Summary of the product
    public abstract String use();
}
