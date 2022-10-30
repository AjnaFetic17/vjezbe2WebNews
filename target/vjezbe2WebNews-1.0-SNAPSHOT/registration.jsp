<%-- 
    Document   : registration
    Created on : Oct 20, 2022, 7:21:49 PM
    Author     : Blandus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User registration | Lorem ipsun</title>
        <script src="https://kit.fontawesome.com/40015dd949.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="styles.css" />
        <link rel="stylesheet" href="index.css" />
        <link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'>
    </head>
    <body>

        <div class="container">
            <div class="right">

                <h1>Welcome new  <br> User</h1>
                <p>Please fill in form with your information</p>

            </div>
            <div class="left">
                <h1>Register</h1>
                <div class="icons-container">
                    <div class="tooltip1">
                        <a href="registration.jsp" >
                            <div class="icon-border">
                                <i class="fa-solid fa-user-plus"></i>

                            </div>
                        </a> 
                        <span class="tooltiptext1">
                            Registration...
                        </span>               
                    </div>
                    <div class="tooltip2">
                        <a href="ShowNewsList" >

                            <div class="icon-border">
                                <i class="fa-solid fa-ghost"></i> 
                            </div>
                        </a>
                        <span class="tooltiptext2">Continue as guest...</span>
                    </div>

                </div>
                <div class="form-container">
                    <form action="Registration" method="post" autocomplete="off">
                        <input  type="text" name="username" placeholder="Username" required>
                        <input type="text" name="email" placeholder="Email" required> 
                        <input type="password" name="password" placeholder="Password" required>
                        <p id="message">${(poruka != null) ? poruka : ""}</p>

                        <button type="submit" name="submit">SIGN UP</button>
                    </form>
                </div>


            </div>

        </div>
    </body>
</html>
