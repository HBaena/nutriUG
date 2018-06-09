// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SendEMail.java

package classes;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEMail
{

    public SendEMail(String destinatario, String asunto, String cuerpo, String fileName, String remitente, String clave)
    {
        this.remitente = "hbaena2adan@gmail.com";
        this.clave = "6dediciembre";
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.fileName = fileName;
        if(!remitente.isEmpty())
            this.remitente = remitente;
        if(!clave.isEmpty())
            this.clave = clave;
    }
    

    public boolean enviarConGMail()
    {
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props);
        BodyPart texto = new MimeBodyPart();
        BodyPart adjunto = new MimeBodyPart();
        MimeMultipart multipart = new MimeMultipart();
        MimeMessage message = new MimeMessage(session);
        try
        {
            texto.setText(cuerpo);
            adjunto.setDataHandler(new DataHandler(new FileDataSource(fileName)));
            adjunto.setFileName("registroDeSesion.pdf");
            multipart.addBodyPart(texto);
            multipart.addBodyPart(adjunto);
            message.setFrom(new InternetAddress(remitente));
            message.addRecipients(javax.mail.Message.RecipientType.TO, destinatario);
            message.setSubject(asunto);
            message.setContent(multipart);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch(MessagingException me)
        {
            me.printStackTrace();
            return false;
        }
        return true;
    }

    String destinatario;
    String remitente;
    String clave;
    String asunto;
    String cuerpo;
    String fileName;
}
