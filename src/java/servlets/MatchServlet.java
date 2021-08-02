/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Friendship;
import models.SingleParent;
import services.AccountService;
import services.FriendshipService;
import services.SingleParentService;

/**
 *
 * @author 631503
 */
public class MatchServlet extends HttpServlet {

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
        
        SingleParentService sps = new SingleParentService();
        AccountService as = new AccountService();
        request.setAttribute("email","email");
        List <SingleParent> singleparents = null;
        try{
        
          HttpSession session = request.getSession();
            String email = (String) session.getAttribute("email");
           SingleParent sp = as.get(email);
           
           singleparents = sps.getAll();
           
           request.setAttribute("singleparents", singleparents);
        
        }
        
        
        
         catch (Exception ex) {
            Logger.getLogger(MatchServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        } 
        getServletContext().getRequestDispatcher("/WEB-INF/match.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             
         SingleParentService sps = new SingleParentService();
        FriendshipService fs = new FriendshipService();
        String friendemail = request.getParameter("friendemailhidden");
       
        System.out.println("this is the friend email to add"+friendemail);
        
        String action=request.getParameter("action");
          HttpSession session = request.getSession();
            String email = (String) session.getAttribute("email");
            Date d= new Date();
           
        
         try{
        switch(action){
      
            case "addtomatches":
        {
            try {
              
                char status='1';
                fs.addFriends(email, friendemail);
                  System.out.println("the first one in the case  " +friendemail);
            } catch (Exception ex) {
                Logger.getLogger(MatchServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
          case "delete":
        {
            try {
                char status='1';
                
                fs.deleteFriends(email, friendemail);
            } catch (Exception ex) {
                Logger.getLogger(MatchServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      

    }

}
         catch (Exception ex) {
            Logger.getLogger(MatchServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        }
         
          try {
            List<SingleParent> singleparents = sps.getAll();
             request.setAttribute("singleparents", singleparents);
        } catch (Exception ex) {
            Logger.getLogger(MatchServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        }
       
       
    
        getServletContext().getRequestDispatcher("/WEB-INF/match.jsp").forward(request,response);
    }
}