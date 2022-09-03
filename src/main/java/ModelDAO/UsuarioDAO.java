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
        UsuarioVO usuarioVo = new UsuarioVO();
        String idUsuario = "0";
        sql = "SELECT id_usuario FROM usuario WHERE BINARY email_usuario = ?";

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, emailUsuario);
            rs = stmt.executeQuery();

            if (rs.next()) {
                usuarioVo = new UsuarioVO(rs.getString(1), rs.getString(2), rs.getString(3));
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
}
