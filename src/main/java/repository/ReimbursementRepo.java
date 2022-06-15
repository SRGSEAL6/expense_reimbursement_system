package repository;

import model.Reimbursement;
import java.util.Optional;
public interface ReimbursementRepo {
    void save(Reimbursement reimbursement);
    void update(Reimbursement reimbursement);
}
