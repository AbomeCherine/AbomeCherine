package Stocksystem;

import java.time.LocalDate;

public class PerishableItem extends StockItem {
    private LocalDate expirationDate;

    public PerishableItem(String itemId, String itemName, int quantityInStock, double pricePerUnit, String supplier, LocalDate expirationDate) {
        super(itemId, itemName, quantityInStock, pricePerUnit, "Perishable", supplier);
        this.expirationDate = expirationDate;
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
        String status = expirationDate.isBefore(LocalDate.now()) ? "EXPIRED - NEEDS DISPOSAL" : "OK";
        return "Perishable Item Report:\n" +
                "ID: " + itemId + "\n" +
                "Name: " + itemName + "\n" +
                "Quantity: " + quantityInStock + "\n" +
                "Price: $" + String.format("%.2f", pricePerUnit) + "\n" +
                "Expiration: " + expirationDate.toString() + "\n" +
                "Status: " + status + "\n" +
                "Stock Value: $" + String.format("%.2f", calculateStockValue());
    }

    @Override
    public boolean validateStock() {
        return quantityInStock > 0 && !expirationDate.isBefore(LocalDate.now());
    }

    public boolean needsDisposal() {
        return expirationDate.isBefore(LocalDate.now());
    }
}
