package Web;

import Service.ReimbursementService;
import model.Employee;
import model.Position;
import model.Reimbursement;
import model.Status;
import org.apache.log4j.Logger;
import repository.JDBCEmployeeRepository;
import repository.JDBCReimbursementRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/View_All_ERR_Submissions", "/empPendingRequests", "/empApprovedRequests", "/empDeclinedRequests"})
public class ViewAllReimbursments extends HttpServlet {
    JDBCReimbursementRepo jdbcReimbursementRepo = new JDBCReimbursementRepo();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqPath = req.getRequestURI();
        String httpMethod = req.getMethod();
        System.out.println(reqPath);
        if (httpMethod.equals("GET") && reqPath.equals("/revature.home.project1/View_All_ERR_Submissions")) {
            List<Reimbursement> reimbursementsList = jdbcReimbursementRepo.allReim();
            req.setAttribute("reimbursementList", reimbursementsList);
            req.getRequestDispatcher("/WEB-INF/View_All_ERR_Submissions.jsp").forward(req, resp);
        }
        if (httpMethod.equals("GET") && reqPath.equals("/revature.home.project1/empPendingRequests")) {
            req.setAttribute("status", Status.PENDING);
            req.getRequestDispatcher("/WEB-INF/View_By_Status.jsp").forward(req, resp);
        }
        if (httpMethod.equals("GET") && reqPath.equals("/revature.home.project1/empApprovedRequests")) {
            req.setAttribute("status", Status.APPROVED);
            req.getRequestDispatcher("/WEB-INF/View_By_Status.jsp").forward(req, resp);
        }
        if (httpMethod.equals("GET") && reqPath.equals("/revature.home.project1/empDeclinedRequests")) {
            req.setAttribute("status", Status.DENIED);
            req.getRequestDispatcher("/WEB-INF/View_By_Status.jsp").forward(req, resp);
        }
    }
}
