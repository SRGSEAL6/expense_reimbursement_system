package Web;

import model.Employee;
import model.Reimbursement;
import repository.JDBCEmployeeRepository;
import repository.JDBCReimbursementRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns={"/employeeSubmission"})
public class EmployeeViewSubmissionServlet extends HttpServlet {

    JDBCReimbursementRepo jdbcReimbursementRepo  = new JDBCReimbursementRepo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }


        protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String reqPath = req.getRequestURI();
            String httpMethod = req.getMethod();
            List<Reimbursement> employeeReimbursements = new ArrayList<>();
            if (httpMethod.equals("GET") && reqPath.equals("/revature.home.project1/employeeSubmission")) {
                // Get todos from database
                List<Reimbursement> reimbursementList = jdbcReimbursementRepo.allReim();
                req.getAttribute("current-user");
                for (Reimbursement r: reimbursementList) {
                    if (req.getAttribute("Id").equals(r.getEmp_ID())){
                        employeeReimbursements.add(r);
                    }
                }
                req.setAttribute("reimbursementList", employeeReimbursements);
                req.getRequestDispatcher("/WEB-INF/View_Submissions.jsp").forward(req, resp);
            }}}

