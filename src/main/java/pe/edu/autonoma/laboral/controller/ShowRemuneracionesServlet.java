package pe.edu.autonoma.laboral.controller;

import pe.edu.autonoma.laboral.dao.RemuneracionDao;
import pe.edu.autonoma.laboral.dao.TrabajadorDao;
import pe.edu.autonoma.laboral.entity.Remuneracion;
import pe.edu.autonoma.laboral.entity.Trabajador;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowRemuneracionesServlet", urlPatterns = "/showremuneraciones")
public class ShowRemuneracionesServlet extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Crear la lista de remuneraciones
        List<Remuneracion> remuneraciones = new ArrayList<>();

        try {
            RemuneracionDao dao = new RemuneracionDao();
            remuneraciones = dao.list();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        request.setAttribute("remuneraciones", remuneraciones);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show-remuneraciones.jsp");
        requestDispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }
}
