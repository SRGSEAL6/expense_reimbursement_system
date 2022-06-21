package Web;

import Service.ReimbursementService;
import model.Reimbursement;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns={"/reimbursementDetails"})
public class ReimbursementServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger("ers");
    ReimbursementService reimbursementService = new ReimbursementService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("In doPost method");
        String empName= req.getParameter("empName");
        String empID = req.getParameter("empID");
        String details =req.getParameter("reimDetails");
        String amount = req.getParameter("amount");
        Reimbursement reimbursement = new Reimbursement(empName,empID,details,Double.parseDouble(amount));
        reimbursementService.submit_Request(reimbursement);
        resp.sendRedirect("ReimbursementRequestForm.html");
    }

}
