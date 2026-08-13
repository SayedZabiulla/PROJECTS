public abstract class User {

    private int userId;
    private String name;
    private String email;
    private String password;


    public User(int userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean login(String inputEmail, String inputPassword ){
        if (inputEmail.equals(email) && inputPassword.equals(password))
            return true;
        return false;
    }
    
    public void logout(boolean confirm){
        if (confirm)
            System.out.println("Logged Out Succesfuly");
        else
            System.out.println("Logout Cancelled");
    }

    public void displayProfile(){
        System.out.println("Your User ID is: "+getUserId());
        System.out.println("Your Name is: "+getName());
        System.out.println("Your Email is: "+getEmail());
    }

}