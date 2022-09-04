package ModelDAO;

import ModelVO.UsuarioVO;
import java.sql.*;
import java.util.logging.*;
import util.Password;

/**
 * Esta clase se encarga de tener lo metodos que gestionan la bd
 *
 * @author Jhon Camargo
 * @version 1.0.0
 */
public class UsuarioDAO extends Conexion {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private String sql = "";
    private boolean operacionExitosa = false;

    /**
     * Este metodo es para iniciar sesión
     *
     * @return String, retorna el id del usuario que inicia sesion
     */
    public String iniciarSesion(String emailUsuario, String passwordUsuario) {
        UsuarioVO usuarioVo = null;
        String idUsuario = "0";
//        sql = "SELECT id_usuario, email_usuario, password_usuario FROM usuario WHERE BINARY email_usuario = ?";
        sql = "SELECT * FROM usuario WHERE BINARY email_usuario = ?";

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, emailUsuario);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                usuarioVo = new UsuarioVO(rs.getString("id_usuario"), rs.getString("email_usuario"), rs.getString("password_usuario"));
                if (Password.verifyPassword(passwordUsuario, usuarioVo.getPasswordUsuario())) {
                    idUsuario = rs.getString("id_usuario");
                }
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al iniciar sesion: " + ex.toString());
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return idUsuario;
    }

    public String signUp(String emailUsuario, String passwordUsuario) {
        String idUsuario = "0";
        sql = "INSERT INTO usuario (email_usuario, password_usuario) VALUES(?,?)";

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, emailUsuario);
            stmt.setString(2, Password.encript(passwordUsuario)); //Se encripta el password
            stmt.executeUpdate();

            sql = "SELECT * FROM usuario WHERE email_usuario = ? ORDER BY id_usuario DESC LIMIT 1";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, emailUsuario);
            rs = stmt.executeQuery();

            if (rs.next()) {
                idUsuario = rs.getString("id_usuario");
            }

        } catch (SQLException ex) {
            System.out.println("Error al iniciar sesion: " + ex.toString());
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return idUsuario;
    }
}
