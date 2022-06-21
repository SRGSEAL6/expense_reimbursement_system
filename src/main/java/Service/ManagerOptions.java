package Service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import model.Employee;
import model.Position;
import model.Reimbursement;
import model.Status;
import repository.JDBCEmployeeRepository;
import repository.JDBCReimbursementRepo;

import java.util.ArrayList;
import java.util.List;

public class ManagerOptions implements MangerOptionsInterface {
    JDBCEmployeeRepository employeeRepo = new JDBCEmployeeRepository();
    JDBCReimbursementRepo reimbursementRepo = new JDBCReimbursementRepo();
    List<Reimbursement> allReimbursements = new ArrayList<>();
    List<Employee> allEmployees = new ArrayList<>();
    @Override // Changes a reimbursement status from PENDING, APPROVED, DENIED
    public void action_Request(Reimbursement reimbursement, Status action) {
        reimbursement.setStatus(action);
        reimbursementRepo.update(reimbursement);
    }
    @Override
    public List<Reimbursement> view_allRequests() {
        allReimbursements = reimbursementRepo.allReim();
        List<Reimbursement> reimbursements  = new ArrayList<>();
        allReimbursements.forEach(reimbursement -> {
            reimbursements.add(reimbursement);
        });
        return reimbursements;
    }
    public List<Reimbursement> getByStatus(Status status) {
        allReimbursements = reimbursementRepo.allReim();
        List<Reimbursement> reimbursements  = new ArrayList<>();
        allReimbursements.forEach(reimbursement -> {
            if (reimbursement.getStatus().equals(status)){
                reimbursements.add(reimbursement);
            }
        });
        return reimbursements;
    }
    @Override
    public List<Employee> view_AllEmployees() {
        allEmployees = employeeRepo.allEmployees();
        return allEmployees;
    }

    @Override
    public void register(String emp_Name,String username,String password, Position emp_Position) {
        Employee employee = new Employee(emp_Name,username,password,emp_Position);
        employee.setUsername(username);
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        employee.setPassword(bcryptHashString);
        employeeRepo.save(employee);
    }
}
