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
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/register"})
public class RegisterEmployeeServlet extends HttpServlet {

    EmployeeRepository employeeRepository = new JDBCEmployeeRepository();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String emp_Name = req.getParameter("emp_Name");
        Position emp_Position = Position.valueOf(req.getParameter("emp_Position"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Employee employee = new Employee();
        employee.setEmp_Name(emp_Name);
        employee.setEmp_Position(Position.EMPLOYEE);
        employee.setUsername(username);
        employee.setPassword(password);

        employeeRepository.save(employee);
        resp.sendRedirect("EmployeeRegistrationForm.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();
        System.out.println(session.isNew());
        System.out.println(session.getId());
        System.out.println(new Date(session.getCreationTime()));
        System.out.println(new Date(session.getLastAccessedTime()));

        String currentUser = (String) session.getAttribute("current-user");
        System.out.println(currentUser);
        System.out.println(req.getRequestURI());

        if(currentUser != null) {

            String reURI = req.getRequestURI();
            // read
            if (reURI.equals("/revature.home.project1/View_All_Employees.jsp")) {
                List<Employee> employees = employeeRepository.allEmployees();
                req.setAttribute("all-employees", employees);
                req.getRequestDispatcher("View_All_Employees.jsp").forward(req, resp);
        }else{
            resp.sendRedirect("manager_page.html");
        }
    }