<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jsp/control.jsp" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenido</title>
</head>

<body>

    <!-- Código HTML -->

    <h1>Bienvenido <% out.println(session.getAttribute("name")); %></h1>


    <%
        // código JAVA
        System.out.println("Esto se imprime en consola!");
        out.println("<h4>Esto se renderiza!!</h4>");
    %>

    <p>
        Contenido de la página!!!
        buen año!!
    </p>

    

    <!-- 
        
        -- Api Servlet 
        -- Patron DAO

    -->
    
    <form action="http://localhost:8080/logout.jsp">
        Cerrar <input type="submit" value="Cerrar"/>
    </form>

</body>

</html>