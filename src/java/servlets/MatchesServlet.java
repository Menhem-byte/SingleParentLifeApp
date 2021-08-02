/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.SingleParent;
import services.AccountService;
import services.FriendshipService;

/**
 *
 * @author itsupport
 */
public class MatchesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     FriendshipService fs = new FriendshipService();
        AccountService as = new AccountService();
        request.setAttribute("email","email");
        List <SingleParent> singleparents = null;
        try{
        
          HttpSession session = request.getSession();
            String email = (String) session.getAttribute("email");
           SingleParent sp = as.get(email);
           
           singleparents = fs.getMatched(email);
           
           request.setAttribute("singleparents", singleparents);
        
        }
        
        
        
         catch (Exception ex) {
            Logger.getLogger(MatchServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        } 
        getServletContext().getRequestDispatcher("/WEB-INF/matches.jsp").forward(request, response);
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

  
}
