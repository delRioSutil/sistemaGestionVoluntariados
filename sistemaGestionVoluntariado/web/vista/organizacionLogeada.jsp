<%-- 
    Document   : organizaciónLogeada
    Created on : 03-jun-2025, 18:00:16
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logged Org</title>
    </head>
    <body>
        <h1>Bienvenido!</h1>
        <p><strong>NIF:</strong> <s:property value="#session.organizacion.organizacionId"/></p>
        <p><strong>Nombre:</strong> <s:property value="#session.organizacion.nombre"/></p>
        <p><strong>Correo:</strong> <s:property value="#session.organizacion.correo"/></p>
        
        <s:form action="irAEliminarOrganizacion" namespace="/organizacion">
            <s:submit value="Eliminar tu cuenta"/>
        </s:form>
        
        <s:form action="irAActualizarOrganizacion" namespace="/organizacion">
            <s:submit value="Actualizar datos de tu cuenta"/>
        </s:form>

        <s:if test="#session.eventos != null && #session.eventos.size() > 0">

            <table border="1">
                <tr>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>FechaInicio</th>
                    <th>FechaFin</th>

                </tr>
                <s:iterator value="#session.eventos" var="evento">
                    <tr>
                        <td><s:property value="#evento.nombre" /></td>
                        <td><s:property value="#evento.descripcion" /></td>
                        <td><s:property value="#evento.fechainicio" /></td>
                        <td><s:property value="#evento.fechafin" /></td>
                        <td>
                            <s:form action="verEvento" method="post">
                                <s:hidden name="eventoId" value="%{#evento.eventoid}" />
                                <s:submit value="Más detalles" />
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>
            </table>

        </s:if>

        <s:else>
            <p>No hay eventos registrados para esta organización.</p>
        </s:else>
        <s:form action="crearEventoAction">
            <s:submit value="Crear Evento"></s:submit>
        </s:form>
    </body>
</html>
