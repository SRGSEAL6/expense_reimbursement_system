package model;

public class Reimbursement {
    private String emp_Name, emp_ID, details, status = "pending";
    double amount;

    public Reimbursement(String emp_Name, String emp_ID, double amount) {
        this.emp_Name = emp_Name;
        this.emp_ID = emp_ID;
        this.amount = amount;
    }

    public String getEmp_Name() {
        return emp_Name;
    }

    public String getEmp_ID() {
        return emp_ID;
    }

    public String getDetails() {
        return details;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "emp_Name='" + emp_Name + '\'' +
                ", emp_ID='" + emp_ID + '\'' +
                ", amount=" + amount +
                '}';
    }
}
