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


</body>
</html>
