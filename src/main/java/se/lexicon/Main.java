package se.lexicon;

import se.lexicon.Option1.Data.VendingMachine;
import se.lexicon.Option1.model.Chips;
import se.lexicon.Option1.model.Drink;
import se.lexicon.Option1.model.Product;
import se.lexicon.Option1.model.SnackBar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product[] products = new Product[6];
        products[0] = new Drink(4, "Fanta", true);
        products[1] = new Drink(2, "Water", false);
        products[2] = new SnackBar(4, "Mars bar", false);
        products[3] = new SnackBar(6, "Mixed nuts", true);
        products[4] = new Chips(6, "Original Chips", false);
        products[5] = new Chips(8, "Smoked Chips", true);

        ConsoleUI.start(products);
    }

}