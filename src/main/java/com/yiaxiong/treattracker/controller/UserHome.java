package com.yiaxiong.treattracker.controller;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.yiaxiong.treattracker.entity.Incident;
import com.yiaxiong.treattracker.entity.Resolution;
import com.yiaxiong.treattracker.entity.User;
import com.yiaxiong.treattracker.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 *
 * @author Yia Xiong
 */
@WebServlet(
        name = "userHome",
        urlPatterns = { "/user-home" }
)
public class UserHome extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     *
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GenericDao userDAO = new GenericDao(User.class);
        List<User> users = userDAO.getAll();
        request.setAttribute("users", users);
        logger.debug("Sending back the user/s..." + users);

    /*    GenericDao incidentDAO = new GenericDao(Incident.class);
        List<Incident> incidents = incidentDAO.getAll();
        request.setAttribute("incidents", incidents);
        logger.debug("Sending back the incident/s..." + incidents);*/

        // Forward to the HTTP Request and Response to JSP
        String url = "/home.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}