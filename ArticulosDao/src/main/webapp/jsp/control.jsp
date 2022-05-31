<%
    boolean login=false;
    String name="";
    try{
        login=(boolean)session.getAttribute("login");
        name=(String)session.getAttribute("name");
        if(login==false) response.sendRedirect("/logout.html");
    }catch(Exception e){
        response.sendRedirect("/logout.html");
    }
%>