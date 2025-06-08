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
    <title>Crear Tarea</title>
</head>
<body>
    <h1>Crear nueva tarea para el evento</h1>

    <s:form action="crearTarea" namespace="/tarea">
        <s:hidden name="eventoId" value="%{eventoId}" />

        <s:textfield name="nombre" label="Nombre de la tarea" />
        <s:textarea name="descripcion" label="Descripción" />

        <s:label value="Selecciona un voluntario (opcional):" />
        <s:select 
            name="voluntarioId"
            list="inscripcionesAprobadas"
            listKey="voluntarioid.voluntarioId"
            listValue="voluntarioid.nombre"
            headerKey=""
            headerValue="-- No asignar voluntario --"
        />

        <s:submit value="Guardar tarea" />
    </s:form>
</body>
</html>