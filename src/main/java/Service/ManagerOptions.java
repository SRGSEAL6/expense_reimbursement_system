package Service;

import repository.JDBCEmployeeRepository;
import repository.JDBCReimbursementRepo;

public class ManagerOptions implements MangerOptionsInterface {
    JDBCEmployeeRepository employeeRepo = new JDBCEmployeeRepository();
    JDBCReimbursementRepo reimbursementRepo = new JDBCReimbursementRepo();
    @Override
    public void action_Request() {

    }

    @Override
    public void view_AllPending() {

    }

    @Override
    public void view_AllResolved() {

    }

    @Override
    public void view_seRequests() {

    }

    @Override
    public void view_AllEmployees() {

    }

    @Override
    public void register(String username, String password) {
        MangerOptionsInterface.super.register(username, password);
    }
}
