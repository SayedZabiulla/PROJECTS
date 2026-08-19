import java.util.ArrayList;

public class Order {
    
    private int orderId;
    private ArrayList<Product> products;
    private double totalAmount;
    private String orderStatus;

    public Order(ArrayList<Product> products, double totalAmount) {
        this.products = products;
        this.totalAmount = totalAmount;
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

    public void updateOrderStatus(String status){

    }

    public void displayOrder(){
        
    }
    
}
