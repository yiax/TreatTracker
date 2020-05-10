package com.yiaxiong.treattracker.controller;

import com.yiaxiong.treattracker.entity.Incident;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 *
 * @author Yia Xiong
 */
@WebServlet(
        name = "incident-info",
        urlPatterns = { "/incident-info" }
)
public class GetIncidentInfo extends HttpServlet {

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
        int userID = Integer.parseInt(request.getParameter("id").trim());
        User queryUser = new User();
        String message = "";
        List<Incident> unresolvedIncidents = new ArrayList<>();
        Incident incidentToResolve = new Incident();

        //Get the user
        GenericDao userDao = new GenericDao(User.class);
        List<User> users = userDao.getAll();
        for (User user : users) {
            if (user.getId() == userID) {
                queryUser = user;
                break;
            }
        }

        //Get incidents for user
        GenericDao incidentDAO = new GenericDao(Incident.class);
        List<Incident> incidents = incidentDAO.findByPropertyEqual("user", userID);

        // Get user's unresolved incidents
        for (Incident incident : incidents) {
            if (incident.getResolution() == null) {
                unresolvedIncidents.add(incident);
            }
        }

        if (incidents.isEmpty() || unresolvedIncidents.isEmpty()) {
            message = queryUser.getFirst_name() + " " + queryUser.getLast_name() + " does not have any Treat Tracker incident.";
        } else {

            incidentToResolve = unresolvedIncidents.get(0);
            message = "Submit a note to resolve and incident for " + queryUser.getFirst_name() + " " + queryUser.getLast_name();
            session.setAttribute("incidentToResolve", incidentToResolve);
            request.setAttribute("resolveForm", 1);
        }


        session.setAttribute("message", message);

        // Forward to the HTTP Request and Response to JSP
        String url = "all-users?function=resolve&id=" +userID;

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}