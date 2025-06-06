<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/estilos.css">
        <title>Eliminar cuenta</title>
    </head>
    <body>

        <h2>¿Está seguro de que desea eliminar su cuenta?</h2>

        <s:form action="eliminarVoluntario" namespace="/voluntario">
            <s:hidden name="voluntarioId" value="%{#session.voluntarioId}" />
            <s:submit value="Eliminar" />
        </s:form>



    </body>
</html>
