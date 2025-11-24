package LLD.DesignPatterns.ProxyDesignPattern;

public class Client {

    public static void main(String[] args){
        EmployeeDao obj = new EmployeeDaoProxy("Admin");
        Employee e= new Employee("123","aditya");
        obj.createEmployee(e);
        obj.getEmployeeDetails("123");
    }
}
