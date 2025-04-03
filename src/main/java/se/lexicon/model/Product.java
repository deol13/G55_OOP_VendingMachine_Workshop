package se.lexicon.model;

public abstract class Product {

    private static int sequencer = 0;
    private int id;
    private double price;
    private String productName;

    public Product(double price, String productName) {
        id = getNextId();
        // if the feature of adding products to the vending machine is added then these needs to be checked for null/empty.
        this.price = price;
        this.productName = productName;
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

    public String getProductName() {
        return productName;
    }

    // Detail information about the product
    public abstract String examine();

    // Summary of the product
    public abstract String use();
}
