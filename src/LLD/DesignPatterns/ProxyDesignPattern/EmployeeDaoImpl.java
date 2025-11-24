package LLD.DesignPatterns.ProxyDesignPattern;

public class EmployeeDaoImpl implements  EmployeeDao{
    @Override
    public void getEmployeeDetails(String emplyeeId) {
        System.out.println("Fetched the Employee Details from database with id as : "+ emplyeeId);
    }

    @Override
    public void createEmployee(Employee Emp) {
        System.out.println("Create the Employee details as  : "+ Emp);

    }
}
