public class UPIPayment implements PaymentMethod{
    
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean pay(double amount) {
        return false;
    }

}
