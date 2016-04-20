package py.gog.mca.sisexpedientes.utiles;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author vinsfran
 */
@Stateless
@SessionScoped
public class EnviarCorreos {

    //Prueba
    private Configuraciones configuraciones;

//    @EJB
//    private ConfiguracionesSB configuracionesSB;
    public EnviarCorreos() {
        this.configuraciones = new Configuraciones();
    }

    public String enviarMail(String destino, String asunto, String htmlMensaje) {
        Configuraciones conf = new Configuraciones();
        conf.setPar01("no_responder@gmail.com");
        conf.setPar02("true");
        conf.setPar03("true");
        conf.setPar04("smtp.gmail.com");
        conf.setPar05("587");
        conf.setPar06("smtpserver");
        conf.setPar07("true");
        conf.setPar08("GMAIL");
        conf.setPar09("dos123456_789");
        conf.setPar10("serviciosasu@gmail.com");

        setConfiguraciones(conf);
        //Envio de Correo desde appWeb: 
        //par01=internet_address, no_responder@gmail.com
        //par02=mail_debug, true
        //par03=mail_smtp_auth, true
        //par04=mail_smtp_host, smtp.gmail.com 
        //par05=mail_smtp_port, 587
        //par06=mail_smtp_ssl_trust, smtpserver
        //par07=mail_smtp_starttls_enable, true
        //par08=nombre_proveedor, GMAIL
        //par09=password, dos123456_789
        //par10=usuario, serviciosasu@gmail.com

        Properties props = new Properties();

        props.setProperty("mail.debug", getConfiguraciones().getPar02());
        props.setProperty("mail.smtp.auth", getConfiguraciones().getPar03());
        props.setProperty("mail.smtp.host", getConfiguraciones().getPar04());
        props.setProperty("mail.smtp.port", getConfiguraciones().getPar05());
        // props.setProperty("mail.smtp.ssl.trust", confCorreo.getPar06());
        props.setProperty("mail.smtp.starttls.enable", getConfiguraciones().getPar07());

        Session mailSession = Session.getDefaultInstance(props, null);

        try {
            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject(asunto);
            try {
                message.setFrom(new InternetAddress(getConfiguraciones().getPar01(), "Servicios ASU"));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(EnviarCorreos.class.getName()).log(Level.SEVERE, null, ex);
            }
            message.setContent(htmlMensaje, "text/html; charset=UTF-8");
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(getConfiguraciones().getPar04(), getConfiguraciones().getPar10(), getConfiguraciones().getPar09());

            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return "OK";
        } catch (MessagingException e) {
            return e.getMessage();
        }
    }

    /**
     * @return the configuraciones
     */
    public Configuraciones getConfiguraciones() {
        return configuraciones;
    }

    /**
     * @param configuraciones the configuraciones to set
     */
    public void setConfiguraciones(Configuraciones configuraciones) {
        this.configuraciones = configuraciones;
    }

   

}
