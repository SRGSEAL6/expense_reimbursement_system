package Service;

import model.Reimbursement;

public interface ReimbursementInterface {
    public void submit_Request(Reimbursement reimbursement);
    public void getPending();
    public void getResolved();
}
