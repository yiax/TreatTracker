package com.yiaxiong.treattracker.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.yiaxiong.treattracker.entity.*;
import com.yiaxiong.treattracker.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This servlet validate the user login and sends the user's home page.
 *
 * @author Yia Xiong
 */
@WebServlet(name = "Login", urlPatterns = { "/login" } )

public class Login extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * This method handles HTTP GET requests and forwards the request to the
     * user's home page.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the email and password
        String searchTerm = request.getParameter("email");
        String searchType = request.getParameter("password");
/*
        ServletContext context = getServletContext();
        GenericDao dao = new GenericDao(User.class);
        while (user)
        dao.getUser();

        RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
        dispatcher.forward(req, resp);*/
    }
}