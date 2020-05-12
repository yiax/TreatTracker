package com.yiaxiong.treattracker.controller;

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
 * This servlet get the user's information
 *
 * @author Yia Xiong
 */
@WebServlet(
        name = "user-info",
        urlPatterns = { "/user-info" }
)
public class GetUserInfo extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Get the user's information and send to jsp for display
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userID = Integer.parseInt(request.getParameter("id"));

        //Get all users
        GenericDao userDAO = new GenericDao(User.class);

        User user = (User) userDAO.getById(userID);

        request.setAttribute("firstName", user.getFirst_name());
        request.setAttribute("lastName", user.getLast_name());
        request.setAttribute("email", user.getEmail());
        request.setAttribute("username", user.getUser_name());
        request.setAttribute("success", 1);
        // Forward to the HTTP Request and Response to JSP
        String url = "/editUser.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}