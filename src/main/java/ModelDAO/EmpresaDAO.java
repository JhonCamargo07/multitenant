package ModelDAO;

import ModelVO.EmpresaVO;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase de encargara de tener todos los metodos que gestionan los datos en
 * la bd
 *
 * @author Jhon Camargo
 * @version 1.0.0
 */
public class EmpresaDAO {

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
    public List<EmpresaVO> select(String idUsuario) {
        EmpresaVO empresaVo = null;
        List<EmpresaVO> empresas = new ArrayList<>();
        sql = "SELECT id_empresa, nombre_empresa, id_usuario, informacion_empresa, img_empresa FROM empresa WHERE id_usuario = ?";

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, idUsuario);
            rs = stmt.executeQuery();

            if (rs.next()) {
                empresaVo = new EmpresaVO(rs.getString("id_empresa"), rs.getString("id_empresa"), rs.getString("nombre_empresa"), rs.getString("informacion_empresa"), rs.getString("img_empresa"));
                empresas.add(empresaVo);
            }

        } catch (SQLException ex) {
            System.out.println("Error al iniciar sesion: " + ex.toString());
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return empresas;
    }
}
