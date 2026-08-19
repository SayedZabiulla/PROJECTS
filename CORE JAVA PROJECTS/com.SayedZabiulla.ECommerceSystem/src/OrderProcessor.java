import java.util.concurrent.locks.ReentrantLock;

public class OrderProcessor extends Thread{
    
    private Customer customer;
    private PaymentMethod paymentMethod;
    private ReentrantLock lock;

    public OrderProcessor(Customer customer, PaymentMethod paymentMethod, ReentrantLock lock){
        this.customer = customer;
        this.paymentMethod = paymentMethod;
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
    }

}