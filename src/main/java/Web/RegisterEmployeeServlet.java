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


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String emp_ID = req.getParameter("emp_ID");
        String emp_Name = req.getParameter("emp_Name");
    //    Position emp_Position = req.Enum("emp_Position");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Employee employee = new Employee();
        employee.setEmp_ID(emp_ID);
        employee.setEmp_Name(emp_Name);
    //   employee.setEmp_Position(emp_Position);
        employee.setUsername(username);
        employee.setPassword(password);

        employeeRepository.save(employee);
        resp.sendRedirect("EmployeeRegistrationForm.html");
    }

}



