package se.lexicon;

import se.lexicon.Option1.Data.VendingMachine;
import se.lexicon.Option1.model.Chips;
import se.lexicon.Option1.model.Drink;
import se.lexicon.Option1.model.Product;
import se.lexicon.Option1.model.SnackBar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {

    // ANSI color codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String PURPLE = "\u001B[35m";

    public static void start(Product[] products) {
        VendingMachine vendingMachine = new VendingMachine(products);
        Scanner scanner = new Scanner(System.in);
        boolean session = true;

        System.out.println(CYAN + "Welcome to Odins Vending Machine"+ RESET);

        while (session){
            System.out.println("------------------");
            System.out.println(BLUE + "1: View Products"+ RESET);
            System.out.println(BLUE + "2: Insert money."+ RESET);
            System.out.println(BLUE + "3: Buy item"+ RESET);
            System.out.println(BLUE + "4: Check balance"+ RESET);
            System.out.println(BLUE + "5: Get more details of an item."+ RESET);
            System.out.println(BLUE + "6: End session"+ RESET);
            System.out.println("------------------");
            System.out.println(PURPLE + "Your choice: "+ RESET);

            String input = scanner.nextLine();
            int id = -1;

            switch (input) {
                case "1":
                    //System.out.println("List of items: ");
                    String[] productsInfo = vendingMachine.getProducts();
                    for (String item : productsInfo) {
                        System.out.println(GREEN + item + RESET);
                    };
                    break;
                case "2":
                    System.out.println(PURPLE + "Add a coin (1,2,5,10,20,50,100,200,500,1000)" + RESET);
                    try{
                        int amount  = Integer.parseInt(scanner.nextLine());
                        vendingMachine.addCurrency(amount);
                        System.out.println(GREEN + "You inserted: " + amount + " SEK" + RESET);
                    }
                    catch (Exception e) {
                        System.out.println(RED + "Invalid input: " + e.getMessage() + RESET);
                    }
                    break;
                case "3":
                    System.out.println(PURPLE + "Enter a product id to buy"  + RESET);
                    Product p = null;
                    try{
                        id  = Integer.parseInt(scanner.nextLine());
                        p = vendingMachine.request(id);
                        System.out.println("You bought: " + p.getProductName() + RESET);
                        System.out.println(GREEN + p.use() + RESET);
                    }
                    catch (Exception e) {
                        System.out.println(RED + "Error: " + e.getMessage() + RESET);
                    }
                    break;
                case "4":
                    System.out.println(CYAN + "Current balance: " + vendingMachine.getBalance()+ RESET);
                    break;
                case "5":
                    System.out.println(PURPLE + "Enter an id for the item you want know more about :"+ RESET);
                    try{
                        id  = Integer.parseInt(scanner.nextLine());
                        System.out.println(GREEN + "Here is the description of the item: " + vendingMachine.getDescription(id));
                    }
                    catch (Exception e) {
                        System.out.println(RED + "Error: " + e.getMessage() + RESET);
                    }
                    break;
                case "6":
                    System.out.println(YELLOW + "Your remaining change: " + vendingMachine.endSession() + RESET);
                    System.out.println(GREEN + "Ending session." + RESET);
                    session = false;
                    break;
            }



        }
    }
}
