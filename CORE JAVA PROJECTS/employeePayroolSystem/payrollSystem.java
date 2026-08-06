import java.util.ArrayList;

public class payrollSystem {

    private ArrayList<Employee> employeesList;
    
    public payrollSystem(){
        employeesList =new ArrayList<>();
    }

    public void addEmployee (Employee employee){
        employeesList.add(employee);
    }

    public void removeEmployee(int iD){
        Employee employeeToRemove = null;
        for (Employee employee: employeesList){
            if (employee.getId() == iD){
                employeeToRemove =employee;
                break;
            }
        }
        if (employeeToRemove != null)
            employeesList.remove(employeeToRemove);
    }

    public void display(){
        for (Employee employee: employeesList){
            System.out.println(employee);
        }
    }

}
