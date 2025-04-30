package Shoppingsystem;


import java.text.SimpleDateFormat;
public class Payment {
    private String paymentId;
    private String method;
    private double amount;
    private String date;
    private boolean isValid;

    public Payment(String paymentId, String method, double amount, ShoppingCart cart) {
        this.paymentId = paymentId;
        this.method = method;
        this.amount = amount;

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        this.date = sdf.format(new java.util.Date());

        this.isValid = validatePayment(cart);
    }

    private boolean validatePayment(ShoppingCart cart) {
        if (!method.equalsIgnoreCase("Credit") &&
                !method.equalsIgnoreCase("Debit") &&
                !method.equalsIgnoreCase("PayPal")) {
            System.out.println("Invalid payment method.");
            return false;
        }

        if (Math.abs(amount - cart.getTotal()) > 0.01) {
            System.out.println("Payment amount doesn't match cart total.");
            return false;
        }

        if (cart.getItemCount() == 0) {
            System.out.println("Cart is empty.");
            return false;
        }

        return true;
    }

    public void displayReceipt() {
        System.out.println("\n--- Payment Receipt ---");
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Date: " + date);
        System.out.println("Method: " + method);
        System.out.println("Amount: $" + amount);
        System.out.println("Status: " + (isValid ? "Approved" : "Declined"));
        System.out.println("----------------------");
    }

    public boolean isValid() { return isValid; }
}
