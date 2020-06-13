<%--
  Created by IntelliJ IDEA.
  User: USUARIO
  Date: 13/06/2020
  Time: 08:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Laboral E2</h2>
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
            <input type="text" name="actividad" id="actividad"><br>
            <label for="direccion-laboral">Direción: </label>
            <input type="text" name="direccion-laboral" id="direccion-laboral">
        </fieldset>
        <button type="submit">Enviar</button>
    </form>
</body>
</html>
