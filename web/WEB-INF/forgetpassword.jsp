<%-- 
    Document   : forgetpassword
    Created on : Jun 10, 2021, 12:44:34 PM
    Author     : 631503
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="styles/forgetpassword.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SingleParentLife</title>
        <link rel="stylesheet" href="styles/common.css">
        <style>
            .container{
                background: #ffffff;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <img src="images/LOGO.png" alt="" id="logo">
            <a href="login" style="font-size: 30px; text-decoration: none; color:#4f66da;">🠔</a>
            <h1>SingleParentLife</h1>
            <form method="post" action="forgetpassword">
                <table>
                    <tr>
                        <td>Email</td>
                    </tr>
                    <tr>       
                        <td><input type="text" size="40" name="email"></td>
                    </tr>
                </table>
                <p></p>
                <input type="submit" style="width: 100%; margin-top: 15px; height: 40px; border: none; border-radius: 8px;" value="Submit"><br>
                <p></p>
            </form>
        </div>
    </body>
</html>
