<%-- 
    Document   : index
    Created on : 04-jun-2025, 10:54:20
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h1>Ayuda al mundo!</h1>
        <h2>Registrate como voluntario o como organización y mejora el mundo con tan solo un click!</h2>
        <s:form action="/organizacion/accederRegistroOrg">
            <s:submit value="Registrarse como organización"></s:submit>
        </s:form>
        <br>
        <s:form action="/organizacion/accederLoginOrg">
            <s:submit value="Logearse como organización"></s:submit>
        </s:form>
        <s:form action="/voluntario/accederRegistroVol">
            <s:submit value="Registrarse como voluntario"></s:submit>
        </s:form>
        <br>
        <s:form action="/voluntario/accederLoginVol">
            <s:submit value="Logearse como Voluntario"></s:submit>
        </s:form>
</html>
