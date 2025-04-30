package Stocksystem;

public class FurnituresItem extends StockItem {
    private double weight;
    private boolean isPacked;

    public FurnituresItem(String itemId, String itemName, int quantityInStock, double pricePerUnit, String supplier, double weight, boolean isPacked) {
        super(itemId, itemName, quantityInStock, pricePerUnit, "Furniture", supplier);
        this.weight = weight;
        this.isPacked = isPacked;
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
         return "Furniture Item Report:\n" +
                "ID: " + itemId + "\n" +
                "Name: " + itemName + "\n" +
                "Quantity: " + quantityInStock + "\n" +
                "Price: $" + String.format("%.2f", pricePerUnit) + "\n" +
                "Weight: " + String.format("%.2f", weight) + " kg\n" +
                "Packed: " + (isPacked ? "Yes" : "No") + "\n" +
                "Stock Value: $" + String.format("%.2f", calculateStockValue());
    }

    @Override
    public boolean validateStock() {
        return quantityInStock > 0 && isPacked;
    }

    public double calculateShippingCost() {
        return weight * 2.5;
    }
}
