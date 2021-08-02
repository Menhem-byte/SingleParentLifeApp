/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.SingleParent;
import services.AccountService;
import utilities.CookieUtil;

/**
 *
 * @author 631503
 */
public class LoginServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        //session.invalidate();

        //Cookie[] cookies = request.getCookies();
        //String email = CookieUtil.getCookieValue(cookies, "email");
        //request.setAttribute("email", email);
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //Cookie cookie = new Cookie("email", email);
        //cookie.setMaxAge(60 * 60 * 24 * 365 * 3);
        //response.addCookie(cookie);
        AccountService as = new AccountService();
        //String path = getServletContext().getRealPath("/WEB-INF");
        SingleParent singleParent = as.login(email, password);

        /*try {
            
             singleParent = as.login(email, password, path);
        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        if (singleParent == null) {
            request.setAttribute("message", "Invalid login. Enter correct username and password.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }

        session.setAttribute("email", email);

        if (singleParent.getFirstName() != null) {
            session.setAttribute("userEmail", singleParent.getEmail());
            response.sendRedirect("match");
        }

    }

}
