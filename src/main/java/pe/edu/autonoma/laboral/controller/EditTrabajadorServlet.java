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
import java.util.Optional;

@WebServlet(name = "EditTrabajadorServlet", urlPatterns = "/edittrabajador")
public class EditTrabajadorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt( request.getParameter("id") );

        //Trabajador trabajador = null;
        RequestDispatcher requestDispatcher = null;

        try {
            TrabajadorDao dao = new TrabajadorDao();
            Optional<Trabajador> optional = dao.findId(id);

            if( optional.isPresent() ) {
                request.setAttribute("trabajador", optional.get());
                requestDispatcher = request.getRequestDispatcher("edit-trabajador.jsp");
            } else {
                requestDispatcher = request.getRequestDispatcher("/showtrabajadores");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        requestDispatcher.forward(request, response);
    }
}
