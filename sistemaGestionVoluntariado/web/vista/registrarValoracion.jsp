<%-- 
    Document   : registrarValoracion
    Created on : 05-jun-2025, 17:57:49
    Author     : Antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../css/estilos.css">
    <title>Registrar Valoración</title>
</head>
<body>
    <h2>Formulario de Valoración</h2>

    <s:form action="guardarValoracion" namespace="/valoracion">
        <s:hidden name="eventoIdSeleccionado" />
        <s:textfield name="puntuacion" label="Puntuación (1.0 - 5.0)" />
        <s:textarea name="comentario" label="Comentario" />
        <s:submit value="Enviar Valoración" />
    </s:form>
    <s:form action="mostrarOpcionesVoluntario" namespace="/voluntario">
        <s:submit value="Volver a opciones" />
    </s:form>
</body>
</html>