<%-- 
    Document   : crearValoracion
    Created on : 05-jun-2025, 17:57:08
    Author     : Antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../css/estilos.css">
    <title>Crear Valoración</title>
</head>
<body>
    <h2>Eventos Asistidos</h2>

    <s:iterator value="eventosAsistidos" var="evento">
        <div>
            <b><s:property value="#evento.nombre" /></b><br/>
            <s:form action="registrarValoracion" namespace="/valoracion">
                <s:hidden name="eventoIdSeleccionado" value="%{#evento.eventoid}" />
                <s:submit value="Valorar" />
            </s:form>
        </div>
        <hr/>
    </s:iterator>

        <s:form action="mostrarOpcionesVoluntario" namespace="/voluntario">
        <s:submit value="Volver a opciones" />
    </s:form>
</body>
</html>