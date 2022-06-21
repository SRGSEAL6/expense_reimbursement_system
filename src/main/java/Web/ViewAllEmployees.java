package Web;

import model.Employee;
import repository.JDBCEmployeeRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/View_All_Employees"})
public class ViewAllEmployees extends HttpServlet {
    JDBCEmployeeRepository jdbcEmployeeRepository = new JDBCEmployeeRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqPath = req.getRequestURI();
        String httpMethod = req.getMethod();
        System.out.println(reqPath);
        if (httpMethod.equals("GET") && reqPath.equals("/revature.home.project1/View_All_Employees")) {
            // Get todos from database
            List<Employee> employeeList = jdbcEmployeeRepository.allEmployees();
            req.setAttribute("employeeList", employeeList);
            req.getRequestDispatcher("/WEB-INF/View_All_Employees.jsp").forward(req, resp);
        }
/*        if (httpMethod.equals("POST") && reqPath.equals("/todos-web/todos")) {
            String title = req.getParameter("title");
            Todo todo = new Todo();
            todo.setTitle(title);
            todo.setType(TodoType.HOME);
            // Get todos from database
            todoRepository.save(todo);
            resp.sendRedirect("todos");
        }
        if (httpMethod.equals("GET") && reqPath.equals("/todos-web/delete-todo")) {
            String id = req.getParameter("id");
            todoRepository.delete(Integer.parseInt(id));
            resp.sendRedirect("todos");
        }*/
    }
}
