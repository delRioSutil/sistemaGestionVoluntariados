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
        <title>Login organización</title>
    </head>
    <body>
        <h1>Introduce tus datos</h1>
        <s:form action="/organizacion/registrarOrg">
            <s:textfield name="username" label="Nombre de usuario"></s:textfield>
            <s:password name="password" label="contraseña"></s:password>
        </s:form>
    </body>
</html>
