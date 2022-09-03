
package ModelVO;

/**
 *Esta clase es de dominio
 * @author Jhon Camargo
 * @version 1.0.0
 */
public class UsuarioVO {
    private String idUsuario;
    private String emailUsuario;
    private String passwordUsuario;

    public UsuarioVO() {
    }

    public UsuarioVO(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioVO(String emailUsuario, String passwordUsuario) {
        this.emailUsuario = emailUsuario;
        this.passwordUsuario = passwordUsuario;
    }

    public UsuarioVO(String idUsuario, String emailUsuario, String passwordUsuario) {
        this.idUsuario = idUsuario;
        this.emailUsuario = emailUsuario;
        this.passwordUsuario = passwordUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    @Override
    public String toString() {
        return "UsuarioVO{" + "idUsuario=" + idUsuario + ", emailUsuario=" + emailUsuario + ", passwordUsuario=" + passwordUsuario + '}';
    }
    
}
