<%@ page import="pe.edu.autonoma.laboral.entity.Actividad" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: USUARIO
  Date: 13/06/2020
  Time: 08:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    List<Actividad> actividades = new ArrayList<>();
%>
<%
    actividades = (List<Actividad>) request.getAttribute("actividades");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Mi primera Web App</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/estilo.css">
</head>
<body>

<header>
    <nav id="header-nav">
        <div id="header-logo">
            Logo
        </div>
        <ul id="nav-menu">
            <li><a href="showtrabajadores">Listar Trabajadores</a></li>
            <li><a href="#">Trabajador</a></li>
            <li><a href="#">Empresa</a></li>
            <li><a href="signout">Cerrar Sesión</a></li>
        </ul>
    </nav>
</header>
<main>
    <section id="secction-main">
        <div>.</div>
        <div>
            <h2>Nuevo Trabajador</h2>
            <form action="savetrabajador" method="post">
                <fieldset>
                    <legend>Datos Personales:</legend>
                    <label for="apellido-nombre">Apellido Nombre: </label>
                    <input type="text" name="apellido-nombre" id="apellido-nombre"><br>
                    <label for="dni">Documento Identidad: </label>
                    <input type="text" name="dni" id="dni"><br>
                    <label for="fecha-nacimiento">Fecha de nacimiento: </label>
                    <input type="text" name="fecha-nacimiento" id="fecha-nacimiento"><br>
                    <label for="direccion-personal">Direción: </label>
                    <input type="text" name="direccion-personal" id="direccion-personal">
                </fieldset>
                <fieldset>
                    <legend>Datos laborales:</legend>
                    <label for="nombre-empresa">Nombre de la empresa: </label>
                    <input type="text" name="nombre-empresa" id="nombre-empresa"><br>
                    <label for="actividad">Actividad: </label>
                    <select name="actividad" id="actividad">
                        <%
                            for (Actividad actividad : actividades) {
                        %>
                        <option value="<%=actividad.getId()%>"> <%=actividad.getDescripcion()%> </option>
                       <%
                            }
                        %>
                    </select><br>
                    <label for="direccion-laboral">Direción: </label>
                    <input type="text" name="direccion-laboral" id="direccion-laboral">
                </fieldset>
                <button type="submit">Enviar</button>
            </form>
        </div>
        <div>
            .
        </div>
    </section>
</main>
<footer>

</footer>

</body>
</html>

