<%-- 
    Document   : user
    Created on : Oct 20, 2022, 9:38:01 PM
    Author     : Blandus
--%>

<%-- 
    Document   : EditUser
    Created on : 2020.12.06, 16:53:07
    Author     : XY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User | Lorem ipsum</title>
        <script src="https://kit.fontawesome.com/40015dd949.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="styles.css" />
        <link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'>
        <link rel="stylesheet" href="index.css" />
        <link rel="stylesheet" href="user.css" />
    </head>
    <body>

        <div class="container">
            <div class="right">

                <h1>Welcome to <br>Lorem ipsum news</h1>
                <p>Please fill in form with your information</p>

            </div>
            <div class="left">
                <c:if test="${user.username !=null}"> <h1>Hello User ${user.username} </h1></c:if> 

                <div class="form-container">
                    <p class="go-back">To go back press: <button onclick="javascript:history.go(-1)">Back</button></p>
                    <a href="ShowNewsList">Prikazi novosti</a>
                </div>


            </div>

        </div>
    </body>
</html>