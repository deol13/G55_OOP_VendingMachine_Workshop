package se.lexicon.Option2.Data;

import se.lexicon.Option2.model.Product;

public class VendingMachine implements IVendingMachine {
    public static final int[] VALID_DENOMINATIONS = {1,2,5,10,20,50,100,200,500,1000};

    private int depositPool;
    private Product[] products;

    public VendingMachine(Product[] products) {
        depositPool = 0;
        this.products = products;
    }

    @Override
    public void addCurrency(int amount) {
        if (isValidDenomination(amount))
            depositPool += amount;
        else throw new IllegalArgumentException("Error: Not a valid denomination!");
    }

    // Tip from Mehrdad's code
    private boolean isValidDenomination(int amount)  {
        boolean valid = false;
        for (int currency : VALID_DENOMINATIONS) {
            if (amount == currency) {
                valid = true;
                break;
            }
        }
        return valid;
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int id) {
        Product requestedProduct = findProductById(id);
        if(requestedProduct != null) {
            if(requestedProduct.getPrice() <= depositPool) {
                depositPool -= requestedProduct.getPrice();
            }
            else throw new IllegalArgumentException("Not enough deposit for product " + requestedProduct.getProductName());
        }
        else throw new IllegalArgumentException("No product with id " + id + " found!");

        return requestedProduct;
    }

    // Tip from Mehrdad's code
    private Product findProductById(int id) {
        Product requestedProduct = null;
        for (Product product : products) {
            if(product.getId() == id) {
                requestedProduct = product;
                break;
            }
        }
        return requestedProduct;
    }

    @Override
    public int endSession() {
        int sum = depositPool;
        depositPool = 0;
        return sum;
    }

    @Override
    public String getDescription(int id) {
        Product product = findProductById(id);
        if (product != null) {
            return product.examine();
        }
        else return "Product with id " + id +" not found!";
    }

    @Override
    public String[] getProducts() {
        String[] productsInfo = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            productsInfo[i] = products[i].use();
        }

        return productsInfo;
    }
}
