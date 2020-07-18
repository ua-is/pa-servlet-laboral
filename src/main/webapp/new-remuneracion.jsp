<%@ page import="pe.edu.autonoma.laboral.entity.Actividad" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pe.edu.autonoma.laboral.entity.Trabajador" %><%--
  Created by IntelliJ IDEA.
  User: USUARIO
  Date: 13/06/2020
  Time: 08:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    List<Trabajador> trabajadores = new ArrayList<>();
%>
<%
    trabajadores = (List<Trabajador>) request.getAttribute("trabajadores");
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
            <li><a href="showtrabajadores">Trabajadores</a></li>
            <li><a href="showremuneraciones">Remuneraciones</a></li>
            <li><a href="#">Empresa</a></li>
            <li><a href="signout">Cerrar Sesión</a></li>
        </ul>
    </nav>
</header>
<main>
    <section id="secction-main">
        <div>.</div>
        <div>
            <h2>Nuevo Remuneración</h2>
            <form action="saveremuneracion" method="post">
                <fieldset>
                    <legend>Datos del Trabajador:</legend>
                    <label for="trabajador">Trabajador: </label>
                    <select name="trabajador" id="trabajador">
                        <%
                            for (Trabajador trabajador : trabajadores) {
                        %>
                        <option value="<%=trabajador.getId()%>"> <%=trabajador.getApellidoNombre()%> </option>
                        <%
                            }
                        %>
                    </select>
                </fieldset>
                <fieldset>
                    <legend>Datos Remunerativos:</legend>
                    <label for="ano">Año: </label>
                    <input type="number" name="ano" id="ano"><br>
                    <label for="mes">Mes: </label>
                    <input type="number" name="mes" id="mes"><br>

                    <label for="monto-bruta">Monto Bruta: </label>
                    <input type="text" name="monto-bruta" id="monto-bruta"><br>
                    <label for="descuento">Descuento: </label>
                    <input type="text" name="descuento" id="descuento"><br>
                    <label for="monto-liquido">Monto Liquido: </label>
                    <input type="text" name="monto-liquido" id="monto-liquido">

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

