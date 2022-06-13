package model;

public interface User {

    void submit_Request();
    void getPending();
    void getResolved();
    String getEmp_Name();
    String getEmp_ID();
    Position getEmp_Position();
    void setEmp_Name(String emp_Name);
    void setEmp_ID(String emp_ID);

}

