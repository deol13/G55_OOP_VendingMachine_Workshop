package se.lexicon.model;

public class SnackBar extends Product {

    private boolean nuts;

    public SnackBar(double price, String productName, boolean nuts){
        super(price, productName);
        this.nuts = nuts;
    }

    public boolean isNuts() {
        return nuts;
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
