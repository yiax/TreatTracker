package com.yiaxiong.treattracker.controller;

import com.yiaxiong.treattracker.entity.Role;
import com.yiaxiong.treattracker.entity.User;
import com.yiaxiong.treattracker.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 *
 *
 * @author Yia Xiong
 */
@WebServlet(
        name = "register",
        urlPatterns = { "/register" }
)
public class Register extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<User> userDAO = new GenericDao<>(User.class);
    private GenericDao<Role> roleDAO = new GenericDao<>(Role.class);
    HttpSession session;

    /**
     *
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception ServletException  if there is a Servlet failure
     *@exception IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession();

        request.setAttribute("duplicateEmail", "false");
        request.setAttribute("duplicateUsername", "false");

        ValidateDuplicateUsernameAndEmail(request);
        CheckPasswordMismatch(request);

        if (request.getAttribute("duplicateEmail").equals("false") &&
                request.getAttribute("duplicateUsername").equals("false") &&
                request.getAttribute("passwordMismatch").equals("false")) {

            CreateUserAndRoles(request);
            request.setAttribute("success", "true");
        }

        // Forward to the HTTP Request and Response to JSP
        String url = "/register.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    /**
     * This method checks to see if the username and email entered by the registrant are
     * already in use.
     *
     * @param request the HttpServletRequest object
     */
    private void ValidateDuplicateUsernameAndEmail(HttpServletRequest request) {
        List<User> users = userDAO.getAll();
        for (User user : users) {
            // check for duplicate email
            if (request.getParameter("email").equals(user.getEmail())) {
                request.setAttribute("duplicateEmail", "true");
            }
            // check for duplicate username
            if (request.getParameter("username").equals(user.getUser_name())) {
                request.setAttribute("duplicateUsername", "true");
            }
        }
    }

    /**
     * This method checks if the passwords entered by the registrant is a match or mismatch.
     *
     * @param request the HttpServletRequest object
     */
    private void CheckPasswordMismatch(HttpServletRequest request) {
        if (!request.getParameter("password").equals(request.getParameter("confirmPassword"))) {
            request.setAttribute("passwordMismatch", "true");
        } else {
            request.setAttribute("passwordMismatch", "false");
        }
    }

    /**
     * This method creates a User and a User Role and store into the databases.
     *
     * @param request the HttpServletRequest object
     */
    private void CreateUserAndRoles(HttpServletRequest request) {
        String defaultRole = "basic";
        User newUser = new User(request.getParameter("firstName").trim(),
                request.getParameter("lastName").trim(),
                request.getParameter("email").trim(),
                request.getParameter("username").trim(),
                request.getParameter("password").trim());

        userDAO.insert(newUser);

        Role newRole = new Role(newUser, defaultRole);
        roleDAO.insert(newRole);
    }
}