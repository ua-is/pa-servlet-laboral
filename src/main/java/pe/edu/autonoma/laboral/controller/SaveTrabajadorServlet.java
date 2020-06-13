package pe.edu.autonoma.laboral.controller;

import pe.edu.autonoma.laboral.dao.TrabajadorDao;
import pe.edu.autonoma.laboral.entity.Trabajador;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SaveTrabajadorServlet", urlPatterns = "/savetrabajador")
public class SaveTrabajadorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String apellidoNombre = request.getParameter("apellido-nombre");
        String dni = request.getParameter("dni");
        String fechaNacimiento = request.getParameter("fecha-nacimiento");
        String direccionPersonal = request.getParameter("direccion-personal");
        String nombreEmpresa = request.getParameter("nombre-empresa");
        String actividad = request.getParameter("actividad");
        String direccionLaboral = request.getParameter("direccion-laboral");

        Trabajador trabajador = new Trabajador(apellidoNombre, dni, fechaNacimiento, direccionPersonal,
                nombreEmpresa, actividad, direccionLaboral);

        try {
            TrabajadorDao dao = new TrabajadorDao();
            dao.insert(trabajador);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        request.setAttribute("trabajador", trabajador);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show-trabajador.jsp");
        requestDispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p>TODO OK</p>");
    }
}
