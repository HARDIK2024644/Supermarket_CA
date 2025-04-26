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
        Scanner scanner = new Scanner(System.in);
        ShoppingTrolley trolley = new ShoppingTrolley();

        System.out.println("=================================");
        System.out.println("    Welcome to Easy Supermarket  ");
        System.out.println("=================================");

        // Sample products
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
        double totalCost = 0.0;

        while (shopping) {
            System.out.println("\n--- Available Products ---");
            for (int i = 0; i < products.length; i++) {
                System.out.println((i + 1) + ". " + products[i]);
            }
            System.out.println((products.length + 1) + ". Checkout");

            System.out.print("Select item number: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear wrong input
                continue;
            }
            int choice = scanner.nextInt();

            if (choice == products.length + 1) {
                shopping = false;
            } else if (choice >= 1 && choice <= products.length) {
                System.out.print("Enter quantity: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid quantity. Try again.");
                    scanner.next(); // clear wrong input
                    continue;
                }
                int qty = scanner.nextInt();

                if (qty <= 0) {
                    System.out.println("Invalid quantity. Must be more than 0.");
                    continue;
                }

                for (int i = 0; i < qty; i++) {
                    trolley.buyItem(products[choice - 1]);
                }
                totalCost += products[choice - 1].getPrice() * qty;
                System.out.println(qty + " x " + products[choice - 1].getName() + " added to trolley.");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("\n--- Checkout ---");
        String boughtItems = trolley.emptyTrolley();
        System.out.println("Items bought:\n" + boughtItems);
        System.out.printf("Total Cost: €%.2f\n", totalCost);

        System.out.println("\nThank you for shopping with us!");
        scanner.close();
    }
        
    }
    

