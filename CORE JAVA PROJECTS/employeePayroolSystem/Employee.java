public abstract class Employee {

    private String name;
    private int iD;

    public Employee(String name, int iD) {
        this.name = name;
        this.iD = iD;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return iD;
    }

    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee [name="+name+", Id="+iD+",Salary ="+calculateSalary()+"]";
    }
}
