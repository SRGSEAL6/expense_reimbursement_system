import model.Employee;
import model.Manager;
import model.Position;
import model.User;
import org.apache.log4j.Logger;
import repository.JDBCEmployeeRepository;

import java.util.List;
import java.util.Optional;

public class Application {
    private static final Logger LOGGER = Logger.getLogger("ers");
    public static void main(String[] args) {
        /*Init---------*/
        JDBCEmployeeRepository employeeRepo = new JDBCEmployeeRepository();
        /*Use-----------*/
        //Employee emp1 = new Employee("Javier", "1", Position.EMPLOYEE);
        //System.out.println(emp1);
        //employeeRepo.save(emp1);
        Optional<Employee> emp2 = employeeRepo.findByID("2");
        System.out.println(emp2);
        List<Employee> allEmplo = employeeRepo.allEmployees();
        System.out.println(allEmplo);
    }

}
