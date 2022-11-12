<%-- 
    Document   : showComments
    Created on : Oct 31, 2022, 7:49:56 PM
    Author     : Blandus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <h1>Comments</h1>
        <input type="button" value="Back" onclick="javascript:history.go(-1)"></h1>
    <table style="width:100%; border: 1px solid black;">
        <tr style="border: 1px solid black;">
            <th style="border: 1px solid black;">CommentID</th>
            <th style="border: 1px solid black;">Comment</th>
            <th style="border: 1px solid black;">UserID</th>
            <th style="border: 1px solid black;">User</th>
            <td style="border: 1px solid black;">Delete safely</th>
            <td style="border: 1px solid black;">Delete permanently</th>
        </tr>
        <c:forEach items="${comments}" var="com">
            <tr style="border: 1px solid black;">
                <td style="border: 1px solid black;"> <h4>${com.commentID} </h4></td>
                <td style="border: 1px solid black;">${com.commentText}</td>
                <td style="border: 1px solid black;">${com.userID}</td>
                <td style="border: 1px solid black;">${com.username}</td>
                <td style="border: 1px solid black;"><a href="DeleteComment?action=${com.commentID}">Delete</a></td>
                <td style="border: 1px solid black;"><a href="DeleteCommentPermanently?action=${com.commentID}">Delete permanently</a></td>
                        </tr>

            </c:forEach>




    </table>
    </body>
</html>
