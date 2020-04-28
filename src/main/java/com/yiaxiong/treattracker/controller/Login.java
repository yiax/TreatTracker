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
import java.io.IOException;
import java.util.List;

/**
 *
 *
 * @author Yia Xiong
 */
@WebServlet(
        name = "login",
        urlPatterns = { "/login" }
)
public class Login extends HttpServlet {

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

        // Forward to the HTTP Request and Response to JSP
        String url = "/login.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}