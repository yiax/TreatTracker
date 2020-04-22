<%--
  Created by IntelliJ IDEA.
  User: Yia Xiong
  Date: 2/24/20
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-expand-md bg-white">
    <a class="navbar-brand" href="index.jsp">LOGO</a>
    <ul class="navbar-nav mr-auto">
        <li class="nav-item">
            <a class="nav-link text-dark" href="user-home">My Dashboard</a>
        </li>
    </ul>
    <ul class="navbar-nav ml-auto">
        <li class="nav-item"><a class="nav-link" href="#">My Account</a></li>
        <li class="nav-item"><a class="nav-link" href="admin.jsp">Admin</a></li>
    </ul>
</nav>

<div class="modal fade" id="resolveModal" tabindex="-1" role="dialog" aria-labelledby="resolveModal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content rounded-0">
            <div class="modal-header">
                <h4 class="modal-title" id="resolveModalLabel">Resolve a treat incident by submitting a message.</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">x</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="#" class="needs-validation" novalidate>
                    <div class="form-group">
                        <label for="message">Message:</label>
                        <textarea class="form-control" id="message" placeholder="Enter message" name="message" required></textarea>
                        <div class="valid-feedback">Valid.</div>
                        <div class="invalid-feedback">Please enter your message.</div>
                    </div>
                    <button type="submit" class="btn btn-primary">Enter</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script>validateForm()</script>

