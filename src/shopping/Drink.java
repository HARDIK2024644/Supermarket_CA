/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopping;

/**
 *
 * @author hardi
 */
public class Drink extends Product {

    public Drink(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Drink: " + name + " - €" + String.format("%.2f", price);
    }
    
}
