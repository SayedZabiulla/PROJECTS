public class UPIPayment implements PaymentMethod{
    
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean pay(double amount) {
        if (upiId.isEmpty()){
            System.out.println("Invalid UPI ID");
            return false;
        }
        System.out.println("Payment Successfull");
        return true;
    }

}