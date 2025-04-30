package Shoppingsystem;

abstract class ShoppingItem {
    protected String itemId;
    protected String itemName;
    protected double price;
    protected int stockAvailable;

    public ShoppingItem(String itemId, String itemName, double price, int stockAvailable) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.stockAvailable = stockAvailable;
    }

    public abstract void updateStock(int quantity);
    public abstract boolean validateItem();
    public abstract void displayDetails();

    // Getters
    public String getItemId() {
        return itemId;
    }
    public String getItemName() {
        return itemName;
    }
    public double getPrice() {
        return price;
    }
    public int getStockAvailable() {
        return stockAvailable;
    }
}