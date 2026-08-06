public class Main {
    public static void main(String[] args) {
        payrollSystem payrollsystem = new payrollSystem();
        fullTimeEmployee emp1 = new fullTimeEmployee("Sayed", 1, 50000.00);
        fullTimeEmployee emp2 = new fullTimeEmployee("Sairam", 2, 45000.00);
        partTimeEmployee emp3 = new partTimeEmployee("Anil", 3, 100, 150);
        partTimeEmployee emp4 = new partTimeEmployee("Mohan", 4, 50, 100);
        payrollsystem.addEmployee(emp1);
        payrollsystem.addEmployee(emp2);
        payrollsystem.addEmployee(emp3);
        payrollsystem.addEmployee(emp4);
        System.out.println("All Employees: ");
        payrollsystem.display();
        System.out.println("Removing Employee: ");
        payrollsystem.removeEmployee(1);
        System.out.println("List after the removal of Employee: ");
        payrollsystem.display();

    }
}
