package com.yiaxiong.treattracker.controller;

import com.yiaxiong.treattracker.entity.*;
import com.yiaxiong.treattracker.gmailAPI.GmailAPI;
import com.yiaxiong.treattracker.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Yia Xiong
 */
@WebServlet(
        name = "resolve-incident",
        urlPatterns = { "/resolve-incident" }
)
public class ResolveIncident extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     *
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // Get the userID
        int userID = Integer.parseInt(request.getParameter("id").trim());

        // Get the resolution description
        String newResolutionDescription = request.getParameter("description").trim();

        User userToResolve = new User();
        // Get the user
        GenericDao<User> userDao = new GenericDao<>(User.class);
        List<User> users = userDao.getAll();
        for (User user : users) {
            if (user.getId() == userID) {
                userToResolve = user;
            }
        }

        // Create a resolution
        Resolution newResolution = new Resolution();
        newResolution.setUser(userToResolve);
        newResolution.setDescription(newResolutionDescription);
        newResolution.setResolution_date(LocalDateTime.now());
        GenericDao<Resolution> resolutionDao = new GenericDao<>(Resolution.class);
        resolutionDao.insert(newResolution);

        // Update the incident
        GenericDao incidentDao = new GenericDao(Incident.class);
        Incident incident = (Incident) session.getAttribute("incidentToResolve");
        incident.setResolution(newResolution);
        incidentDao.saveOrUpdate(incident);

        String message = userToResolve.getFirst_name() + " " + userToResolve.getLast_name() + "'s incident from " + incident.getIncident_date() + " has been resolved";
        session.setAttribute("message", message);

        // Send email to all users of resolution
        try {
            GmailAPI email = new GmailAPI(users, incident, newResolutionDescription, message);
            email.send();
        } catch (MessagingException messagingException) {
            logger.error(messagingException);
        } catch (GeneralSecurityException generalSecurityException) {
            logger.error(generalSecurityException);
        }

        // Forward to the HTTP Request and Response to JSP
        String url = "/TreatTracker/all-users?function=resolve";
        response.sendRedirect(url);
    }
}