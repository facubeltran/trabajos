<%-- 
    Document   : logout
    Created on : 6 abr. 2022, 17:46:32
    Author     : aula1-docente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            session.setAttribute("login", false);
            session.invalidate();
            response.sendRedirect("/logout.html");
        %>
    </body>
</html>
