import Service.ManagerOptions;
import Service.ReimbursementService;
import model.Position;
import model.Reimbursement;
import model.Status;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        ManagerOptions managerOptions = new ManagerOptions();
        managerOptions.register("Javi","user3","password", Position.EMPLOYEE);

    }
}
