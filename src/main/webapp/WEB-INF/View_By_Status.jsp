<%@ page import="model.Reimbursement" %>
<%@ page import="java.util.List" %>
<%@ page import="Service.ManagerOptions" %>
<%@ page import="model.Status" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
  <script src="https://kit.fontawesome.com/fe39c9d352.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="style.css">
  <title>View All Expense Reimbursement Request Submissions</title>
</head>
<body>
<!--- Manager: View All Expense Reimbursement Request Submissions ---->

<!--- Navbar --->
<nav class="navbar navbar-expand-lg bg-dark navbar-dark py-3 fixed-top">
  <div class="container">
    <a href="#" class="navbar-brand text-light">
      Expense Reimbursement System
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navmenu">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navmenu">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item">
          <a href="./ReimbursementRequestForm.html" class="nav-link">
            Reimbursement Request Form
          </a>
        </li>
        <li class="nav-item">
          <a href="./EmployeeRegistrationForm.html" class="nav-link">
            Employee Registration
          </a>
        </li>
        <li class="nav-item">
          <a href="./View_All_Employees.html" class="nav-link">
            View All Employees
          </a>
        </li>
        <li class="nav-item">
          <a href="./View_All_ERR_Submissions.html" class="nav-link">
            Reimbursement Submissions
          </a>
        </li>
        <li class="nav-item">
          <a href="./login_page.html" class="nav-link">
            Logout
          </a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<Header class="bg-primary">
  <div class="text-center pt-5 m-2">
    <i class='fas fa-eye' style="font-size:100px;"></i>
  </div>
  <div class="text-center m-3">
    <h1 class="text-warning pb-5" style="font-size:64px;">
      Reimbursement Submissions
    </h1>
  </div>
</Header>

<!-------- Submissions ------------------------------------>
<Section class="p-3">

  <!--- buttons to find certain parameters ---->
  <div class="container">
    <div class="text-center">   <!-- Add Search bar in order to view specific employees and fix columns--->
      <a class="btn btn-primary" name="View_All_ERR_Submissions">View All Submissions</a>
      <a class="btn btn-warning" name="empPendingRequests">View Pending Submissions</a> <!--- Current ---->
      <a class="btn btn-success" name="empApprovedRequests">View Approved Submissions</a> <!------Previous -->
      <a class="btn btn-danger" name="empDeclinedRequests">View Declined Submissions</a> <!------Previous -->
    </div>
  </div>
</section>
<!----Table to view submissions currently and previously  --->
<section>
  <div class="p-3">
    <table class="table">  <!--- Need Servlet for viewing submissions  -->
      <thead>
      <tr>
        <th>Submission ID</th>
        <th>Name</th>
        <th>Employee ID</th>
        <th>Reimbursement Details</th>
        <th>Amount</th>
        <th>Status</th> <!---- Need to provide inserts of approving or declining submission----->
      </tr>
      </thead>
      <tbody>
         <%
         ManagerOptions managerOptions = new ManagerOptions();
         List<Reimbursement> reimbursements = managerOptions.getByStatus((Status)(request.getAttribute("status"));
         for(Reimbursement reimbursement: reimbursements){
         %>
      <tr>
        <th> <%=reimbursement.getReim_Id() %></th>
        <td><%=reimbursement.getEmp_Name() %></td>
        <td><%=reimbursement.getEmp_ID() %></td>
        <td><%=reimbursement.getDetails() %></td>
        <td><%=reimbursement.getAmount() %></td>
        <td><%=reimbursement.getStatus() %></td>
      </tr>

      <%
        }
      %>
      </tbody>
    </table>
  </div>
</Section>


<!--- FOOTER  --->
<footer class="p-5 bg-dark position-relative"> <!------ Need to get footer to stay on the bottom of the page------------->
  <div class="container">
    <h4 class="lead text-center text-primary">
      Copyright &copy; 2022 Expense Reimbursement System
    </h4>
  </div>
  </div>
</footer>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
<script src="./View_All_ERR_Submissions.js"></script>
</body>
</html>