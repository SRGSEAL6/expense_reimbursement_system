<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
  <script src="https://kit.fontawesome.com/fe39c9d352.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="style.css">
  <title>Manager View of All Employees</title>
</head>
<body>
<!--- Manager: View All Employees ---->

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
            Expense Reimbursement Submissions
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
      View All Employees
    </h1>
  </div>
</Header>
<!--- Employees Registered to ERS --->

    <section>
        <div class="p-3">
            <table class="table">
                <thead>
                    <tr>
                        <th>Employee Name</th>
                        <th>Employee Position</th>
                        <th>Username</th>
                        <th>Password</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Employee> employees = (List<Employee>) request.getAttribute("all-employees");
                            for(Employee employee:employees){
                    %>

                    <tr>
                        <td> <%=employee.getEmp_Name() %> </td>
                        <td> <%=employee.getEmp_Position() %> </td>
                        <td> <%=employee.getUsername() %> </td>
                        <td> <%=employee.getPassword() %> </td>
                    </tr>

                    <%
                        }
                    %>

                </tbody>
            </table>
        </div>
    </section>

<!--- FOOTER  --->
    <footer class="p-5 bg-dark position-relative">
      <div class="container">
        <div class="row">
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