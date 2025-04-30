package Stocksystem;


import java.util.Scanner;

public class ClothingItem extends StockItem{
    private String [] sizes;
    private String[] colors;
    private int[] sizeQuantities;
    private int sizeCount;
    private int colorCount;

    public ClothingItem(String itemId, String itemName, double pricePerUnit, String supplier,
                        String[] sizes, int[] sizeQuantities, String[] colors)

    {
        super(itemId, itemName, calculateTotalQuantity(sizeQuantities), pricePerUnit, "Clothing", supplier);

        this.sizes = sizes;
        this.sizeQuantities = sizeQuantities;
        this.colors = colors;
        this.sizeCount = sizes.length;
        this.colorCount = colors.length;
    }
    private static int calculateTotalQuantity(int[] sizeQuantities) {
        int total = 0;
        for (int qty : sizeQuantities) {
            total += qty;
        }
        return total;
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
        String sizesStr = "";
        for (int i = 0; i < sizes.length; i++) {
            sizesStr += "  " + sizes[i] + ": " + sizeQuantities[i] + "\n";
        }

        String colorsStr = "";
        for (int i = 0; i < colors.length; i++) {
            if (i > 0) colorsStr += ", ";
            colorsStr += colors[i];
        }

        return "Clothing Item Report:\n" +
                "ID: " + itemId + "\n" +
                "Name: " + itemName + "\n" +
                "Total Quantity: " + quantityInStock + "\n" +
                "Price: $" + String.format("%.2f", pricePerUnit) + "\n" +
                "Sizes and Quantities:\n" + sizesStr +
                "Colors: " + colorsStr + "\n" +
                "Stock Value: $" + String.format("%.2f", calculateStockValue());
    }

    @Override
    public boolean validateStock() {
        return quantityInStock > 0;
    }
}

