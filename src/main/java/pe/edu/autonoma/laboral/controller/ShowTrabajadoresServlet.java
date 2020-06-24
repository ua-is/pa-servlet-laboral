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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowTrabajadoresServlet", urlPatterns = "/showtrabajadores")
public class ShowTrabajadoresServlet extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Trabajador> trabajadores = new ArrayList<>();

        try {
            TrabajadorDao dao = new TrabajadorDao();
            trabajadores = dao.list();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        request.setAttribute("trabajadores", trabajadores);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show-trabajadores.jsp");
        requestDispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }
}
