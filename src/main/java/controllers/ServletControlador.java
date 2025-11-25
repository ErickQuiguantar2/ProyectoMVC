/*
 * Autor: Erick Sanguña
 * Descripción: Servlet de control que administra el flujo entre vistas y
 * asigna objetos Rectangulo a diferentes alcances (request, session, application).
 */

package controllers;

import Modelos.Rectangulo;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/*
 * Configura este servlet para atender la ruta /ServletControlador
 * Tanto para GET como POST.
 */
@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

    /*
     * Método central del servlet.
     * Se ejecuta tanto en GET como POST.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Obtención del parámetro 'accion' desde el formulario o URL
        String accion = request.getParameter("accion");

        // 2. Creación de objetos JavaBean Rectangulo (Modelo)
        Rectangulo rectanguloRequest = new Rectangulo(2, 1);
        Rectangulo rectanguloSession = new Rectangulo(3, 4);
        Rectangulo rectanguloApplication = new Rectangulo(5, 6);

        // 3. Evaluación de la acción recibida
        if ("agregarVariables".equals(accion)) {

            // Asignación al alcance REQUEST (solo para la petición actual)
            request.setAttribute("rectanguloRequest", rectanguloRequest);

            // Asignación al alcance SESSION (permanece mientras la sesión esté activa)
            HttpSession session = request.getSession();
            session.setAttribute("rectanguloSession", rectanguloSession);

            // Asignación al alcance APPLICATION (global mientras el servidor esté levantado)
            ServletContext application = request.getServletContext();
            application.setAttribute("rectanguloApplication", rectanguloApplication);

            // Mensaje de confirmación
            request.setAttribute("mensaje", "Las variables fueron agregadas");

            // Redirección interna hacia index.jsp
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else if ("listarVariables".equals(accion)) {

            // Redirección hacia JSP que mostrará las variables de cada alcance
            request.getRequestDispatcher("/META-INF/alcanceVariables.jsp").forward(request, response);

        } else {

            // Acción no válida o no enviada → regreso a index.jsp
            request.setAttribute("mensaje", "Accion no proporcionada o desconocida");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // Delegación de método GET hacia processRequest
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    // Delegación de método POST hacia processRequest
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    // Información general del servlet
    @Override
    public String getServletInfo() {
        return "Servlet controlador para manejar variables en request, session y application";
    }
}