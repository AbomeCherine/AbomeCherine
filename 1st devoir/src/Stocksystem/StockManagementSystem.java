package Stocksystem;


import java.util.Scanner;
import java.time.LocalDate;

public class StockManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static StockItem[] stockItems = new StockItem[100]; // Fixed size array
    private static int itemCount = 0; // Track how many items we have

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Advanced Stock Management System ===");
            System.out.println("1. Add New Stock Item");
            System.out.println("2. View All Stock Items");
            System.out.println("3. Update Stock Quantity");
            System.out.println("4. Generate Stock Reports");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewStockItem();
                    break;
                case 2:
                    viewAllStockItems();
                    break;
                case 3:
                    updateStockQuantity();
                    break;
                case 4:
                    generateStockReports();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addNewStockItem() {
        if (itemCount >= stockItems.length) {
            System.out.println("Cannot add more items. Storage full!");
            return;
        }

        System.out.println("\nSelect item category:");
        System.out.println("1. Electronics");
        System.out.println("2. Clothing");
        System.out.println("3. Grocery");
        System.out.println("4. Furniture");
        System.out.println("5. Perishable");
        System.out.print("Enter choice: ");
        int category = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter item ID: ");
        String itemId = scanner.nextLine();
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter quantity in stock: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price per unit: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter supplier: ");
        String supplier = scanner.nextLine();

        switch (category) {
            case 1:
                System.out.print("Enter warranty period (months): ");
                int warranty = scanner.nextInt();
                stockItems[itemCount++] = new ElectronicsItem(itemId, itemName, quantity, price, supplier, warranty);
                System.out.println("Electronics item added successfully!");
                break;
            case 2:
                System.out.print("Enter number of sizes: ");
                int sizeCount = scanner.nextInt();
                scanner.nextLine();

                String[] sizes = new String[sizeCount];
                int[] quantities = new int[sizeCount];

                for (int i = 0; i < sizeCount; i++) {
                    System.out.print("Enter size " + (i+1) + " (e.g., S, M, L): ");
                    sizes[i] = scanner.nextLine();
                    System.out.print("Enter quantity for size " + sizes[i] + ": ");
                    quantities[i] = scanner.nextInt();
                    scanner.nextLine();
                }

                System.out.print("Enter number of colors: ");
                int colorCount = scanner.nextInt();
                scanner.nextLine();

                String[] colors = new String[colorCount];
                for (int i = 0; i < colorCount; i++) {
                    System.out.print("Enter color " + (i+1) + ": ");
                    colors[i] = scanner.nextLine();
                }

                stockItems[itemCount++] = new ClothingItem(itemId, itemName, price, supplier, sizes, quantities, colors);
                System.out.println("Clothing item added successfully!");
                break;
            case 3:
                System.out.print("Enter expiration date (YYYY-MM-DD): ");
                LocalDate groceryExpiry = LocalDate.parse(scanner.nextLine());
                stockItems[itemCount++] = new GroceryItem(itemId, itemName, quantity, price, supplier, groceryExpiry);
                System.out.println("Grocery item added successfully!");
                break;
            case 4:
                System.out.print("Enter weight (kg): ");
                double weight = scanner.nextDouble();
                System.out.print("Is it packed? (true/false): ");
                boolean packed = scanner.nextBoolean();
                scanner.nextLine();
                stockItems[itemCount++] = new FurnituresItem(itemId, itemName, quantity, price, supplier, weight, packed);
                System.out.println("Furniture item added successfully!");
                break;
            case 5:
                System.out.print("Enter expiration date (YYYY-MM-DD): ");
                LocalDate perishableExpiry = LocalDate.parse(scanner.nextLine());
                stockItems[itemCount++] = new PerishableItem(itemId, itemName, quantity, price, supplier, perishableExpiry);
                System.out.println("Perishable item added successfully!");
                break;
            default:
                System.out.println("Invalid category selection.");
        }
    }

    private static void viewAllStockItems() {
        if (itemCount == 0) {
            System.out.println("No stock items available.");
            return;
        }

        System.out.println("\n=== All Stock Items ===");
        for (int i = 0; i < itemCount; i++) {
            StockItem item = stockItems[i];
            System.out.println("ID: " + item.itemId + ", Name: " + item.itemName +
                    ", Category: " + item.category + ", Qty: " + item.quantityInStock +
                    ", Price: $" + item.pricePerUnit);
        }
    }

    private static void updateStockQuantity() {
        viewAllStockItems();
        if (itemCount == 0) return;

        System.out.print("\nEnter item ID to update: ");
        String itemId = scanner.nextLine();

        StockItem foundItem = null;
        int foundIndex = -1;
        for (int i = 0; i < itemCount; i++) {
            if (stockItems[i].itemId.equals(itemId)) {
                foundItem = stockItems[i];
                foundIndex = i;
                break;
            }
        }

        if (foundItem == null) {
            System.out.println("Item not found.");
            return;
        }

        System.out.print("Enter quantity to add (positive) or remove (negative): ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        foundItem.updateStock(quantity);
        System.out.println("Stock updated successfully. New quantity: " + foundItem.quantityInStock);
    }

    private static void generateStockReports() {
        if (itemCount == 0) {
            System.out.println("No stock items available to generate reports.");
            return;
        }

        System.out.println("\n=== Stock Reports ===");
        for (int i = 0; i < itemCount; i++) {
            System.out.println("\n" + stockItems[i].generateStockReport());
        }

        System.out.println("\n=== Summary Report ===");
        double totalStockValue = 0;
        for (int i = 0; i < itemCount; i++) {
            totalStockValue += stockItems[i].calculateStockValue();
        }
        System.out.printf("Total Stock Value: $%.2f\n", totalStockValue);

        int expiredItems = 0;
        for (int i = 0; i < itemCount; i++) {
            if (stockItems[i] instanceof GroceryItem && !((GroceryItem)stockItems[i]).validateStock()) {
                expiredItems++;
            }
        }
        System.out.println("Expired Items: " + expiredItems);

        int itemsNeedingDiscount = 0;
        for (int i = 0; i < itemCount; i++) {
            StockItem item = stockItems[i];
            if ((item instanceof GroceryItem && ((GroceryItem)item).needsDiscount()) ||
                    (item instanceof PerishableItem && ((PerishableItem)item).needsDisposal())) {
                itemsNeedingDiscount++;
            }
        }
        System.out.println("Items Needing Discount/Disposal: " + itemsNeedingDiscount);
    }
}

