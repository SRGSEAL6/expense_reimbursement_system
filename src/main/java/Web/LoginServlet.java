package Web;

import Service.AuthService;
import Service.AuthServiceImp;
import model.Employee;
import repository.JDBCEmployeeRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    JDBCEmployeeRepository employeeRepository = new JDBCEmployeeRepository();
    AuthService authService = new AuthServiceImp(employeeRepository);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password=req.getParameter("password");
        boolean b=authService.authenticate(username,password);
        if(!b){
            resp.sendRedirect("login_page.html");
        }else{
            HttpSession session=req.getSession();

/*
            System.out.println(session.isNew());
            System.out.println(session.getId());
            System.out.println(new Date(session.getCreationTime()));
            System.out.println(new Date(session.getLastAccessedTime()));
*/
            Employee employee = employeeRepository.findByUsername(username).get();
            session.setAttribute("current-user",username);
            session.setAttribute("id", employee.getEmp_ID());
            session.setAttribute("position", employee.getEmp_Position());
            resp.sendRedirect("employee_page.html");
        }
    }
}
