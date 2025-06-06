<%-- 
    Document   : listaValoraciones
    Created on : 06-jun-2025, 1:52:05
    Author     : Antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../css/estilos.css">
    <title>Mis Valoraciones</title>
</head>
<body>
<h2>Mis valoraciones</h2>

<table border="1">
    <tr>
        <th>Evento ID</th>
        <th>Puntuación</th>
        <th>Comentario</th>
        <th>Acciones</th>
    </tr>
    <s:iterator value="valoraciones" var="v">
        <tr>
            <td><s:property value="valoracionPK.eventoid"/></td>
            <td><s:property value="puntuacion"/></td>
            <td><s:property value="comentario"/></td>
            <td>
            Evento ID (debug): <s:property value="valoracionPK.eventoid"/><br/>
            Voluntario ID (debug): <s:property value="valoracionPK.voluntarioid"/><br/>

                <s:form action="cargarValoracionParaEditar" namespace="/valoracion">
                    <s:hidden name="eventoid" value="%{#v.valoracionPK.eventoid}"/>
                    <s:hidden name="voluntarioid" value="%{#v.valoracionPK.voluntarioid}"/>
                    <s:submit value="Editar"/>
                </s:form>

                <s:form action="eliminarValoracion" namespace="/valoracion">
                    <s:hidden name="eventoid" value="%{#v.valoracionPK.eventoid}"/>
                    <s:hidden name="voluntarioid" value="%{#v.valoracionPK.voluntarioid}"/>
                    <s:submit value="Eliminar"/>
                </s:form>
            </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>