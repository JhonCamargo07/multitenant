package util;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author jhona
 */
public class Password {

    /**
     * Este metodo encripta las contraseñas, utilizando spring security
     *
     * @param passwordNotEncript, Password sin encriptar
     * @return String, devuelve la contraseña encriptada
     */
    public static String encript(String passwordNotEncript) {
        return BCrypt.hashpw(passwordNotEncript, BCrypt.gensalt());
    }

    /**
     * Este metodo verifica si una contraseña sin encriptar es la misma que una
     * contraseña encriptada, utilizando spring security
     *
     * @param passwordNotEncript, Password sin encriptar
     * @param passwordEncript, Password con encriptacion
     * @return boolean, retorna si una contraseña encriptada es igual a una que
     * no lo esta
     */
    public static boolean verifyPassword(String passwordNotEncript, String passwordEncript) {
        return BCrypt.checkpw(passwordNotEncript, passwordEncript);
    }
}
