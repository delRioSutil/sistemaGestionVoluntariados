<%-- 
    Document   : registrarOrganizacion
    Created on : 03-jun-2025, 15:43:39
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar organizacion</title>
    </head>
    <body>
        <h1>Introduce los datos de la organización</h1>
        <s:form action="/organizacion/registrarOrg">
            <s:textfield name="username" label="Nombre de usuario"></s:textfield>
            <s:textfield name="email" type="email" label="email"></s:textfield>
            <s:password name="password" label="contraseña"></s:password>
            <s:textfield name="nif" label="NIF"></s:textfield>
            <s:submit value="registrar"></s:submit>
        </s:form>
    </body>
</html>
