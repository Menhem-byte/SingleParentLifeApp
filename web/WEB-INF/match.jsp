<%-- 
    Document   : match
    Created on : Jun 16, 2021, 3:01:44 AM
    Author     : 631503
--%>

<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="styles/match.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="styles/w3.css" type="text/css">
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SingleParentLife</title>
     
        <style>
            .container{
                background: #ffffff;
            }
        </style>
    </head>
    <body>
        <div class="container">
              <a href="login" style="font-size: 30px; text-decoration: none; color:#4f66da;">🠔</a>
            <img src="images/LOGO.png" alt="" id="logo">
            <h1>SingleParentLife</h1>
           <a name="My matches" class="inline" href="matches">My matches</a>
               <a name="forgetpaswordbtn" class="inline" href="myfavorite">My favorites</a>
        
         
         
        
        <div class="w3-container">
 


          
          
   <c:forEach items="${singleparents}" var="singleparent">              
<div class="w3-content w3-display-container">

<div class="w3-display-container mySlides">

  <img src="images/${singleparent.getPhoto()}" style="width:100%; height:450px">
  <div class="w3-display-bottomleft w3-large w3-container w3-padding-16 w3-black">
      <h3 >${singleparent.getFirstName()} <span > ${singleparent.getLastName().charAt(0)}</span><span> , ${singleparent. getAge()}</span></h3>
      <p>${singleparent. getOccupation()}</p>
         <p>${singleparent.getAboutUser()}</p>
          
         <b id="friend"  value="${singleparent.getEmail()}">${singleparent.getEmail()}</b> 
    <br>
         <br>
            <br>
         <br>
        
  </div>
         
        <form action="match" method="POST">  
    <input type="hidden" name="friendemailhidden" value="${singleparent.getEmail()}"/>
    
  <button class='icons' style="background-color:greenyellow" name="action" action="submit" value="addtomatches" > <i class="fas fa-heart" style="color:#ffffff; font-size:25px"></i></button>
  
                 <button class='icons'  style="background-color:yellow" name="action" action="submit" value="addtofavorites"> <i class="fas fa-star" style="color:#ffffff; font-size:25px;"></i></button>
                  <button class='icons'  style="background-color:red" name="action" action="submit" value="delete"> <i class="fas fa-times" style="color:#ffffff; font-size:25px; padding-left: 5px;padding-right: 5px"></i></button>
</form>
</div>
       
   </div>
 
  
<button class="w3-button w3-display-left " style='color:orange;' onclick="plusDivs(-1)">&#10094;</button>
<button class="w3-button w3-display-right " onclick="plusDivs(1)">&#10095;</button>


   
  </c:forEach>  


   
        </div>
 
    
             
        
       </div>
 
<script>
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  if (n > x.length) {slideIndex = 1}
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";  
  }
  x[slideIndex-1].style.display = "block";  
}
</script>

</body>
    
</html>