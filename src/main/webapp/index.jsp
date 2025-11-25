<%--
    Autor: Erick Sanguña
    Descripción: Página principal del ejemplo MVC.
    Muestra enlaces que envían distintas acciones al servlet controlador
    y un mensaje opcional enviado desde el Servlet.
--%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ejemplo MVC</title>
</head>

<body>
<h1>Ejemplo MVC</h1>
<br/>

<%-- Muestra un mensaje enviado desde el Servlet mediante request.setAttribute("mensaje") --%>
<div style="color:red">${mensaje}</div>
<br/>

<%-- Enlace al Servlet SIN parámetros (acción no especificada) --%>
<a href="${pageContext.request.contextPath}/ServletControlador">
    Link al servlet controlador SIN parámetros
</a>
<br/><br/>

<%-- Enlace al Servlet para ejecutar la acción "agregarVariables" --%>
<a href="${pageContext.request.contextPath}/ServletControlador?accion=agregarVariables">
    Link al servlet controlador para agregar las variables
</a>
<br/><br/>

<%-- Enlace al Servlet para ejecutar la acción "listarVariables" --%>
<a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">
    Link al servlet controlador para listar variables
</a>

</body>
</html>
