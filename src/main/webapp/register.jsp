<%--
  Created by IntelliJ IDEA.
  User: yiax
  Date: 5/3/20
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="contentType.jsp" />
<html lang="en" class=""h-100>
<jsp:include page="head.jsp" />
<body class="h-100">
<div class="container">
    <jsp:include page="navbar.jsp" />

    <div class="container h-100">
        <div class="row h-100 justify-content-center align-items-center">
            <div class="col-10 col-md-8 col-lg-6">
                <form action="register" method="post">
                    <h1>Register</h1>
                    <div class="form-group" id="firstNameDiv">
                        <label for="firstName">First Name:</label>
                        <input type="text" class="form-control firstName" id="firstName" placeholder="First Name...">
                    </div>
                    <div class="form-group" id="Last Name">
                        <label for="lastName">Last Name:</label>
                        <input type="text" class="form-control lastName" id="lastName" placeholder="Email...">
                    </div>
                    <div class="form-group" id="emailDiv">
                        <label for="email">Email:</label>
                        <input type="text" class="form-control email" id="email" placeholder="Email...">
                    </div>
                    <div class="form-group" id="userNameDiv">
                        <label for="username">Username:</label>
                        <input type="text" class="form-control username" id="username" placeholder="Username...">
                    </div>
                    <div class="form-group" id="passwordDiv">
                        <label for="password">Password:</label>
                        <input type="password" class="form-control password" id="password" placeholder="Password...">
                    </div>
                    <div class="form-group" id="passwordConfirmDiv">
                        <label for="confirmPassword">Confirm Password:</label>
                        <input type="password" class="form-control password" id="confirmPassword" placeholder="Re-type Password...">
                    </div>
                    <button type="submit">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>