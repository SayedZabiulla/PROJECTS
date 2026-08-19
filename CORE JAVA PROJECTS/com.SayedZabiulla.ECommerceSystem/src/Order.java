import java.util.ArrayList;

public class Order {

    private static int nextOrderId = 1;

    private int orderId;
    private ArrayList<Product> products;
    private double totalAmount;
    private String orderStatus;

    public Order(ArrayList<Product> products, double totalAmount) {
        this.orderId = nextOrderId++;
        this.products = products;
        this.totalAmount = totalAmount;
        this.orderStatus = "Placed";
    }

    public int getOrderId() {
        return orderId;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void updateOrderStatus(String status) {
        orderStatus = status;
    }

    public void displayOrder() {
        System.out.println("Order ID is: " + getOrderId());
        System.out.println("The Products are: " + getProducts());
        System.out.println("The Total Amount is: " + getTotalAmount());
        System.out.println("The Order Status is: " + getOrderStatus());
    }
}