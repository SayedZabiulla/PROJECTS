public class partTimeEmployee extends Employee{

    private int hoursWork;
    private double hourlyRate;

    public partTimeEmployee(String name, int iD, int hoursWork, double hourlyRate){
        super(name, iD);
        this.hoursWork = hoursWork;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hoursWork*hourlyRate;
    }

}
