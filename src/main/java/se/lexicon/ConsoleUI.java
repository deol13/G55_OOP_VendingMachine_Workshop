package se.lexicon;

import se.lexicon.Option2.Data.VendingMachine;
import se.lexicon.Option2.model.Product;
//import se.lexicon.Option1.Data.VendingMachine;
//import se.lexicon.Option1.model.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {
    public static void start(Product[] products) {
        VendingMachine vendingMachine = new VendingMachine(products);
        Scanner scanner = new Scanner(System.in);
        boolean session = true;

        while (session){
            System.out.println("Welcome to Odins Vending Machine");
            System.out.println("------------------");
            System.out.println("1: Add currency");
            System.out.println("2: Get the list of items offered.");
            System.out.println("3: Get the description of an item with its ID.");
            System.out.println("4: Request item with an ID.");
            System.out.println("5: Get your current balance.");
            System.out.println("6: End session");
            System.out.println("------------------");
            System.out.println("Your choice: ");

            String input = scanner.nextLine();
            int id = -1;

            switch (input) {
                case "1":
                    System.out.println("Add new amount (1,2,5,10,20,50,100,200,500,1000)");
                    try{
                        input = scanner.nextLine();
                        int amount = Integer.parseInt(input);
                        vendingMachine.addCurrency(amount);
                    }
                    catch (InputMismatchException e){
                        System.out.println("Only numbers allowed");
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    System.out.println("List of items: ");
                    String[] productsInfo = vendingMachine.getProducts();
                    for (String item : productsInfo) {
                        System.out.println(item);
                    };
                    break;
                case "3":
                    System.out.println("Input an id:");
                    try{
                        input = scanner.nextLine();
                        id = Integer.parseInt(input);
                        System.out.println(vendingMachine.getDescription(id));
                    } catch (InputMismatchException e){
                        System.out.println("Only numbers allowed");
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "4":
                    System.out.println("Input an id:");
                    Product p = null;
                    try{
                        input = scanner.nextLine();
                        id = Integer.parseInt(input);
                        p = vendingMachine.request(id);
                    } catch (InputMismatchException e){
                        System.out.println("Only numbers allowed");
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Here is your product: " + p.getProductName());
                    break;
                case "5":
                    System.out.println("Current balance: " + vendingMachine.getBalance());
                    break;
                case "6":
                    System.out.println("Your change: " + vendingMachine.endSession());
                    System.out.println("Ending session.");
                    session = false;
                    break;
            }



        }
    }
}
