<%-- 
    Document   : editarTarea
    Created on : 07-jun-2025, 4:33:06
    Author     : juanr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Tarea</title>
        <link rel="stylesheet" href="../css/estilos.css">
    </head>
    <body>
        <h2>Editar Tarea</h2>

        <s:form action="editarTarea" namespace="/tarea" method="post">
            <s:hidden name="tareaId" value="%{tareaId}" />
            <s:hidden name="eventoId" value="%{eventoId}" />
            <s:hidden name="voluntarioId" value="%{voluntarioId}" />
            
            <s:textfield name="nombre" label="Nombre" value="%{nombre}" />
            <s:textarea name="descripcion" label="Descripción" value="%{descripcion}" />

            <s:submit value="Guardar cambios" />
        </s:form>
    </body>
</html>