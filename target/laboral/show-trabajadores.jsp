<%@ page import="pe.edu.autonoma.laboral.entity.Trabajador" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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
            <h2>Lista de Trabajadores</h2>
            <table id="table-trabajadores" class="table-collapse">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Apellidos y NOmbres</th>
                    <th>Dni</th>
                    <th>Fecha Nac.</th>
                    <th>Dir. Personal</th>
                    <th>Empresa</th>
                    <th>Actividad</th>
                    <th>Dir. Laboral</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (Trabajador trabajador: trabajadores) {
                %>
                    <tr>
                        <td><%=trabajador.getId()%></td>
                        <td><%=trabajador.getApellidoNombre()%></td>
                        <td><%=trabajador.getDni()%></td>
                        <td><%=trabajador.getFechaNacimiento()%></td>
                        <td><%=trabajador.getDireccionPersonal()%></td>
                        <td><%=trabajador.getNombreEmpresa()%></td>
                        <td><%=trabajador.getActividad().getDescripcion()%></td>
                        <td><%=trabajador.getDireccionLaboral()%></td>
                        <td>
                            <a href="edittrabajador?id=<%=trabajador.getId()%>" class="a-button a-button-edit">Editar</a>
                        </td>
                        <td>
                            <a href="deltrabajador?id=<%=trabajador.getId()%>" class="a-button a-button-del">Borrar</a>
                        </td>
                    </tr>
                <%
                    }
                %>
                </tbody>
                <tfoot></tfoot>
            </table>

            <a href="newtrabajador" class="a-button a-button-new">Nuevo Trabajador</a>
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
