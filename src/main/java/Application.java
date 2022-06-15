import model.*;
import org.apache.log4j.Logger;
import repository.JDBCEmployeeRepository;
import repository.JDBCReimbursementRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Application {
    private static final Logger LOGGER = Logger.getLogger("ers");
    public static void main(String[] args) {
        /*Init---------*/
        JDBCEmployeeRepository employeeRepo = new JDBCEmployeeRepository();
        JDBCReimbursementRepo reimbursementRepo = new JDBCReimbursementRepo();
        /*Use-----------*/
        List<Reimbursement> reimbursementsADB = new ArrayList<>();
/*        reimbursementRepo.save(new Reimbursement("Javier", "1","First reimbursement", 2000.00));
        reimbursementRepo.save(new Reimbursement("Javier", "1","Second reimbursement", 1500.00));*/
        reimbursementRepo.update(new Reimbursement("1","Javier", "1","First reimbursement",Status.APPROVED, 2000.00));
        reimbursementsADB = reimbursementRepo.allReim();
        System.out.println(reimbursementsADB);
    }

}
