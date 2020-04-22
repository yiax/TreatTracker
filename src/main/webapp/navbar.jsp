<%--
  Created by IntelliJ IDEA.
  User: Yia Xiong
  Date: 2/24/20
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-md bg-white">
    <a class="navbar-brand" href="index.jsp">LOGO</a>
    <ul class="navbar-nav mr-auto">
        <li class="nav-item">
            <a class="nav-link text-dark" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-dark" href="about.jsp">About</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-dark" href="contact.jsp">Contact</a>
        </li>
    </ul>
    <ul class="navbar-nav ml-auto">
        <li class="nav-item"><a class="nav-link" data-toggle="modal" data-target="#loginModal" href="#">My Account</a></li>
        <li class="nav-item"><a class="nav-link" data-toggle="modal" data-target="#registerModal" href="#">Register</a></li>
    </ul>
</nav>

<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content rounded-0">
            <div class="modal-header">
                <h4 class="modal-title" id="myLoginModalLabel">My Account Login</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">x</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="j_security_check" method="post" class="needs-validation" novalidate>
                    <div class="form-group">
                        <label for="user_name">User Name:</label>
                        <input type="text" class="form-control" id="user_name" placeholder="Enter User Name" name="j_username" required>
                        <div class="valid-feedback">Valid.</div>
                        <div class="invalid-feedback">Please enter your email.</div>
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" class="form-control" id="password" placeholder="Enter password" name="j_password" required>
                        <div class="valid-feedback">Valid.</div>
                        <div class="invalid-feedback">Please enter your password.</div>
                    </div>
                    <button type="submit" class="btn btn-primary">Enter</button>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="loginModal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content rounded-0">
            <div class="modal-header">
                <h4 class="modal-title" id="myRegisterModalLabel">Register Information</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">x</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="#" class="needs-validation" novalidate>
                    <div class="form-group">
                        <label for="registerEmail">Email:</label>
                        <input type="text" class="form-control" id="registerEmail" placeholder="Enter email" name="registerEmail" required>
                        <div class="valid-feedback">Valid.</div>
                        <div class="invalid-feedback">Please enter your email.</div>
                    </div>
                    <div class="form-group">
                        <label for="registerPassword">Password:</label>
                        <input type="password" class="form-control" id="registerPassword" placeholder="Enter password" name="registerPassword" required>
                        <div class="valid-feedback">Valid.</div>
                        <div class="invalid-feedback">Please enter your password.</div>
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword">Confirm Password:</label>
                        <input type="password" class="form-control" id="confirmPassword" placeholder="Re-enter password" name="confirmPassword" required>
                        <div class="valid-feedback">Valid.</div>
                        <div class="invalid-feedback">Please re-enter your password.</div>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script>validateForm()</script>

