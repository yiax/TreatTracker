package com.yiaxiong.treattracker.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
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

        //Get the user info
        //String username = request.getParameter("username");

        //Get all users
        GenericDao userDAO = new GenericDao(User.class);
        List<User> users = userDAO.getAll();
        request.setAttribute("users", users);
        logger.debug("Sending back the user/s..." + users);

        //Get all incidents
        GenericDao incidentDao = new GenericDao(Incident.class);
        List<Incident> incidents = incidentDao.getAll();
        request.setAttribute("incidents", incidents);

        //Get all resolution
      /*  GenericDao resolutionDao = new GenericDao(Resource.class);
        List<Resolution> resolutions= resolutionDao.getAll();

        List<Object> recentActivities = new ArrayList<>();
        int counter = 0;
        while (incidents.get(counter) != null && resolutions.get(counter) != null) {
            try {
                recentActivities.add(incidents.get(counter));
            } catch (ArrayIndexOutOfBoundsException outOfBound){
                // do nothing
            }

            try {
                recentActivities.add(resolutions.get(counter));
            } catch (ArrayIndexOutOfBoundsException outOfBound){
                // do nothing
            }
        }
        request.setAttribute("recentActivities", recentActivities);*/

        // Forward to the HTTP Request and Response to JSP
        String url = "/home.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}