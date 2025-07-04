<%-- 
    Document   : verDetallesEvento
    Created on : 07-jun-2025, 4:17:02
    Author     : juanr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Detalles del Evento</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/estilos.css">
    </head>
    <body>

        <h1>Detalles del Evento</h1>

        <s:if test="tareasDelEvento != null && !tareasDelEvento.isEmpty()">
            <table border="1">
                <thead>
                    <tr>
                        <th>Nombre de la tarea</th>
                        <th>Descripción</th>
                        <th>Voluntario asignado</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="tareasDelEvento" var="tarea">
                        <tr>
                            <td><s:property value="#tarea.nombre" /></td>
                            <td><s:property value="#tarea.descripcion" /></td>
                            <td>
                                <s:if test="#tarea.voluntarioid != null">
                                    <s:property value="#tarea.voluntarioid.nombre" />
                                </s:if>
                                <s:else>
                                    No asignado
                                </s:else>
                            </td>
                            <td>
                                <s:form action="irAEditarTarea" namespace="/tarea">
                                    <s:hidden name="tareaId" value="%{#tarea.tareaId}" />
                                    <s:hidden name="eventoId" value="%{#tarea.eventoid.eventoid}" />
                                    <s:hidden name="voluntarioId" value="%{#tarea.voluntarioid.voluntarioId}" />
                                    <s:submit value="Editar" />
                                </s:form>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </s:if>

        <s:else>
            <p>No hay tareas asignadas a este evento.</p>
        </s:else>

        <br>
        
         <h2>Inscripciones Pendientes de Aprobación</h2>
        <s:if test="inscripcionesNoAprobadas != null && !inscripcionesNoAprobadas.isEmpty()">
            <table border="1">
                <thead>
                    <tr>
                        <th>ID Inscripción</th>
                        <th>Voluntario</th>
                        <th>Fecha de inscripción</th>
                        <th>Asistencia</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="inscripcionesNoAprobadas" var="ins">
                        <tr>
                            <td><s:property value="#ins.inscripcionId" /></td>
                            <td>
                                <s:if test="#ins.voluntarioid != null">
                                    <s:property value="#ins.voluntarioid.nombre" />
                                </s:if>
                                <s:else>
                                    Desconocido
                                </s:else>
                            </td>
                            <td><s:property value="#ins.fechainscripcion" /></td>
                            <td>
                                <s:if test="#ins.asistencia">
                                    Sí
                                </s:if>
                                <s:else>
                                    No
                                </s:else>
                            </td>
                            <td>
                                <s:form action="aprobarInscripcion" namespace="/inscripcion">
                                    <s:hidden name="inscripcionId" value="%{#ins.inscripcionId}" />
                                    <s:hidden name="eventoId" value="%{#ins.eventoid.eventoid}" />
                                    <s:submit value="Aprobar" />
                                </s:form>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </s:if>
        <s:else>
            <p>No hay inscripciones pendientes.</p>
        </s:else>

        
        
        
        
        
        
        <br>
        
        

        <s:form action="irACrearTarea" namespace="/tarea">
            <s:hidden name="eventoId" value="%{eventoId}" />
            <s:submit value="Crear nueva tarea" />
        </s:form>
        <s:form action="volverAOrganizacion" namespace="/evento">
            <s:submit value="Volver al panel de organización" />
        </s:form>


    </body>
</html>
