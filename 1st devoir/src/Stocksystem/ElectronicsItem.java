package Stocksystem;

public class ElectronicsItem extends StockItem {
    private int warrantyPeriod;

    public ElectronicsItem(String itemId, String itemName, int quantityInStock, double pricePerUnit, String supplier, int warrantyPeriod) {
        super(itemId, itemName, quantityInStock, pricePerUnit, "Electronics", supplier);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void updateStock(int quantity) {
        this.quantityInStock += quantity;
    }

    @Override
    public double calculateStockValue() {
        return this.quantityInStock * this.pricePerUnit;
    }

    @Override
    public String generateStockReport() {
        return String.format("Electronics Item Report:\nID: %s\nName: %s\nQuantity: %d\nPrice: $%.2f\nWarranty: %d months\nStock Value: $%.2f",
                itemId, itemName, quantityInStock, pricePerUnit, warrantyPeriod, calculateStockValue());
    }

    @Override
    public boolean validateStock() {
        return quantityInStock > 0;
    }
    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 50) {
            this.pricePerUnit *= (1 - percentage/100);
        } else {
            System.out.println("Discount must be between 0-50%");
        }
    }
}