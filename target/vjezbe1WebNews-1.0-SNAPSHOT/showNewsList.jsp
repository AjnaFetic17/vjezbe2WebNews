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
        <title>News List | Lorem ipsum</title>
    </head>
    <body>
        <h1 style="align-self: center;">Lorem ipsum news</h1>
          <input type="button" value="Back" onclick="javascript:history.go(-1)">
        <table style="width:100%; border: 1px solid black;">
            <tr style="border: 1px solid black;">
                <th style="border: 1px solid black;">NewsID</th>
                <th style="border: 1px solid black;">NewsTitle</th>
                <th style="border: 1px solid black;">Content</th>
                <th style="border: 1px solid black;">Publication Date</th>
                <th style="border: 1px solid black;">Type </th>
                <th style="border: 1px solid black;">Learn more..</th>
                <th style="border: 1px solid black;">Show comments..</th>

            </tr>

            <c:forEach items="${news}" var="n">
                <tr style="border: 1px solid black;">
                    <td style="border: 1px solid black;"> <h4>${n.newsID} </h4></td>
                    <td style="border: 1px solid black;">${n.newsTitle}</td>
                    <td style="border: 1px solid black;">${fn:substring(n.content, 0, 30)}</td>
                    <td style="border: 1px solid black;">${n.publicationDate}</td>
                    <td style="border: 1px solid black;">${n.newsType}</td>

                    <td style="border: 1px solid black;"> <a href="ShowNews?action=${n.newsID}">Learn more</a></td>
                    <td style="border: 1px solid black;"> <a href="ShowCommentsGuest?action=${n.newsID}">Show comments</a></td>        

                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>