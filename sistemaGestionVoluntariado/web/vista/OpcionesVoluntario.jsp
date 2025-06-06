<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../css/estilos.css">
    <title>Opciones Voluntario</title>
</head>
<body>

    <h2>Elija una opción</h2>

    <s:form action="irAEliminarVoluntario" namespace="/voluntario">
        <s:submit value="Eliminar voluntario"/>
    </s:form>

    <s:form action="crearValoracion" namespace="/valoracion">
        <s:submit value="Crear valoración"/>
    </s:form>

    <s:form action="listarValoraciones" namespace="/valoracion">
        <s:submit value="Editar valoración"/>
    </s:form>

    <h3>Eventos disponibles</h3>

    <s:if test="eventos != null && !eventos.isEmpty()">
        <table border="1">
            <tr>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Fecha Inicio</th>
                <th>Fecha Fin</th>
            </tr>
            <s:iterator value="eventos" var="evento">
                <tr>
                    <td><s:property value="#evento.nombre" /></td>
                    <td><s:property value="#evento.descripcion" /></td>
                    <td><s:property value="#evento.fechainicio" /></td>
                    <td><s:property value="#evento.fechafin" /></td>
                    <td>
                        <s:form action="inscribirseAevento" method="post">
                            <s:hidden name="eventoId" value="%{#evento.eventoid}" />
                            <s:submit value="Inscribirse" />
                        </s:form>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </s:if>

    <s:else>
        <p>No hay eventos disponibles.</p>
    </s:else>


</body>
</html>
