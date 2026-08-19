import java.util.ArrayList;

public class Customer extends User{
    
    private ArrayList<Product> cart= new ArrayList<>();
    private ArrayList<Order> orderHistory = new ArrayList<>();


    public Customer(int userId, String name, String email, String password) {
        super(userId, name, email, password);
    }

    public void addToCart(Product product){
        cart.add(product);
        System.out.println("Product added to cart ");
    }

    public void removeFromCart(int productId){
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProductId() == productId) {
                cart.remove(i);
                System.out.println("Product removed.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void viewCart(){
        if (cart.isEmpty()){
            System.out.println("Cart is empty.");
        }
        else{
            for (Product product : cart) {
                System.out.println(product);
            }
        }
    }

    public Order placeOrder(PaymentMethod paymentMethod){
        if (cart.isEmpty()){
            System.out.println("Cart is empty.");
            return null;
        }

        double totalAmount = 0;

        for (Product product : cart) {
            totalAmount += product.getPrice();
        }
        boolean paymentSuccess = paymentMethod.pay(totalAmount);
        if (!paymentSuccess) {
            System.out.println("Payment failed.");
            return null;
        }
        Order order = new Order(new ArrayList<>(cart), totalAmount);
        orderHistory.add(order);
        cart.clear();
        return order;
    }

    public void viewOrderHistory(){
        if (orderHistory.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            for (Order order : orderHistory) {
                System.out.println(order);
            }
        }
    }
}