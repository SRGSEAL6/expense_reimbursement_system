package model;

public class Reimbursement {
    private String reim_Id, emp_Name, emp_ID, reim_Details;
    private Status reim_Status = Status.PENDING;
    private double amount;
    public Reimbursement(){

    }

    public Reimbursement(String emp_Name, String emp_ID,String reim_Details, double amount) {
        this.emp_Name = emp_Name;
        this.emp_ID = emp_ID;
        this.reim_Details = reim_Details;
        this.amount = amount;
    }
    public Reimbursement(String reim_Id,String emp_Name, String emp_ID,String reim_Details,Status reim_Status, double amount) {
        this.emp_Name = emp_Name;
        this.emp_ID = emp_ID;
        this.reim_Details = reim_Details;
        this.reim_Status = reim_Status;
        this.amount = amount;
        this.reim_Id = reim_Id;
    }

    public String getReim_Id() {
        return reim_Id;
    }

    public String getEmp_Name() {
        return emp_Name;
    }

    public String getEmp_ID() {
        return emp_ID;
    }

    public String getDetails() {
        return reim_Details;
    }

    public double getAmount() {
        return amount;
    }

    public Status getStatus() {
        return reim_Status;
    }

    public void setStatus(Status status) {
        this.reim_Status = status;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reim_Id='" + reim_Id + '\'' +
                ", emp_Name='" + emp_Name + '\'' +
                ", emp_ID='" + emp_ID + '\'' +
                ", reim_Details='" + reim_Details + '\'' +
                ", reim_Status=" + reim_Status +
                ", amount=" + amount +
                '}' + "\n";
    }
}
