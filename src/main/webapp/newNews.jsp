<%-- 
    Document   : newNews
    Created on : Oct 31, 2022, 6:29:55 PM
    Author     : Blandus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add News | Lorem ipsum</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="AddNews" method="post">
        <table border="1">

            <tr>
                <td>Title:</td>
                <td>
                    <input type="text" name="title" required/>
                </td>
                <td>Type:</td>
                <td>
                    <select name="typeID">
                        <option value="1">Sport</option>
                        <option value="2">Politics</option>
                        <option value="3">Business</option>
                        <option value="4">Literature</option>
                        <option value="5">Economics</option>
                        <option value="6">History</option>
                        <option value="7">Fashion</option>
                        <option value="8">Movies and TV shows</option>
                        <option value="9">Celebrities</option>
                    </select></td>
            </tr>
        </table>
        <table border="1">
          
                <tr>
                    <td>Content:</td>
                    <td>
                        <textarea name="content" cols="70" rows="10">
                            
                        </textarea>
                    </td>
                </tr>
          
        </table>
        <input type="submit" value="Submit" name="submit"/>
</form>
    </body>
</html>
