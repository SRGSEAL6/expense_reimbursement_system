package repository;

import model.Reimbursement;

import java.util.Optional;

public class JDBCReimbursementRepo implements ReimbursementRepo {
    @Override
    public Optional<Reimbursement> findByID(String number) {
        return Optional.empty();
    }

    @Override
    public void save(Reimbursement reimbursement) {

    }
    @Override
    public void update(Reimbursement reimbursement) {

    }
}
