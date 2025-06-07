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
    <title>Inscripción Exitosa</title>
    <link rel="stylesheet" href="../css/estilos.css">
</head>
<body>

    <h2>Inscripción realizada con éxito</h2>

    <s:if test="mensaje != null">
        <p><strong><s:property value="mensaje" /></strong></p>

        <s:if test="mensaje == 'Ya estás inscrito en este evento.'">
            <s:form action="eliminarInscripcion" namespace="/inscripcion">
                <s:hidden name="eventoId" value="%{eventoId}" />
                <s:submit value="Eliminar inscripción" />
            </s:form>
        </s:if>
    </s:if>

    <s:form action="mostrarOpcionesVoluntario" namespace="/voluntario">
        <s:submit value="Volver a opciones" />
    </s:form>

</body>
</html>