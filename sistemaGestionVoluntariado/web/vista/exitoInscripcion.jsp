<%-- 
    Document   : exitoInscripcion
    Created on : 07-jun-2025, 1:05:53
    Author     : juanr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Inscripción</title>
    <link rel="stylesheet" href="../css/estilos.css">
</head>
<body>

    <h2>Resultado de la inscripción</h2>

    <s:if test="mensaje != null">
        <p><strong><s:property value="mensaje" /></strong></p>
    </s:if>

    <s:else>
        <p>Te has inscrito correctamente al evento.</p>
    </s:else>

    <s:form action="mostrarOpcionesVoluntario" namespace="/voluntario">
        <s:submit value="Volver a opciones" />
    </s:form>

</body>
</html>