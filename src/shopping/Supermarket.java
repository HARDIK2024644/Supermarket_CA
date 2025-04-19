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
        
        ShoppingTrolley myBag = new ShoppingTrolley(); //this is myBag. I can buy things to put in it.
        Scanner scanner = new Scanner(System.in);

        Product[] products = {
            new Fruit("Apple", 0.50),
            new Fruit("Banana", 0.30),
            new Snack("Chips", 1.20),
            new Snack("Chocolate", 0.99)
        };

        while (true) {
            System.out.println("\n--- Welcome to the Console Supermarket ---");
            for (int i = 0; i < products.length; i++) {
                System.out.println((i + 1) + ". " + products[i]);
            }
            System.out.println((products.length + 1) + ". Proceed to Checkout");

            System.out.print("Choose item number: ");
            int choice = scanner.nextInt();

            if (choice == products.length + 1) {
                break;
            }

            if (choice < 1 || choice > products.length) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int qty = scanner.nextInt();

            for (int i = 0; i < qty; i++) {
                myBag.buyItem(products[choice - 1]);
            }

            System.out.println(qty + " x " + products[choice - 1].getName() + " added to trolley.");
        }

        System.out.println("\n--- Checkout ---");
        String items = myBag.emptyTrolley();
        System.out.println("Items bought:\n" + items);

        scanner.close();
    }
        
    }
    

