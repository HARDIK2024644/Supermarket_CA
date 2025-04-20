/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shopping;

import java.util.Scanner;

/**
 *
 * @author kheal
 */
public class Supermarket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create scanner for user input
        Scanner scanner = new Scanner(System.in);
        // Create shopping bag (trolley) using given class
        ShoppingTrolley myBag = new ShoppingTrolley();

        // Create sample products
        Product[] products = {
            new Fruit("Apple", 0.50),
            new Fruit("Banana", 0.30),
            new Snack("Chips", 1.20),
            new Snack("Chocolate", 0.99)
        };

        // Infinite loop until checkout
        while (true) {
            // Show product menu
            System.out.println("\nAvailable Items:");
            for (int i = 0; i < products.length; i++) {
                System.out.println((i + 1) + ". " + products[i].toString());
            }
            System.out.println((products.length + 1) + ". Proceed to Checkout");

            // Ask user choice
            System.out.print("Choose item number: ");
            int choice = scanner.nextInt();

            if (choice == products.length + 1) {
                break; // Go to checkout
            }

            // If invalid item number
            if (choice < 1 || choice > products.length) {
                System.out.println("Invalid choice, please try again.");
                continue;
            }

            // Ask for quantity
            System.out.print("Enter quantity: ");
            int qty = scanner.nextInt();

            if (qty <= 0) {
                System.out.println("Invalid quantity. Try again.");
                continue;
            }

            // Add item to shopping trolley
            for (int i = 0; i < qty; i++) {
                myBag.buyItem(products[choice - 1]);
            }

            System.out.println(qty + " x " + products[choice - 1].getName() + " added to trolley.");
        }

        // Checkout: Print items and empty trolley
        System.out.println("\n--- Checkout ---");
        String items = myBag.emptyTrolley();
        System.out.println("Items bought:\n" + items);

        scanner.close();
    }
        
    }
    

