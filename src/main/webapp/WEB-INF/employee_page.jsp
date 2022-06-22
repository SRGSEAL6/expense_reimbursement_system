<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/fe39c9d352.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="style.css">
    <title>Employee Home Page</title>

</head>
<body>

<!--- Navbar --->
<nav class="navbar navbar-expand-lg bg-dark navbar-dark py-3 fixed-top">
    <div class="container">
        <a href="#" class="navbar-brand">
            Expense Reimbursement System
        </a>
        <button
                class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navmenu"
        >
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navmenu">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a href="./EmployeeRegistrationForm.html" class="nav-link">
                        Reimbursement Request Form
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#ViewSubmissions" class="nav-link">
                        View Submissions
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#Managers" class="nav-link">
                        Finance Managers
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#FrequentQuestions" class="nav-link">
                        Questions
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

<!-----Introduction Container ------>
<section class="bg-dark text-light p-5 text-center text-sm-start">
    <div class="container">
        <div class="d-sm-flex p-3 align-items-center">
            <div class="m-4">
                <h1>
                    Hello
                    <span class="text-warning">
                            Revature
                        </span>
                </h1>
                <p class="lead">
                    Employees are the soul of our company. We value everyone and want to make sure any business-related expense is reimbursed.
                    All you have to do is fill out an Expense Reimbursement Form.
                </p>
                <button href="./ReimbursementRequestForm.html" class="btn btn-primary btn-lg m-3 p-3 rounded-pill">
                    Reimbursement Request Form
                </button>
            </div>
            <image class="img-fluid w-50 mx-2 d-none d-sm-block" src="./images/navbar_workforce.jpeg" alt="A group of employees sitting at a table smiling and laughing."/>
        </div>
    </div>
</section>


<!------ Employee Reimbursement (Current/Previous) Request Section -------->
<section>
    <div id="#ViewSubmissions" class="container-expand m-5">
        <h1 class="bg-primary text-light text-center p-5">View<br><span class="text-warning">Submissions</span></h1>
        <table class="table mb-3 table-striped table-hover">
            <thead>
            <tr>
                <th scope="col">Form ID</th>
                <th scope="col">Submission Date</th>
                <th scope="col">View Submitted Form</th>
                <th scope="col">Status</th> <!--- create conditional statement for if approved text is green, else if denied text be red, else if pending text be orange--->
            </tr>
            </thead>
            <!--  Need Input to be brought here for individual employee submission  --->
        </table>
    </div>
</section>


<!---- Sign our work ---->
<section id="Managers" class="p-5 bg-dark">
    <div class="container">
        <h1 class="text-center text-light mb-4">
            Finance Managers
        </h1>
        <p class="led text-center text-light mb-5">
            <span class="text-warning"><strong>Do you have any questions?</strong></span><br>Feel free to send an email to a manager with any questions and/or concerns.
        </p>
        <div class="row g-4">

            <!--- Manager 1 -------------------------------------->
            <div class="col-md-6 col-lg">
                <div class="card bg-primary">
                    <div class="card-body text-center border border-light border-2">
                        <img src="./images/male-finance-manager.png" class="border border-dark border-3 rounded-circle m-3" width="225px" height="225px" alt="Icon in black and white of male figure from the shoulder up."/>
                        <h2 class="card-title text-warning">
                            Javier Mendiola
                        </h2>
                        <h5 class="mb-4"><strong>Finance Manager</strong></h5>
                        <a href="mailto: javier.mendiola@err.system" class="btn btn-dark btn-lg rounded-pill mb-3">Send Email</a>
                    </div>
                </div>
            </div>

            <!--- Manager 2 -------------------------------------->
            <div class="col-md-6 col-lg">
                <div class="card bg-primary">
                    <div class="card-body text-center border border-light border-2">
                        <img src="./images/female-finance-manager.png" class="border border-dark border-3 rounded-circle m-3" width="225px" height="225px" alt="Icon in black and white of female figure from the shoulder up"/>
                        <h2 class="card-title text-warning">
                            Genevieve Scholler
                        </h2>
                        <h5 class="mb-4"><strong>Finance Manager</strong></h5>
                        <a href="mailto: genevieve.scholler@err.system" class="btn btn-dark btn-lg rounded-pill mb-3">Send Email</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!---- Accordian of Questions and Answers for Employees pertaining to Reimbursement Requests ----->
<section id="#FrequentQuestions" class="bg-warning p-5">
    <div class="container">
        <h2 class="text-dark text-center mb-4">
            Frequently Asked Questions
        </h2>
        <div class="accordion border border-primary border-2 rounded">

            <!---- Accordion Question 1 ----->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#Questions-one">
                        What is an expense reimbursement?
                    </button>
                </h2>
                <div id="Questions-one" class="accordion-collapse collapse show" data-bs-parent="#Questions">
                    <div class="accordion-body">
                        <strong>An expense reimbursement is the payment made from your business to any employee for business-related expenses they have incurred personally.</strong>

                    </div>
                </div>
            </div>

            <!---- Accordion Question 2 ----->
            <div class="accordion-item">
                <h2 class="accordion-header" >
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#Questions-two">
                        What expenses are reimbursable?
                    </button>
                </h2>
                <div id="Questions-two" class="accordion-collapse collapse" data-bs-parent="#Questions">
                    <div class="accordion-body">
                        <strong>Business expenses are the costs of operating a business.</strong> For example, advertising and marketing, equipment maintenance and repair, office supplies and equipment, and etc. If you have any questions pertaining to an expenditure and if it's a business-related expense, please reach out to a manager.
                    </div>
                </div>
            </div>

            <!---- Accordion Question 3 ----->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#Questions-three">
                        Do I need receipts in order to be reimbursed?
                    </button>
                </h2>
                <div id="Questions-three" class="accordion-collapse collapse" data-bs-parent="#Questions">
                    <div class="accordion-body">
                        <strong>YES!</strong> If you do not supply the necessary receipt(s) to validate the expenditure made from a business-related expense, your reimbursement request will be denied.
                    </div>
                </div>
            </div>

            <!---- Accordion Question 4 ----->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#Questions-four">
                        What does it mean when my reimbursement request has been denied?
                    </button>
                </h2>
                <div id="Questions-four" class="accordion-collapse collapse" data-bs-parent="#Questions">
                    <div class="accordion-body">
                        <strong>There's a few reasons why your reimbursement request was denied.</strong> First, did your request include receipt(s) validating the expense made? Second, was the expense made business-related? Otherwise, please connect with a manager to get more information pertaining to your denied request.
                    </div>
                </div>
            </div>
        </div>
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