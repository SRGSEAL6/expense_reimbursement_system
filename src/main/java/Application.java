import model.Employee;
import model.Manager;
import model.Position;
import model.User;
import org.apache.log4j.Logger;

public class Application {
    private static final Logger LOGGER = Logger.getLogger("ers");
    public static void main(String[] args) {
        /*Init---------*/

        /*Use-----------*/
        User emp1 = new Employee("Javier", "1111111", Position.EMPLOYEE);
        User emp2 = new Manager("Nag", "1111122", Position.MANAGER);
        System.out.println(emp1);
        System.out.println(emp2);

    }

}
