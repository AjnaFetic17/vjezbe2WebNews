<%-- 
    Document   : admin
    Created on : Dec 6, 2020, 2:17:43 AM
    Author     : koriisnik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> ${editor.name} | Lorem ipsum</title>
    </head>
    <body>
        <h1>Hello Admin ${editor.name}!</h1>
        <p>Vaš userID je: ${editor.userID}</p>
        <form action="AdminOption" method="post">
            <label>Na koju stranicu želite otići:</label>
            <select name="ForwardAdmin">
                <option value="1" >Uređivanje korisnika</option>
                <option value="2" >Brisanje korisnika</option>
                <option value="3" >Dodavanje korisnika</option>
                <option value="4" >Nastavi kao obican korisnik</option>
            </select>
            <input type="submit" value="Potvrdi opciju" >
        </form>
        <c:if test="${poruka!=null}"> <h1 style="color: red;">${poruka}</h1></c:if>
    </body>
</html>
