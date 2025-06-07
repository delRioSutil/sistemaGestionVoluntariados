<%-- 
    Document   : newjspcrearTarea
    Created on : 07-jun-2025, 15:21:31
    Author     : juanr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Crear Tarea</title>
</head>
<body>
    <h1>Crear nueva tarea para el evento</h1>

    <s:form action="crearTarea" namespace="/tarea">
        <s:hidden name="eventoId" value="%{eventoId}" />

        <s:textfield name="nombre" label="Nombre de la tarea" />
        <s:textarea name="descripcion" label="Descripción" />
        <s:textfield name="voluntarioId" label="ID del voluntario (opcional)" />

        <s:submit value="Guardar tarea" />
    </s:form>
</body>
</html>