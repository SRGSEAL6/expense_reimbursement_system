package Service;

import Web.ReimbursementServlet;
import model.Reimbursement;
import model.Status;
import repository.JDBCReimbursementRepo;

import java.util.ArrayList;
import java.util.List;

public class ReimbursementService implements ReimbursementInterface{
    JDBCReimbursementRepo reimbursementRepo = new JDBCReimbursementRepo();
    List<Reimbursement> allReimbursements = new ArrayList<>();
    @Override
    public void submit_Request(Reimbursement reimbursement) {
        reimbursementRepo.save(reimbursement);
    }
    @Override
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
}
