<%-- 
    Document   : login
    Created on : Jun 9, 2021, 10:28:49 PM
    Author     : 631503
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="styles/login.css" rel="stylesheet" type="text/css">
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
            <a href="index" style="font-size: 30px; text-decoration: none; color:#4f66da;">🠔</a>
            <h1>SingleParentLife</h1>
            <form method="post" action="login">
                <table>
                    <tr>
                        <td>Email</td>
                    </tr>
                    <tr>       
                        <td><input type="text" size="40" name="email"></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                    </tr>
                    <tr>
                        <td><input type="password" size="40" name="password"></td>
                    </tr>
                </table>
                <p></p>
                <input type="submit" style="width: 100%; margin-top: 15px; height: 40px; border: none; border-radius: 8px;" value="Login"><br>
                <p></p>
                <button><a name="forgetpaswordbtn" class="button" href="forgetpassword">Forget Password?</a></button>
            </form>
            <p>${message}</p>
        </div>
    </body>

</html>