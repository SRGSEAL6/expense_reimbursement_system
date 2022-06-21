import Service.ManagerOptions;
import Service.ReimbursementService;
import model.Employee;
import model.Position;
import model.Reimbursement;
import model.Status;
import repository.JDBCEmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        JDBCEmployeeRepository userRepository = new JDBCEmployeeRepository();
/*        ManagerOptions managerOptions = new ManagerOptions();
        managerOptions.register("Javi","user4","password", Position.MANAGER);*/
        Optional<Employee> employee = userRepository.findByUsername("user4");
        System.out.println(employee);

    }
}
