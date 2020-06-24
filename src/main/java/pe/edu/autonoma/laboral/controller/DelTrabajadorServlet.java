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
import java.util.Optional;

@WebServlet(name = "DelTrabajadorServlet", urlPatterns = "/deltrabajador")
public class DelTrabajadorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt( request.getParameter("id") );

        //Trabajador trabajador = null;
        RequestDispatcher requestDispatcher = null;

        try {
            TrabajadorDao dao = new TrabajadorDao();
            dao.deleteId(id);
            requestDispatcher = request.getRequestDispatcher("/showtrabajadores");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        requestDispatcher.forward(request, response);
    }
}
