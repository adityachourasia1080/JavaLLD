package LLD.DesignPatterns.ProxyDesignPattern;

public class EmployeeDaoProxy implements EmployeeDao{

    public String clientRole;
    public EmployeeDao emplDaoObj;

    public EmployeeDaoProxy(String clientRole){
        this.clientRole=clientRole;
        emplDaoObj = new EmployeeDaoImpl();
    }

    @Override
    public void getEmployeeDetails(String emplyeeId) {
        if (clientRole.equalsIgnoreCase("ADMIN") || clientRole.equalsIgnoreCase("USER")){
            emplDaoObj.getEmployeeDetails(emplyeeId);
        }
        else{
            throw new RuntimeException("Access Denied");
        }

    }

    @Override
    public void createEmployee(Employee Emp) {
        if (clientRole.equalsIgnoreCase("ADMIN")){
            emplDaoObj.createEmployee(Emp);
        }
        else{
            throw new RuntimeException("Access Denied");
        }

    }
}
