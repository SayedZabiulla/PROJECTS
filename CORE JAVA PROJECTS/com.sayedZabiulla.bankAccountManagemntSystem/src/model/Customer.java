package model;

public abstract class Customer {
    
    private String customerId;
    private String name;
    private String phone;
    private String email;

    public Customer(String customerId,String name, String phone, String email){
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void displayDetails(){
        System.out.println("The Customer Details are: ");
        System.out.println("Your Customer ID is :"+getCustomerId());
        System.out.println("Your Account Name is: "+getName());
        System.out.println("Your Phone Numver is: "+getPhone());
        System.out.println("Your Email Address is: "+getEmail());
    }
}