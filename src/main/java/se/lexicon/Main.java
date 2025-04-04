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
        products[0] = new Drink(40, "Fanta", true);
        products[1] = new Drink(20, "Water", false);
        products[2] = new SnackBar(40, "Mars bar", false);
        products[3] = new SnackBar(60, "Mixed nuts", true);
        products[4] = new Chips(60, "Original Chips", false);
        products[5] = new Chips(80, "Smoked Chips", true);

        ConsoleUI.start(products);
    }

}