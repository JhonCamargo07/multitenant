package Controllers;

import ModelDAO.*;
import ModelVO.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Validaciones;

/**
 * Esta clase se encargará de conectar las vistas con los modelos
 *
 * @author Jhon Camargo
 * @version 1.0.0
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/Usuario"})
public class UsuarioController extends HttpServlet {

    HttpSession sesion = null;
    EmpresaDAO empresaDao = new EmpresaDAO();
    UsuarioDAO usuarioDao = new UsuarioDAO();
    UsuarioVO usuarioVo = null;

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtenemos los datos de los diferentes formularios
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        int opcion = Integer.parseInt(request.getParameter("opcion")); //Opcion para saber que se hara

        // Validamos la opcion
        switch (opcion) {
            case 1: //Login
                if (!Validaciones.esEmailCorrecto(email) || !Validaciones.esPasswordCorrecto(pass)) {
                    try ( PrintWriter out = response.getWriter()) {
                        out.println("Datos erroneos");
                    }
                } else {
                    usuarioVo = new UsuarioVO(email, pass);
                    this.login(request, response, usuarioVo);
                }
                break;
            default:
                throw new AssertionError();
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private void login(HttpServletRequest request, HttpServletResponse response, UsuarioVO usuarioVo) throws IOException {
        String idUsuario = usuarioDao.iniciarSesion(usuarioVo.getEmailUsuario(), usuarioVo.getPasswordUsuario());
        if (!idUsuario.equals("0")) {
            List<EmpresaVO> empresas = empresaDao.select(idUsuario);
            sesion = request.getSession(true);
            sesion.setAttribute("empresas", empresas);
            try ( PrintWriter out = response.getWriter()) {
                out.println(empresas);
            }
        }else{
            try ( PrintWriter out = response.getWriter()) {
                out.println("No se encontraron los datos");
            }
        }
    }

}
