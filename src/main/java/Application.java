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
        ManagerOptions managerOptions = new ManagerOptions();
        Object status = new Object();
        List<Reimbursement> reimbursements = managerOptions.getByStatus(Status.valueOf(String.valueOf(status)));
        System.out.println(reimbursements);

    }
}
