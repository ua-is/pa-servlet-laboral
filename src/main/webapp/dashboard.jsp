<%!
    String username;
    HttpSession session;
%>
<%
    // Obtener la sesión creada
    session = request.getSession();
    // obtener el valor de la variable guardada en la sesión, previo cast
    username = (String) session.getAttribute("username");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <li><a href="signout">Cerrar Sesión <%=username%></a></li>
        </ul>
    </nav>
</header>
<main>
    <section id="secction-main">
        <div>.</div>
        <div>

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
