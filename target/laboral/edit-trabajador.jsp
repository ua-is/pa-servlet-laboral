<%@ page import="pe.edu.autonoma.laboral.entity.Trabajador" %><%--
  Created by IntelliJ IDEA.
  User: USUARIO
  Date: 13/06/2020
  Time: 08:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    Trabajador trabajador;
%>
<%
    trabajador = (Trabajador) request.getAttribute("trabajador");
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
            <li><a href="#">Preguntas</a></li>
        </ul>
    </nav>
</header>
<main>
    <section id="secction-main">
        <div>.</div>
        <div>
            <h2>Edit Trabajador</h2>
            <form action="saveedittrabajador" method="post">
                <fieldset>
                    <legend>Datos Personales:</legend>
                    <label for="id2">Id: </label>
                    <input type="hidden" name="id" id="id"
                           value="<%=trabajador.getId()%>">
                    <input type="text" name="id2" id="id2"
                           value="<%=trabajador.getId()%>" disabled><br>
                    <label for="apellido-nombre">Apellido Nombre: </label>
                    <input type="text" name="apellido-nombre" id="apellido-nombre"
                           value="<%=trabajador.getApellidoNombre()%>"><br>
                    <label for="dni">Documento Identidad: </label>
                    <input type="text" name="dni" id="dni"
                           value="<%=trabajador.getDni()%>"><br>
                    <label for="fecha-nacimiento">Fecha de nacimiento: </label>
                    <input type="text" name="fecha-nacimiento" id="fecha-nacimiento"
                           value="<%=trabajador.getFechaNacimiento()%>" ><br>
                    <label for="direccion-personal">Direción: </label>
                    <input type="text" name="direccion-personal" id="direccion-personal"
                           value="<%=trabajador.getDireccionPersonal()%>">
                </fieldset>
                <fieldset>
                    <legend>Datos laborales:</legend>
                    <label for="nombre-empresa">Nombre de la empresa: </label>
                    <input type="text" name="nombre-empresa" id="nombre-empresa"
                           value="<%=trabajador.getNombreEmpresa()%>"><br>
                    <label for="actividad">Actividad: </label>
                    <input type="text" name="actividad" id="actividad"
                           value="<%=trabajador.getActividad()%>"><br>
                    <label for="direccion-laboral">Direción: </label>
                    <input type="text" name="direccion-laboral" id="direccion-laboral"
                           value="<%=trabajador.getDireccionLaboral()%>">
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

