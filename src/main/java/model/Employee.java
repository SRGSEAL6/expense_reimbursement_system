package model;

import java.util.Objects;

public class Employee implements User {
    private String emp_Name, emp_ID, username, password;
    private Position emp_Position;
    public Employee(){

    }
    public Employee(String emp_Name,String username,String password, Position emp_Position) {
        this.emp_Name = emp_Name;
        this.emp_Position = emp_Position;
        this.username = username;
        this.password = password;
    }
    public Employee(String emp_Name, String emp_ID,String username,String password, Position emp_Position) {
        this.emp_Name = emp_Name;
        this.emp_ID = emp_ID;
        this.emp_Position = emp_Position;
        this.username = username;
        this.password = password;
    }
    public String getEmp_Name() {
        return emp_Name;
    }

    public void setEmp_Name(String emp_Name) {
        this.emp_Name = emp_Name;
    }

    public String getEmp_ID() {
        return emp_ID;
    }

    public void setEmp_ID(String emp_ID) {
        this.emp_ID = emp_ID;
    }

    public Position getEmp_Position() {
        return emp_Position;
    }

    public void setEmp_Position(Position position){
        this.emp_Position = position;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return emp_ID.equals(employee.emp_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emp_ID);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_Name='" + emp_Name + '\'' +
                ", emp_ID='" + emp_ID + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", emp_Position=" + emp_Position +
                '}';
    }
}
