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

@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {
   protected void  processRequest(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
       // 1. Procesamos parámetros
       String accion = request.getParameter("accion");
       // 2. Creamos los JavaBeans (clases de Modelo)
       Rectangulo rectanguloRequest = new  Rectangulo(2, 1);
       Rectangulo rectanguloSession = new  Rectangulo(3, 4);
       Rectangulo rectanguloApplication = new Rectangulo(5, 6);

       // 3. Agregamos el JavaBean a algún alcance (request, session, application)
       if ("agregarVariables".equals(accion)){
           // Alcance request
           request.setAttribute("rectanguloRequest", rectanguloRequest);
           // Alcance session
           HttpSession session = request.getSession();
           session.setAttribute("rectanguloSession", rectanguloSession);
           // Alcance application
           ServletContext application = request.getServletContext();
           application.setAttribute("rectanguloApplication", rectanguloApplication);
           // Agregamos un mensaje
           request.setAttribute("mensaje", "Las variables fueron agregadas");
           // 4. Redireccionamos al jsp de index
           request.getRequestDispatcher("index.jsp").forward(request, response);
       } else if ("listarVariables".equals(accion)) {
           // Redirigimos al jsp que despliega las variables
           request.getRequestDispatcher("/META-INF/alcanceVariables.jsp").forward(request, response);

       }
       else {
           // Redirige a la página de inicio
           request.setAttribute("mensaje", "Accion no proporcionada o desconocidas");
           request.getRequestDispatcher("index.jsp").forward(request, response);

       }

   }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }


}
