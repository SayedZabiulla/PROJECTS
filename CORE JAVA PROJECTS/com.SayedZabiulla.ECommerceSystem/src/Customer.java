import java.util.ArrayList;

public class Customer extends User{
    
    private ArrayList<Product> cart= new ArrayList<>();
    private ArrayList<Order> orderHistory = new ArrayList<>();


    public Customer(int userId, String name, String email, String password, ArrayList<Product> cart,
            ArrayList<Order> orderHistory) {
        super(userId, name, email, password);
        this.cart = cart;
        this.orderHistory = orderHistory;
    }

    public void addToCart(Product product){

    }

    public void removeFromCart(int productId){

    }

    public void viewCart(){

    }

    public Order placeOrder(PaymentMethod paymentMethod){

    }

    public void viewOrderHistory(){
        
    }

}
