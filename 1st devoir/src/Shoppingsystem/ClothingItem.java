package Shoppingsystem;

import java.util.Scanner;

public class ClothingItem extends ShoppingItem{
    private String size;

    public ClothingItem(String itemId, String itemName, double price,
                        int stockAvailable, String size) {
        // Correct super call matching parent class constructor
        super(itemId, itemName, price, stockAvailable);
        this.size = size;
    }

    @Override
    public void updateStock(int quantity) {
        stockAvailable += quantity;
        System.out.println(itemName + " (" + size + ") stock updated to: " + stockAvailable);
    }

    @Override
    public boolean validateItem() {
        if (stockAvailable <= 0) {
            System.out.println(itemName + " is out of stock.");
            return false;
        }
        return true;
    }

    @Override
    public void displayDetails() {
        System.out.println("Clothing - " + itemName + " ($" + price + ")");
        System.out.println("  Size: " + size);
        System.out.println("  In Stock: " + stockAvailable);
    }
}