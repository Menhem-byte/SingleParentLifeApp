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
public class MyfavoriteServlet extends HttpServlet {

   
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
           
           singleparents = fs.getFavourited(email);
           
           request.setAttribute("singleparents", singleparents);
        
        }
        
        
        
         catch (Exception ex) {
            Logger.getLogger(MyfavoriteServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        } 
        getServletContext().getRequestDispatcher("/WEB-INF/myfavorite.jsp").forward(request, response);
     
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

 
}
