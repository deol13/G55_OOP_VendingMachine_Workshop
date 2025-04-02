package se.lexicon.model;

public class Drink extends Product {

    private boolean carbonated;

    public Drink(double price, String productName, boolean carbonated){
        super(price, productName);
        this.carbonated = carbonated;
    }

    public boolean isCarbonated() {
        return carbonated;
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
