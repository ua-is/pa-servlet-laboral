package pe.edu.autonoma.laboral.controller;

import pe.edu.autonoma.laboral.dao.ActividadDao;
import pe.edu.autonoma.laboral.dao.RemuneracionDao;
import pe.edu.autonoma.laboral.dao.TrabajadorDao;
import pe.edu.autonoma.laboral.entity.Actividad;
import pe.edu.autonoma.laboral.entity.Remuneracion;
import pe.edu.autonoma.laboral.entity.Trabajador;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(name = "SaveRemuneracionServlet", urlPatterns = "/saveremuneracion")
public class SaveRemuneracionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer trabajadorId = Integer.parseInt(request.getParameter("trabajador"));
        Integer ano = Integer.parseInt(request.getParameter("ano"));
        Integer mes = Integer.parseInt(request.getParameter("mes"));
        Float montoBruta = Float.parseFloat(request.getParameter("monto-bruta"));
        Float descuento = Float.parseFloat(request.getParameter("descuento"));
        Float montoLiquido = Float.parseFloat(request.getParameter("monto-liquido"));

        // Creación del objeto actividad
        TrabajadorDao trabajadorDao = new TrabajadorDao();
        Optional<Trabajador> optionalTrabajador = trabajadorDao.findId( trabajadorId );

        Remuneracion remuneracion = new Remuneracion( optionalTrabajador.get() , ano, mes, montoBruta, descuento, montoLiquido);

        try {
            RemuneracionDao dao = new RemuneracionDao();
            dao.insert( remuneracion );
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showremuneraciones");
        requestDispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p>TODO OK</p>");
    }
}
