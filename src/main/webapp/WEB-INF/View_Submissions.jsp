<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
  <script src="https://kit.fontawesome.com/fe39c9d352.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="style.css">
  <title>View Reimbursement Submissions</title>
</head>
<body>

<!--- Manager: View All Expense Reimbursement Request Submissions ---->

<!--- Navbar --->
<nav class="navbar navbar-expand-lg bg-dark navbar-dark py-3 fixed-top">
    <div class="container">
        <a href="#" class="navbar-brand">
            Expense Reimbursement System
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navmenu">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navmenu">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a href="ViewSubmissions" class="nav-link">
                        View Submissions
                    </a>
                </li>
                <li class="nav-item">
                    <a href="./login_page.html" class="nav-link">
                        Employee Home Page
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
      View Your Reimbursement Submissions
    </h1>
  </div>
</Header>

<!------ Employee Reimbursement (Current/Previous) Request Section -------->
    <section>
        <div class="p-3">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Submission ID</th>
                        <th scope="col">Description</th>
                        <th scope="col">Amount</th>
                        <th scope="col">Status</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Reimbursement> employeeReimSub = (List<Reimbursement>) request.getAttribute("reimbursementList");
                            for(Reimbursement employeeReimbursements:employeeReimSub){
                    %>

                    <tr>
                        <td> <%=employeeReimbursements.getReimId() %> </td>
                        <td> <%=employeeReimbursements.getReimDetails() %> </td>
                        <td> <%=employeeReimbursements.getAmount() %> </td>
                        <td> <%=employeeReimbursements.getStatus() %> </td>
                    </tr>

                    <%
                        }
                    %>

                </tbody>
            </table>
        </div>
    </section>

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

</body>
</html>
