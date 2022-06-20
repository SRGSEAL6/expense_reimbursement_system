package model;

public class Manager extends Employee{
    public Manager(String emp_Name, String emp_ID,String username,String password, Position emp_Position) {
        super(emp_Name, emp_ID,username,password, emp_Position);
    }
    void action_Request(){

    };
    void view_AllPending(){
    }
    void view_AllResolved(){
    }
    void view_seRequests(){

    }
    void view_AllEmployees(){

    }
    @Override
    public String toString() {
        return "Manager{" +
                "emp_Name='" + getEmp_Name() + '\'' +
                ", emp_ID='" + getEmp_ID() + '\'' +
                ", emp_Position=" + getEmp_Position() +
                '}';
    }
}
