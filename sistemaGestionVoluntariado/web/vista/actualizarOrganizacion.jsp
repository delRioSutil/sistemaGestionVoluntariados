<%-- 
    Document   : actualizarOrganizacion
    Created on : 05-jun-2025, 16:16:51
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualiza organización</title>
    </head>
    <body>
        <h1>Actualiza tus datos</h1>
        <s:form action="actualizarOrganizacion" namespace="/organizacion">
            <s:textfield name="email" type="email" label="email"></s:textfield>
            <s:textfield name="nombre" label="Nombre de usuario"></s:textfield>
            <s:submit value="Actualizar" />
        </s:form>
    </body>
</html>
