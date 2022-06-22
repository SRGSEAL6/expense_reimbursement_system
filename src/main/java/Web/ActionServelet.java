package Web;

import Service.ManagerOptions;
import model.Reimbursement;
import model.Status;
import repository.JDBCReimbursementRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/empApprovedAction","/empDeclinedAction"})
public class ActionServelet extends HttpServlet {
    ManagerOptions managerOptions = new ManagerOptions();
    JDBCReimbursementRepo jdbcReimbursementRepo = new JDBCReimbursementRepo();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqPath = req.getRequestURI();
        HttpSession session = req.getSession();
        String id = req.getParameter("id");
        Reimbursement reimbursement = jdbcReimbursementRepo.findByReimId(id).get();
        if(reqPath.equals("/revature.home.project1/empApprovedAction")){
            managerOptions.action_Request(reimbursement, Status.APPROVED);
        }
        if(reqPath.equals("/revature.home.project1/empDeclinedAction")){
            managerOptions.action_Request(reimbursement, Status.DENIED);
        }
        req.getRequestDispatcher("/WEB-INF/View_All_ERR_Submissions.jsp").forward(req, resp);
    }
}
