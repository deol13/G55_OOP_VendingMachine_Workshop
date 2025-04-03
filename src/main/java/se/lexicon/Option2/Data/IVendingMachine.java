package se.lexicon.Option2.Data;

import se.lexicon.Option2.model.Product;

public interface IVendingMachine {
    void addCurrency(int amount);
    int getBalance();
    Product request(int id);
    int endSession();
    String getDescription(int id);
    String[] getProducts();
}
