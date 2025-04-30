package Shoppingsystem;

public class ElectronicsItem extends ShoppingItem {
    private String warranty;

    public ElectronicsItem(String itemId, String itemName, double price,
                           int stockAvailable, String warranty) {
        super(itemId, itemName, price, stockAvailable);
        this.warranty = warranty;
    }

    @Override
    public void updateStock(int quantity) {
        stockAvailable += quantity;
        System.out.println(itemName + " stock updated to: " + stockAvailable);
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
        System.out.println("Electronics - " + itemName + " ($" + price + ")");
        System.out.println("  Warranty: " + warranty);
        System.out.println("  In Stock: " + stockAvailable);
    }
}
