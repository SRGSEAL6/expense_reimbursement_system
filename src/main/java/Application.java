import Service.ReimbursementService;
import model.Reimbursement;
import model.Status;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Reimbursement> reimbursements = new ArrayList<>();
        ReimbursementService reimbursementService = new ReimbursementService();

        reimbursements = reimbursementService.getByStatus(Status.DENIED);
        for(Reimbursement r: reimbursements){
            System.out.println(r);
        }
    }
}
