package model;

public class BusinessCustomer extends Customer{
    
    private String businessName;

    public BusinessCustomer(String customerId,String name, String phone, String email, String businessName){
        super(customerId, name, phone, email);
        this.businessName =businessName;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Your Business Name is: "+businessName);
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
}