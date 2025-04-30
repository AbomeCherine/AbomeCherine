package Shoppingsystem;

public class ShoppingCart {
    private String cartId;
    private ShoppingItem[] items;
    private int itemCount;
    private double total;

    public ShoppingCart(String cartId) {
        this.cartId = cartId;
        this.items = new ShoppingItem[10]; // Fixed size array
        this.itemCount = 0;
        this.total = 0;
    }

    public void addItem(ShoppingItem item) {
        if (itemCount >= items.length) {
            System.out.println("Cart is full!");
            return;
        }

        if (item.validateItem()) {
            items[itemCount] = item;
            itemCount++;
            total += item.getPrice();
            System.out.println(item.getItemName() + " added to cart.");
        }
    }

    public void removeItem(int index) {
        if (index < 0 || index >= itemCount) {
            System.out.println("Invalid item index.");
            return;
        }

        ShoppingItem removed = items[index];
        total -= removed.getPrice();

        // Shift items to fill the gap
        for (int i = index; i < itemCount - 1; i++) {
            items[i] = items[i + 1];
        }

        itemCount--;
        System.out.println(removed.getItemName() + " removed from cart.");
    }

    public void displayCart() {
        System.out.println("\n--- Your Shopping Cart ---");
        for (int i = 0; i < itemCount; i++) {
            System.out.println((i + 1) + ". " + items[i].getItemName() + " - $" + items[i].getPrice());
        }
        System.out.println("Total: $" + total);
        System.out.println("--------------------------");
    }

    public double getTotal() {
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public ShoppingItem[] getItems() {
        return items;
    }
}
