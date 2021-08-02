<%-- 
    Document   : matches
    Created on : 27-Jul-2021, 7:38:39 PM
    Author     : itsupport
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="styles/match.css" rel="stylesheet" type="text/css">
          <link href="styles/myfavorite.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="styles/w3.css" type="text/css">
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
            .container{
                background: #ffffff;
            }
        </style>
    </head>
    <body>
         <div class="container">
              <a href="match" style="font-size: 30px; text-decoration: none; color:#4f66da;">🠔</a>
            <img src="images/LOGO.png" alt="" id="logo">
            <h1>SingleParentLife</h1>
           <a name="My matches" class="inline" href="matches">My matches</a>
               <a name="My favorites" class="inline" href="myfavorite">My favorites</a>
                   
               <article class="leaderboard">
                    <main class="leaderboard__profiles">
  <c:forEach items="${singleparents}" var="singleparent">  
      <article class="leaderboard__profile">
        <img src="images/${singleparent.getPhoto()}" alt="Mark Zuckerberg" class="leaderboard__picture"/>
        <span class="leaderboard__name">${singleparent.getFirstName()} <span > ${singleparent.getLastName().charAt(0)}</span><span> , ${singleparent. getAge()}</span></span>
      
        <p>${singleparent. getOccupation()}</p>
      </article>
 </c:forEach>
                          </main>
           </article>      
               
           </div>
    </body>
</html>
