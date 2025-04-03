package se.lexicon.Option1.model;

public class Chips extends Product {

    private boolean ribbed;

    public Chips(double price, String productName, boolean ribbed){
        super(price, productName);
        this.ribbed = ribbed;
    }

    public boolean isRibbed() {
        return ribbed;
    }

    @Override
    public String examine() {
        return use() + ", Carbonated: " + isRibbed();
    }

    @Override
    public String use() {
        return "ID: " + getId() + ", Product Name: " + getProductName() + ", Price: " + getPrice();
    }
}
