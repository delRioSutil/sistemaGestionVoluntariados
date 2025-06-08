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
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/estilos.css">
       
    </head>
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
    <s:form action="mostrarOpcionesVoluntario" namespace="/voluntario">
        <s:submit value="Volver a opciones" />
    </s:form>
</body>
</html>