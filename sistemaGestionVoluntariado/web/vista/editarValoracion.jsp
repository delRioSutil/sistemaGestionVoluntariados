<%-- 
    Document   : editarValoracion
    Created on : 06-jun-2025, 2:19:08
    Author     : Antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/estilos.css">
        <title>Editar Valoración</title>
    </head>
    <body>
        <h2>Editar Valoración</h2>

        <s:form action="editarValoracion" namespace="/valoracion" method="post">
    <s:hidden name="eventoid" value="%{eventoid}" />
    <s:hidden name="voluntarioid" value="%{voluntarioid}" />
    <s:textfield name="puntuacion" label="Puntuación" value="%{valoracion.puntuacion}" />
    <s:textarea name="comentario" label="Comentario" value="%{valoracion.comentario}" />
    <s:submit value="Guardar cambios" />
</s:form>
        <s:form action="mostrarOpcionesVoluntario" namespace="/voluntario">
        <s:submit value="Volver a opciones" />
    </s:form>
    </body>
</html>
