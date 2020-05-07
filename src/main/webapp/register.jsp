<%--
Created by IntelliJ IDEA.
User: yiax
Date: 5/3/20
Time: 11:48 AM
To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "title" scope = "session" value = "Register"/>
<jsp:include page="contentType.jsp" />
<html lang="en" class=""h-100>
<jsp:include page="head.jsp" />
<body class="h-100">
<div class="container">
    <jsp:include page="navbar.jsp" />
    <div class="container h-100">
        <div class="row h-100 justify-content-center align-items-center">
            <div class="col-10 col-md-8 col-lg-6">
                <c:choose>
                    <c:when test="${not empty success}">
                        <div class="rounded-lg shadow-sm p-4 mb-4 bg-white">
                            <h2 class="d-flex justify-content-center">You've successfully signed up!</h2>
                            <h3 class="d-flex justify-content-center">Please login to get started.</h3>
                            <div class="d-flex justify-content-center">
                                <a href="user-home" class="btn btn-light" role="button">Login</a>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <h1 class="d-flex justify-content-center">Sign Up</h1>
                        <form action="register" method="post" class="needs-validation rounded-lg shadow-sm p-4 mb-4 bg-white" novalidate>
                            <div class="row">
                                <div class="col">
                                    <div class="form-group">
                                        <label for="firstName">First Name:</label>
                                        <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name..." value="${param.firstName}" required>
                                        <div class="valid-feedback">Valid.</div>
                                        <div class="invalid-feedback">Please enter a first name.</div>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="lastName">Last Name:</label>
                                        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name..." value="${param.lastName}" required>
                                        <div class="valid-feedback">Valid.</div>
                                        <div class="invalid-feedback">Please enter a last name.</div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col">
                                    <div class="form-group">
                                        <label for="email">Email:</label>
                                        <input type="text" class="form-control" id="email" name="email" placeholder="Email..." value="${param.email}" required>
                                        <div class="valid-feedback">Valid.</div>
                                        <div class="invalid-feedback">Please enter an email.</div>
                                        <c:if test="${duplicateEmail == 'true'}"><p class="text-danger">This email is already in use. Please enter a new email or login to with the associated account.</p></c:if>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="username">Username:</label>
                                        <input type="text" class="form-control" id="username" name="username" placeholder="Username..." value="${param.username}" required>
                                        <div class="valid-feedback">Valid.</div>
                                        <div class="invalid-feedback">Please enter a username.</div>
                                        <c:if test="${duplicateUsername == 'true'}"><p class="text-danger">This username is not available. Please enter a new username.</p></c:if>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col">
                                    <div class="form-group">
                                        <label for="password">Password:</label>
                                        <input type="password" class="form-control" id="password" name="password" placeholder="Password..." value="${param.password}" required>
                                        <div class="valid-feedback">Valid.</div>
                                        <div class="invalid-feedback">Please enter a password.</div>
                                        <c:if test="${passwordMismatch == 'true'}"><p class="text-danger">The passwords entered does not match.</p></c:if>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="confirmPassword">Confirm Password:</label>
                                        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Re-type Password..." value="${param.confirmPassword}" required>
                                        <div class="valid-feedback">Valid.</div>
                                        <div class="invalid-feedback">Please enter a password.</div>
                                        <c:if test="${passwordMismatch == 'true'}"><p class="text-danger">The passwords entered does not match.</p></c:if>
                                    </div>
                                </div>
                            </div>

                            <div class="d-flex justify-content-center">
                                <button type="submit" class="button">Submit</button>
                            </div>

                        </form>
                        <script>
                            validateForm()
                        </script>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>
</body>
</html>