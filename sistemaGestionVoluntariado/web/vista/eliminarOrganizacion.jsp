<%-- 
    Document   : borrarOrganizacion
    Created on : 05-jun-2025, 11:38:29
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/estilos.css">
        <title>Elimina tu cuenta</title>
    </head>
    <body>
        <h1>¿Quieres eliminar tu cuenta?</h1>
        <s:form action="eliminarOrganizacion" namespace="/organizacion">
            <s:password name="password" label="Contraseña"></s:password>
            <s:submit value="Eliminar" />
        </s:form>
        
        <s:if test="mensaje != null">
            <div style="color:red;">
                <s:property value="mensaje" />
            </div>
        </s:if>
    </body>
</html>
