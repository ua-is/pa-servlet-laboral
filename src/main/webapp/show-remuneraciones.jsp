<%@ page import="pe.edu.autonoma.laboral.entity.Trabajador" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pe.edu.autonoma.laboral.entity.Remuneracion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    List<Remuneracion> remuneraciones = new ArrayList<>();
%>
<%
    remuneraciones = (List<Remuneracion>) request.getAttribute("remuneraciones");
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
            <h2>Lista de Remuneraciones</h2>
            <table id="table-trabajadores" class="table-collapse">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Apellidos y Nombres</th>
                    <th>Año</th>
                    <th>Mes</th>
                    <th>Monto Bruta</th>
                    <th>Descuentos</th>
                    <th>Monto Líquido</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (Remuneracion remuneracion: remuneraciones) {
                %>
                    <tr>
                        <td><%=remuneracion.getId()%></td>
                        <td><%=remuneracion.getTrabajador().getApellidoNombre()%></td>
                        <td><%=remuneracion.getAno()%></td>
                        <td><%=remuneracion.getMes()%></td>
                        <td><%=remuneracion.getMontoBruta()%></td>
                        <td><%=remuneracion.getDescuento()%></td>
                        <td><%=remuneracion.getMontoLiquido()%></td>
                        <td>
                            <a href="editremuneracion?id=<%=remuneracion.getId()%>" class="a-button a-button-edit">Editar</a>
                        </td>
                        <td>
                            <a href="delremuneracion?id=<%=remuneracion.getId()%>" class="a-button a-button-del">Borrar</a>
                        </td>
                    </tr>
                <%
                    }
                %>
                </tbody>
                <tfoot></tfoot>
            </table>

            <a href="newremuneracion" class="a-button a-button-new">Nueva Remuneración</a>
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
