package model;

public class IndividualCustomer extends Customer{

    private String occupation;

    public IndividualCustomer(String customerId, String name, String phone, String email, String occupation){
        super(customerId, name, phone, email);
        this.occupation = occupation;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Your Occuption is: "+occupation);
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}