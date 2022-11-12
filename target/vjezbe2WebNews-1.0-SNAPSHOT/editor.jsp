<%-- 
    Document   : editor
    Created on : Dec 6, 2020, 2:18:03 AM
    Author     : koriisnik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${user.username} | Lorem ipsum</title>
    </head>
    <body>
        <h1>Hello Editor ${user.username}!</h1>
        <p>Vaš userID je: ${user.userID}</p>
        <form action="EditorOption" method="post">
            <label>Na koju stranicu želite otići:</label>
            <select name="ForwardEditor">
                <option value="1" >Uređivanje novosti</option>
                <option value="2" >Brisanje novosti</option>
                <option value="3" >Dodavanje novosti</option>
                <option value="4" >Brisanje komentara</option>
                <option value="5" >Nastavi kao obican korisnik</option>
                <option value="6" >Povratak slucajno obrisanih novosti i komentara(safely delete)</option>
            </select>
            <input type="submit" value="Potvrdi opciju" >
        </form>
    </body>
</html>
