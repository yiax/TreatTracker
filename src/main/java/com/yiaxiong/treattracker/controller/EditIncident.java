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
 *
 *
 * @author Yia Xiong
 */
@WebServlet(
        name = "edit-incident",
        urlPatterns = { "/edit-incident" }
)
public class EditIncident extends HttpServlet {

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

        GenericDao incidentDao = new GenericDao(Incident.class);
        List<Incident> incidents = incidentDao.getAll();
        HttpSession session = request.getSession();
        int idToEdit = Integer.parseInt(request.getParameter("id").trim()) ;
        Incident incidentToEdit = new Incident();
        String url = "";
        String message = "";

        for (Incident incident : incidents) {
            if (incident.getId() == idToEdit) {
                incidentToEdit = incident;
            }
        }

        if (request.getParameter("edit").equals("delete")) {

            message = incidentToEdit.getUser().getFirst_name() + " " + incidentToEdit.getUser().getLast_name() +
                    " incident recorded on " + incidentToEdit.getIncident_date() + " was successfully deleted.";

            request.setAttribute("message", message);

            incidentDao.delete(incidentToEdit);

            //TODO: if there is an associated resolution, check for existing incident and assign to the incident

            url = "all-incidents";
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request,response);
        } else if (request.getParameter("edit").equals("update")){
            url = "TreatTracker/update-incident?id=" + idToEdit;
        } else {
            url = "/TreatTracker/all-incident?invalid";
        }
        // Redirect to get all users
        //response.sendRedirect(url);
    }
}