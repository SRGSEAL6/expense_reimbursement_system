package repository;

import Factory.SQLConnectionFactory;
import model.Employee;
import model.Position;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCEmployeeRepository implements EmployeeRepository {

    private static final Logger LOG = Logger.getLogger("mts"); // singleton

    @Override
    /*Loading Employee from database*/
    public Optional<Employee> findByID(String number) {
        LOG.info("Loading employee: " + number);    //LOG for debugging
        try (Connection connection = SQLConnectionFactory.getConnection()) { //This will automatically close the connection
            String sqlCode = "select * from employees"; //SQL statement from postgres to get every column from employee table
            PreparedStatement ps = connection.prepareStatement(sqlCode); //Pre compiles the sqlcode
            ResultSet rs = ps.executeQuery(); //A table of data representing a database result set, which is usually generated by executing a statement that queries the database
            while (rs.next()) {
                if (rs.getString("emp_id").equals(number)) {
                    Employee employee = new Employee(rs.getString("emp_name"), rs.getString("emp_id"),rs.getString("username"),rs.getString("password"), Position.valueOf(rs.getString("emp_position")));
                    return Optional.of(employee);
                }
            }
        } catch (SQLException e) {
            LOG.error("Error loading employee: " + number);
            e.printStackTrace();
        }
        return Optional.empty();
    }
    public Optional<Employee> findByUsername(String username) {
        LOG.info("Loading employee: " + username);    //LOG for debugging
        try (Connection connection = SQLConnectionFactory.getConnection()) { //This will automatically close the connection
            String sqlCode = "select * from employees"; //SQL statement from postgres to get every column from employee table
            PreparedStatement ps = connection.prepareStatement(sqlCode); //Pre compiles the sqlcode
            ResultSet rs = ps.executeQuery(); //A table of data representing a database result set, which is usually generated by executing a statement that queries the database
            LOG.info(rs);
            while (rs.next()) {
                if (rs.getString("username").equals(username)) {
                    Employee employee = new Employee(rs.getString("emp_name"), rs.getString("emp_id"),rs.getString("username"),rs.getString("password"), Position.valueOf(rs.getString("emp_position")));
                    return Optional.of(employee);
                }
            }
        } catch (SQLException e) {
            LOG.error("Error loading employee: " + username);
            e.printStackTrace();
        }
        return Optional.empty();
    }
    /*Updating employee to database*/
    @Override
    public void update(Employee employee) {
        LOG.info("Updating employee: " + employee.getEmp_ID());
        try (Connection connection = SQLConnectionFactory.getConnection()) {
            String sqlCode = "update employees set emp_name=? where emp_id=?";
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ps.setString(1, employee.getEmp_Name());
            ps.setString(2, employee.getEmp_ID());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error("error updating employee: " + employee.getEmp_ID());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Employee employee) {
        LOG.info("Deleting employee: " + employee.getEmp_ID());
        try (Connection connection = SQLConnectionFactory.getConnection()) {
            String sqlCode = "delete from employees where emp_id=?";
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ps.setString(1, employee.getEmp_ID());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error("error updating employee: " + employee.getEmp_ID());
            e.printStackTrace();
        }
    }

    @Override
    public void save(Employee employee) {
        LOG.info("Saving employee: " + employee.getEmp_ID());
        try (Connection connection = SQLConnectionFactory.getConnection()) {
            String sqlCode = "insert into employees (emp_name,username,password, emp_position) values (?,?,?,cast(? as positions))";
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ps.setString(1, employee.getEmp_Name());
            ps.setString(2, employee.getUsername());
            ps.setString(3, employee.getPassword());
            ps.setString(4, String.valueOf(employee.getEmp_Position()));
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Error saving employee" + employee.getEmp_ID());
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> allEmployees() {
        LOG.info("Loading all employees: ");    //LOG for debugging
        List<Employee> dbList = new ArrayList<>();
        try (Connection connection = SQLConnectionFactory.getConnection()) { //This will automatically close the connection
            String sqlCode = "select * from employees"; //SQL statement from postgres to get every column from employee table
            PreparedStatement ps = connection.prepareStatement(sqlCode); //Pre compiles the sqlcode
            ResultSet rs = ps.executeQuery(); //A table of data representing a database result set, which is usually generated by executing a statement that queries the database
            while (rs.next()) {
                Employee employee = new Employee(rs.getString("emp_name"), rs.getString("emp_id"),rs.getString("username"),rs.getString("password"), Position.valueOf(rs.getString("emp_position")));
                dbList.add(employee);
            }
        } catch (SQLException e) {
            LOG.error("Error loading all employees: ");
            e.printStackTrace();
        }
        return dbList;
    }


}
