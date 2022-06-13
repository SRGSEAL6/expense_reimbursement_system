package repository;

import model.Reimbursement;
import java.util.Optional;
public interface ReimbursementRepo {
    Optional<Reimbursement> findByID(String number);
    void save(Reimbursement reimbursement);
    void update(Reimbursement reimbursement);
}
