<%--
    Autor: Erick Sanguña
    Descripción: Página JSP que muestra el valor de variables
    almacenadas en los alcances: request, session y application.
    Utiliza Expression Language (EL) para acceder a los JavaBeans.
--%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Alcance de Variables</title>
</head>

<body>
<h1>Alcance de Variables</h1>
<br/>

<%-- ===================== --
     Variables en el alcance REQUEST
     Se destruyen al finalizar la petición
     rectanguloRequest fue agregado en el Servlet
   -- ===================== --%>
Variable request:<br/>
Base: ${rectanguloRequest.base}<br/>
Altura: ${rectanguloRequest.altura}<br/>
Area: ${rectanguloRequest.area}<br/><br/>

<%-- ===================== --
     Variables en el alcance SESSION
     Se mantienen mientras la sesión esté activa
     rectanguloSession fue agregado en el Servlet
   -- ===================== --%>
Variable session:<br/>
Base: ${rectanguloSession.base}<br/>
Altura: ${rectanguloSession.altura}<br/>
Area: ${rectanguloSession.area}<br/><br/>

<%-- ===================== --
     Variables en el alcance APPLICATION
     Son globales para toda la aplicación web
     rectanguloApplication fue agregado en el Servlet
   -- ===================== --%>
Variable application:<br/>
Base: ${rectanguloApplication.base}<br/>
Altura: ${rectanguloApplication.altura}<br/>
Area: ${rectanguloApplication.area}<br/><br/>

<%-- Enlace para regresar a la página principal --%>
<a href="${pageContext.request.contextPath}/index.jsp">Regresar al inicio</a>

</body>
</html>
