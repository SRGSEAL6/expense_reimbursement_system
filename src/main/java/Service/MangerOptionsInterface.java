package Service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import model.Employee;
import repository.JDBCEmployeeRepository;

public interface MangerOptionsInterface {
    JDBCEmployeeRepository employeeRepo = null;
    void action_Request();

    void view_AllPending();

    void view_AllResolved();

    void view_seRequests();

    void view_AllEmployees();
    default void register(String username, String password) {
        Employee employee = new Employee();
        employee.setUsername(username);
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        employee.setPassword(bcryptHashString);
        employeeRepo.save(employee);
    }
}
