package repository;

import Factory.SQLConnectionFactory;
import jdk.jfr.Description;
import model.Reimbursement;
import model.Status;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCReimbursementRepo implements ReimbursementRepo {
    private static final Logger LOG = Logger.getLogger("mts"); // singleton

    @Override
    public void save(Reimbursement reimbursement) {
        LOG.info("Saving Reimbursement for: " + reimbursement.getEmp_Name());
        try (Connection connection = SQLConnectionFactory.getConnection()) {
            String sqlCode = "insert into reimbursements (emp_name, emp_id, reim_details, reim_status, reim_amount) values ( ?, ?, ?, cast(? as status), ?)";
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ps.setString(1, reimbursement.getEmp_Name());
            ps.setInt(2, Integer.parseInt(reimbursement.getEmp_ID()));
            ps.setString(3, reimbursement.getDetails());
            ps.setString(4, String.valueOf(reimbursement.getStatus()));
            ps.setFloat(5, (float) reimbursement.getAmount());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Error saving reimbursement for" + reimbursement.getEmp_Name());
            e.printStackTrace();
        }
    }
    @Override
    public void update(Reimbursement reimbursement) {
        LOG.info("Updating Reimbursement for :" + reimbursement.getEmp_Name());
        try(Connection connection = SQLConnectionFactory.getConnection()){
            String sqlCode = "update reimbursements set reim_status=cast(? as status) where reim_id=?";
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ps.setString(1, String.valueOf(reimbursement.getStatus()));
            ps.setInt(2,Integer.parseInt(reimbursement.getReim_Id()));
            ps.executeUpdate();
        }catch (SQLException e){
            LOG.error("Error Updating Reimbursement for: " + reimbursement.getEmp_Name());
            e.printStackTrace();
        }
    }
    @Description("Loads all Reimbursements")
    public List<Reimbursement> allReim (){
        List<Reimbursement> dbList = new ArrayList<>();
        LOG.info("Loading all Reimbursements:");
        try(Connection connection = SQLConnectionFactory.getConnection()){
            String sqlCode = "select * from reimbursements";
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Reimbursement reimbursement = new Reimbursement(rs.getString("reim_id"),rs.getString("emp_name"),rs.getString("emp_id"),rs.getString("reim_details"), Status.valueOf(rs.getString("reim_status")),rs.getDouble("reim_amount"));
                dbList.add(reimbursement);
            }
        }catch (SQLException e){
            LOG.error("Error loading all Reimbursements");
            e.printStackTrace();
        }

        return dbList;
    }
}
