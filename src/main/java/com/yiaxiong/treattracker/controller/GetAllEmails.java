package com.yiaxiong.treattracker.controller;

import com.google.api.services.gmail.model.Message;
import com.yiaxiong.treattracker.entity.Incident;
import com.yiaxiong.treattracker.entity.Role;
import com.yiaxiong.treattracker.entity.User;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *This servlet retrieve emails from a Gmail account.
 * @author Yia Xiong
 */
@WebServlet(
        name = "all-emails",
        urlPatterns = { "/all-emails" }
)
public class GetAllEmails extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Get email by calling the Gmail API and sending all emails to the jsp.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Map<String, String>> messages = new ArrayList<Map<String, String>>();

        try {
            GmailAPI gmailAPI = new GmailAPI();
            if (request.getParameter("id") != null) {
                //Delete the email
                gmailAPI.removeEmail(request.getParameter("id"));
            } else {
                //Read from email
                messages = gmailAPI.getEmails();
            }

        } catch (GeneralSecurityException generalSecurityException) {
            logger.error(generalSecurityException);
        } catch (MessagingException messagingException) {
            logger.error(messagingException);
        }

        // assign the list to attribute
        request.setAttribute("emails", messages);

        // Forward to the HTTP Request and Response to JSP
        String url = "/emails.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}