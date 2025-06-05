<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Opciones Voluntario</title>
</head>
<body>

<h2>Elija una opción</h2>

<s:form action="irAEliminarVoluntario" namespace="/voluntario">
    <s:submit value="Eliminar voluntario"/>
</s:form>

<s:form action="crearValoracion" namespace="/voluntario">
    <s:submit value="Crear valoración"/>
</s:form>

<s:form action="editarValoracion" namespace="/voluntario">
    <s:submit value="Editar valoración"/>
</s:form>


</body>
</html>
