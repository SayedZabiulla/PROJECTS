public class fullTimeEmployee extends Employee{
    
    private double monthlySalary;

    public fullTimeEmployee(String name, int iD, double monthlySalary){
        super(name, iD);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary(){
        return monthlySalary;
    }

}
