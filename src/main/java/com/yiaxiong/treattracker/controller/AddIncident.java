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
import java.io.IOException;
import java.time.LocalDateTime;


/**
 *This servlet add a new incident to a user.
 *
 * @author Yia Xiong
 */
@WebServlet(
        name = "add-incident",
        urlPatterns = { "/add-incident" }
)
public class AddIncident extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Get all the incidents and send to jsp to be display
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the user
        GenericDao<User> userDao = new GenericDao(User.class);
        User user = userDao.findByPropertyEqual("email", request.getParameter("email")).get(0);

        // Create incident
        Incident incident = new Incident();
        incident.setUser(user);
        incident.setDescription(request.getParameter("subject"));
        incident.setIncident_date(LocalDateTime.now());

        // Add into DB
        GenericDao<Incident> incidentDao = new GenericDao(Incident.class);
        incidentDao.insert(incident);

        String message = user.getFirst_name() + user.getLast_name() + "'s incident on " + request.getParameter("date") + " has been tracked.";

        // assign the list to attribute
        request.setAttribute("message", message);

        // Forward to the HTTP Request and Response to JSP
        String url = "all-emails?id=" + request.getParameter("id");

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}