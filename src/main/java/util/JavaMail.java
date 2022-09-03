package util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
/**
 * Este metodo se encarga de enviar correos
 * @author Jhon Camargo
 * @version 1.0.0
 */
public class JavaMail {

    /**
     * Este metodo se encarga de enviar correos
     *
     * @param server, el servidor que usará para ser enviado
     * @param port, el puerto que se utilizará para enviar el correo
     * @param mail,la direccion de correo con la que se enviara al destinatario
     * @param password, contraseña de la persona que va a enviar el correo
     * (contrtaseña del parametro anterior)
     * @param address, email al que se enviara el correo (destinatario)
     * @param affair, asunto con el que se enviara el correo
     * @param message, mensaje con el que se enviara el correo
     * @throws AddressException, en caso de que ocurra algun error con los
     * correos
     * @throws MessagingException, en caso de que ocurra un error al enviar el
     * correo
     */
    public static void sendMail(String server, String port, final String mail, final String password, String address, String affair, String message) throws AddressException, MessagingException {
        // Configuracion del SMTP
        Properties property = new Properties();

        property.put("mail.smtp.host", server);
        property.put("mail.smtp.port", port);
        property.put("mail.smtp.auth", "true"); // Autenticar el inicio de sesión
        property.put("mail.smtp.starttls.enable", "true"); // Asegurar que el tls esté activo
        property.put("mail.smtp.starttls.required", true);
        property.put("mail.smtp.ssl.protocols", "TLSv1.2");
        property.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Authenticator autenticar = new Authenticator() {
            public PasswordAuthentication getAuthentication() {
                return new PasswordAuthentication(mail, password);
            }
        };

        Session sesion = Session.getInstance(property, autenticar);

        Message msg = new MimeMessage(sesion);
        msg.setFrom(new InternetAddress(mail));

        InternetAddress[] addresses = {new InternetAddress(address)};
        msg.setRecipients(Message.RecipientType.TO, addresses);
        msg.setSubject(affair);
        msg.setSentDate(new Date());
        msg.setText(message);

        Transport.send(msg, mail, password);
    }
}
