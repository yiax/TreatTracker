package com.yiaxiong.treattracker.controller;

import com.yiaxiong.treattracker.entity.Incident;
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
 * This servlet update the information for an incident.
 *
 * @author Yia Xiong
 */
@WebServlet(
        name = "update-incident",
        urlPatterns = { "/update-incident" }
)
public class UpdateIncident extends HttpServlet {

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

        HttpSession session = request.getSession();

        int id = Integer.parseInt(request.getParameter("id").trim());

        GenericDao incidentDao = new GenericDao(Incident.class);
        Incident incident = (Incident) incidentDao.getById(id);

        request.setAttribute("user", incident.getUser());
        request.setAttribute("date", incident.getIncident_date());
        request.setAttribute("description", incident.getDescription());
        request.setAttribute("resolution", incident.getResolution());

        String url = "";


        // Redirect to get all users
        //response.sendRedirect(url);
    }
}