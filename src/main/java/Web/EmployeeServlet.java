package Web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import model.Employee;
import model.Position;
import repository.JDBCEmployeeRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/userName"})
public class EmployeeServlet extends HttpServlet{
    JDBCEmployeeRepository employeeRepository = new JDBCEmployeeRepository();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        HttpSession session = req.getSession();
        Employee employee = new Employee();
        employee.setUsername((String)session.getAttribute("current-user"));
        session.getAttribute("current-user");
    }
}
