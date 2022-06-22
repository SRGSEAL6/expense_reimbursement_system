package Web;


import Service.AuthService;
import Service.AuthServiceImp;
import Service.ManagerOptions;
import model.Employee;
import model.Position;
import repository.EmployeeRepository;
import repository.JDBCEmployeeRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/register"})
public class RegisterEmployeeServlet extends HttpServlet {

    EmployeeRepository employeeRepository = new JDBCEmployeeRepository();
    ManagerOptions managerOptions = new ManagerOptions();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }
    void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String emp_ID = req.getParameter("emp_ID");
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        StringBuilder emp_Name = new StringBuilder(fname + " " + lname);
        //    Position emp_Position = req.Enum("emp_Position");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(new Employee(emp_Name.toString(), username, password, Position.EMPLOYEE));
        managerOptions.register(emp_Name.toString(), username, password, Position.EMPLOYEE);
/*        Employee employee = new Employee();
        employee.setEmp_ID(emp_ID);
        employee.setEmp_Name(emp_Name.toString());
        employee.setEmp_Position(Position.EMPLOYEE);
        employee.setUsername(username);
        employee.setPassword(password);*/
        resp.sendRedirect("EmployeeRegistrationForm.html");
    }

}



