package Shoppingsystem;

import java.util.Scanner;
public class SimpleOnlineShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create some sample products
        ShoppingItem[] products = new ShoppingItem[5];
        products[0] = new ElectronicsItem("E001", "Laptop", 999.99, 10, "2 years");
        products[1] = new ClothingItem("C001", "T-Shirt", 19.99, 50, "M");
        products[2] = new ElectronicsItem("E002", "Smartphone", 699.99, 15, "1 year");
        products[3] = new ClothingItem("C002", "Jeans", 49.99, 30, "32");
        products[4] = new ElectronicsItem("E003", "Headphones", 99.99, 20, "6 months");

        // Customer registration
        System.out.println("Welcome to Simple Online Shop!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        Customer customer = new Customer("CUST001", name);
        System.out.println("\nHello, " + customer.getName() + "! Let's start shopping.");

        boolean shopping = true;
        while (shopping) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Browse Products");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Browse products
                    System.out.println("\n=== PRODUCT CATALOG ===");
                    for (int i = 0; i < products.length; i++) {
                        System.out.print((i+1) + ". ");
                        products[i].displayDetails();
                    }

                    System.out.print("Enter product number to add to cart (0 to go back): ");
                    int productNum = scanner.nextInt();
                    scanner.nextLine();

                    if (productNum > 0 && productNum <= products.length) {
                        customer.getCart().addItem(products[productNum-1]);
                    }
                    break;

                case 2:
                    // View cart
                    customer.getCart().displayCart();

                    System.out.print("Enter item number to remove (0 to keep all): ");
                    int itemNum = scanner.nextInt();
                    scanner.nextLine();

                    if (itemNum > 0 && itemNum <= customer.getCart().getItemCount()) {
                        customer.getCart().removeItem(itemNum-1);
                    }
                    break;

                case 3:
                    // Checkout
                    if (customer.getCart().getItemCount() == 0) {
                        System.out.println("Your cart is empty!");
                        break;
                    }

                    customer.getCart().displayCart();

                    System.out.print("Enter payment method (Credit/Debit/PayPal): ");
                    String method = scanner.nextLine();

                    Payment payment = new Payment(
                            "PAY" + System.currentTimeMillis() % 10000,
                            method,
                            customer.getCart().getTotal(),
                            customer.getCart()
                    );

                    payment.displayReceipt();

                    if (payment.isValid()) {
                        // Update stock for purchased items
                        for (int i = 0; i < customer.getCart().getItemCount(); i++) {
                            customer.getCart().getItems()[i].updateStock(-1);
                        }

                        System.out.println("\nThank you for your purchase!");
                        // Create a new empty cart
                        customer = new Customer(customer.getName(), customer.getName());
                    } else {
                        System.out.println("\nPayment failed. Please try again.");
                    }
                    break;

                case 4:
                    shopping = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("\nThank you for shopping with us. Goodbye!");
        scanner.close();
    }
}
