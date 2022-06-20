package Service;

import model.Reimbursement;
import model.Status;

import java.util.List;

public interface ReimbursementInterface {
    public void submit_Request(Reimbursement reimbursement);
    public List<Reimbursement> getByStatus(Status status);
}
