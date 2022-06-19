package Service;

import Web.ReimbursementServlet;
import model.Reimbursement;
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
    public void getPending() {
        allReimbursements = reimbursementRepo.allReim();
    }

    @Override
    public void getResolved() {

    }
}
