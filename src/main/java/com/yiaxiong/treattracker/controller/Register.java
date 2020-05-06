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


/**
 *
 *
 * @author Yia Xiong
 */
@WebServlet(
        name = "register",
        urlPatterns = { "/register" }
)
public class Register extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
 //   private String firstName = "";
  //  private String lastName = "";
  //  private String username = "";
  //  private String email = "";
  //  private String password = "";

    /**
     *
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception ServletException  if there is a Servlet failure
     *@exception IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

     //   firstName = request.getParameter("firstName");
     //   lastName = request.getParameter("lastName");
     //   username = request.getParameter("username");
     //   email = request.getParameter("email");
     //   password = request.getParameter("password");

        //TODO - validate that email does not already exist. If email already exist, display error message
        GenericDao userDAO = new GenericDao(User.class);
        logger.info(request.getParameter("firstName"));
        logger.info(request.getParameter("lastName"));
        logger.info(request.getParameter("email"));
        logger.info(request.getParameter("username"));
        logger.info(request.getParameter("password"));
        System.out.println(request.getParameter("firstName"));
        System.out.println(request.getParameter("lastName"));
        System.out.println(request.getParameter("email"));
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
        User newUser = new User(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("email"), request.getParameter("userName"), request.getParameter("password"));
        userDAO.insert(newUser);
/*
        while (loop) {
            if (duplicateEmail || duplicateUsername || passwordMismatch) {

            } else {
                for (User user: users) {
                    if (user.getEmail().equals(request.getParameter("email"))) {
                        duplicateEmail = true;
                    }

                    if (user.getUser_name().equals(request.getParameter("username"))) {
                        duplicateUsername = true;
                    }
                }

                if (!request.getParameter("password").equals(request.getParameter("confirmPassword"))) {
                    passwordMismatch = true;
                }
            }
        }
      */



        //TODO - validate that username does not already exist. If username already exist, display error message
        //TODO - validate that password and confirmPassword match. If password and confirmPassword does not match, display error message
        //TODO - if all validations checks, add user to DB and forward to login

        // Forward to the HTTP Request and Response to JSP
        String url = "/index.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


}