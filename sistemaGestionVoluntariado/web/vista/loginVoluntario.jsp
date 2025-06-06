<%-- 
    Document   : loginOrganizacion
    Created on : 03-jun-2025, 17:40:57
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/estilos.css">
        <title>Login voluntario</title>
    </head>
    <body>
        <h1>Introduce tus datos</h1>
        
       <s:form action="loginVoluntario" namespace="/voluntario">

            <s:textfield name="id" label="Id del usuario"></s:textfield>
            <s:password name="password" label="contraseña"></s:password>
            <s:submit value="Acceder"></s:submit>
        </s:form>
    </body>
</html>
