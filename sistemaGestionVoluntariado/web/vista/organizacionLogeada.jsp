<%-- 
    Document   : organizaciónLogeada
    Created on : 03-jun-2025, 18:00:16
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logged Org</title>
    </head>
    <body>
        <h1>Logeado con exito!</h1>
        
        <s:form action="irAEliminarOrganizacion" namespace="/organizacion">
            <s:submit value="Eliminar tu cuenta"/>
        </s:form>
    </body>
</html>
