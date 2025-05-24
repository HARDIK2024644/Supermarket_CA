/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//GIT HUB REPOSITORY LINK - https://github.com/CCT-Dublin/programming-object-oriented-approach-final-ca-HARDIK2024644.git
package shopping;

import java.util.Scanner;

/**
 *
 * 
 */
public class Supermarket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Scanner object to capture user input
        Scanner scanner = new Scanner(System.in);
        
        // Create a new shopping trolley (cart)
        ShoppingTrolley trolley = new ShoppingTrolley();

        // Display welcome message
        System.out.println("=================================");
        System.out.println("    Welcome to Easy Supermarket  ");
        System.out.println("=================================");

        // Define available products in the store
        Product[] products = {
            new Fruit("Apple", 0.50),
            new Fruit("Banana", 0.30),
            new Snack("Chips", 1.20),
            new Snack("Chocolate", 0.99),
            new Vegetable("Carrot", 0.40),
            new Vegetable("Potato", 0.25),
            new Drink("Water Bottle", 1.00),
            new Drink("Orange Juice", 1.50)
        };

        boolean shopping = true;
        double totalCost = 0.0; // Running total of purchase

        // Main shopping loop
        while (shopping) {
            System.out.println("\n--- Available Products ---");
            // List all products with numbering
            for (int i = 0; i < products.length; i++) {
                System.out.println((i + 1) + ". " + products[i]);
            }
            System.out.println((products.length + 1) + ". Checkout");

            System.out.print("Select item number: ");
            // Check if input is a valid number
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
                continue;
            }
            int choice = scanner.nextInt();

            if (choice == products.length + 1) {
                // User chose to checkout
                shopping = false;
            } else if (choice >= 1 && choice <= products.length) {
                // Valid product choice
                System.out.print("Enter quantity: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid quantity. Try again.");
                    scanner.next(); // Clear invalid input
                    continue;
                }
                int qty = scanner.nextInt();

                if (qty <= 0) {
                    System.out.println("Invalid quantity. Must be more than 0.");
                    continue;
                }

                // Add the selected product to the trolley multiple times
                for (int i = 0; i < qty; i++) {
                    trolley.buyItem(products[choice - 1]);
                }
                // Update total cost
                totalCost += products[choice - 1].getPrice() * qty;
                System.out.println(qty + " x " + products[choice - 1].getName() + " added to trolley.");
            } else {
                // Invalid product choice
                System.out.println("Invalid choice. Please try again.");
            }
        }

        // Checkout summary
        System.out.println("\n--- Checkout ---");
        String boughtItems = trolley.emptyTrolley();
        System.out.println("Items bought:\n" + boughtItems);
        System.out.printf("Total Cost: €%.2f\n", totalCost);

        System.out.println("\nThank you for shopping with us!");
        scanner.close();
    }
        
    }
    

