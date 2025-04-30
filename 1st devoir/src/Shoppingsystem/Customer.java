package Shoppingsystem;

public class Customer {
    private String customerId;
    private String name;
    private ShoppingCart cart;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.cart = new ShoppingCart("CART-" + customerId);
    }

    public String getName() { return name; }
    public ShoppingCart getCart() { return cart; }
}
