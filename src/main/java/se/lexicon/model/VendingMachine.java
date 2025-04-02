package se.lexicon.model;

public class VendingMachine implements IVendingMachine {
    private double depositPool;
    private Product[] products;
    private final int[] validCurrency = {1,2,5,10,20,50,100,200,500,1000};

    public VendingMachine(Product[] products) {
        depositPool = 0;
        this.products = products;
    }

    @Override
    public void addCurrency(int amount) {
        for (int currency : validCurrency) {
            if(amount == currency) {
                depositPool += amount;
                return;
            }
        }
        throw new IllegalArgumentException("Error: Not a valid coin!");
    }

    @Override
    public double getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int id) {
        Product selectedProduct = null;
        for (Product product : products) {
            if(product.getId() == id) {
                if(depositPool >= product.getPrice()) {
                    depositPool -= product.getPrice();
                    selectedProduct = product;
                }
                else throw new IllegalArgumentException("Error: Not enough in deposit pool for that product");
            }
        }
        return selectedProduct;
    }

    @Override
    public double endSession() {
        double sum = depositPool;
        depositPool = 0;
        return sum;
    }

    @Override
    public String getDescription(int id) {
        String info = null;
        for (Product product : products) {
            if(product.getId() == id) {
                info = product.examine();
                break;
            }
        }
        return info;
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
