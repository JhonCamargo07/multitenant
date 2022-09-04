package ModelVO;

/**
 *Esta clas es de dominio para la empresa
 * @author Jhon Camargo
 * @version 1.0.0
 */
public class EmpresaVO {
    private String idEmpresa;
    private String idUsuario;
    private String nombreEmpresa;
    private String informacionEmpresa;
    private String imgEmpresa;

    public EmpresaVO() {
    }

    public EmpresaVO(String idUsuario) {
        this.idUsuario = idUsuario;
    }
  
    public EmpresaVO(String nombreEmpresa, String informacionEmpresa, String imgEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.informacionEmpresa = informacionEmpresa;
        this.imgEmpresa = imgEmpresa;
    }

    public EmpresaVO(String idEmpresa, String nombreEmpresa, String informacionEmpresa, String imgEmpresa) {
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.informacionEmpresa = informacionEmpresa;
        this.imgEmpresa = imgEmpresa;
    }

    public EmpresaVO(String idEmpresa, String idUsuario, String nombreEmpresa, String informacionEmpresa, String imgEmpresa) {
        this.idEmpresa = idEmpresa;
        this.idUsuario = idUsuario;
        this.nombreEmpresa = nombreEmpresa;
        this.informacionEmpresa = informacionEmpresa;
        this.imgEmpresa = imgEmpresa;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getInformacionEmpresa() {
        return informacionEmpresa;
    }

    public void setInformacionEmpresa(String informacionEmpresa) {
        this.informacionEmpresa = informacionEmpresa;
    }

    public String getImgEmpresa() {
        return imgEmpresa;
    }

    public void setImgEmpresa(String imgEmpresa) {
        this.imgEmpresa = imgEmpresa;
    }

    @Override
    public String toString() {
        return "EmpresaVO{" + "idEmpresa=" + idEmpresa + ", idUsuario=" + idUsuario + ", nombreEmpresa=" + nombreEmpresa + ", informacionEmpresa=" + informacionEmpresa + ", imgEmpresa=" + imgEmpresa + '}';
    }
    
}
