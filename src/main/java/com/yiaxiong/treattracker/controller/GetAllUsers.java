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
import java.util.ArrayList;
import java.util.List;

/**
 * This servlet get all users from the DB
 *
 * @author Yia Xiong
 */
@WebServlet(
        name = "all-users",
        urlPatterns = { "/all-users" }
)
public class GetAllUsers extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Get all the users and their roles. The user and role is send to the appropriate jsp for display.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String url = "";

        //Get all users
        GenericDao userDAO = new GenericDao(User.class);
        List<User> users = userDAO.getAll();
        request.setAttribute("users", users);

        GenericDao roleDAO = new GenericDao(Role.class);
        List<Role> roles = roleDAO.getAll();
        request.setAttribute("roles", roles);

        // Forward to the HTTP Request and Response to JSP
        if (request.getParameter("function").equals("edit")) {
            url = "/editUser.jsp";
        }

        if (request.getParameter(("function")).equals("resolve")) {

            if (session.getAttribute("message") != null) {
                request.setAttribute("message", session.getAttribute("message"));
                session.removeAttribute("message");
            }

            url = "/resolveIncident.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}