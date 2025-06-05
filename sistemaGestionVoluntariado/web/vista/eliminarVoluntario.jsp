<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
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
