import Service.ManagerOptions;
import Service.ReimbursementService;
import model.Employee;
import model.Position;
import model.Reimbursement;
import model.Status;
import repository.JDBCEmployeeRepository;
import repository.JDBCReimbursementRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        JDBCReimbursementRepo jdbcReimbursementRepo = new JDBCReimbursementRepo();
        Reimbursement reimbursement = new Reimbursement();
        reimbursement = jdbcReimbursementRepo.findByReimId("2").get();
        System.out.println(reimbursement);
    }
}
