package Service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import model.Employee;
import model.Position;
import model.Reimbursement;
import model.Status;
import repository.JDBCEmployeeRepository;

import java.util.List;

public interface MangerOptionsInterface {
    JDBCEmployeeRepository employeeRepo = null;
    void action_Request(Reimbursement reimbursement, Status action);
    public List<Reimbursement> view_allRequests();
    public List<Employee> view_AllEmployees();
    public List<Reimbursement> getByStatus(Status status);
    default void register(String emp_Name, String emp_ID,String username,String password, Position emp_Position) {
        Employee employee = new Employee();
        employee.setUsername(username);
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        employee.setPassword(bcryptHashString);
        employeeRepo.save(employee);
    }
}
