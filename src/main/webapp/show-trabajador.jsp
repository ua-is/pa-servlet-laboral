<%@ page import="pe.edu.autonoma.laboral.entity.Trabajador" %><%--
  Created by IntelliJ IDEA.
  User: USUARIO
  Date: 13/06/2020
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    Trabajador trabajador;
%>
<%
    trabajador = (Trabajador) request.getAttribute("trabajador");
%>
<html>
<head>
    <title>TOdo OK</title>
</head>
<body>
    <h3>Registro exitoso</h3>
    <p>Los datos ingresados a la Base de datos son:</p>
    <p><%=trabajador.getDni()%> <%=trabajador.getApellidoNombre()%>   </p>
</body>
</html>
