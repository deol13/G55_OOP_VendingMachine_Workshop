package se.lexicon.Option2.model;

public interface Product {
    int getId();
    void setId(int id);
    String getProductName();
    void setProductNAme(String productName);
    double getPrice();
    void setPrice(double price);

    String examine();
    String use();
}
