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
 * This servlet update the information from the jsp for a user.
 *
 * @author Yia Xiong
 */
@WebServlet(
        name = "update-user",
        urlPatterns = { "/update-user" }
)
public class UpdateUser extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * This method retrieve the new user information from the jsp, and update the user's info in the DB
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean updated = false;
        String url = "/TreatTracker/all-users?function=edit";
        HttpSession session = request.getSession();
        int userID = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName").trim();
        String lastName = request.getParameter("lastName").trim();
        String email = request.getParameter("email").trim();
        String username = request.getParameter("username").trim();
        String delete = request.getParameter("delete");

        GenericDao<User> userDAO = new GenericDao<>(User.class);
        GenericDao<Role> roleDAO = new GenericDao<>(Role.class);

        List<Role> roles = roleDAO.getAll();

        User user = userDAO.getById(userID);

        if (delete != null && delete.equals("delete")) {
            for (Role role:roles) {
                if (role.getUser().equals(user)) {
                    if (delete.equals("delete")) {
                        url += "&delete=y&first=" + user.getFirst_name() + "&last=" + user.getLast_name() ;
                        roleDAO.delete(role);
                        userDAO.delete(user);
                        break;
                    }
                }
            }
        } else {
            for (Role role:roles) {
                if (role.getUser().equals(user)) {
                    if (!role.getRole().equals(request.getParameter("role"))) {
                        role.setRole(request.getParameter("role"));
                        roleDAO.saveOrUpdate(role);
                        updated = true;
                    }
                }
            }

            if (!user.getFirst_name().equals(firstName)) {
                user.setFirst_name(firstName);
                updated = true;
            }

            if (!user.getLast_name().equals(lastName)) {
                user.setLast_name(lastName);
                updated = true;
            }

            if (!user.getUser_name().equals(username)) {
                user.setUser_name(username);
                updated = true;
            }

            if (!user.getEmail().equals(email)) {
                user.setEmail(email);
                updated = true;
            }

            if (updated) {
                userDAO.saveOrUpdate(user);
                url += "&first=" + user.getFirst_name() + "&last=" + user.getLast_name();
            }
        }

        // Redirect to get all users
        response.sendRedirect(url);
    }
}