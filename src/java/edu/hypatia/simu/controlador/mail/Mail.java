/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.mail;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author davrivas
 */
public class Mail {

    private final static String KEY_SMTP_SERVER = "mail.smtp.host";
    private final static String KEY_SMTP_FROM = "mail.smtp.user";
    private final static String KEY_SMTP_PASSWORD = "mail.smtp.password";

    private static Properties props;

    private static void loadConfig() {
        if (props == null) {
            props = new Properties();
            props.put(KEY_SMTP_SERVER, "smtp.gmail.com"); // Servidor SMTP de Google
            props.put(KEY_SMTP_FROM, "simucolombia@gmail.com"); // Correo
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put(KEY_SMTP_PASSWORD, "simuddnj"); // Clave del correo
            props.put("mail.smtp.auth", "true"); // Usar autenticación mediante usuario y clave
            props.put("mail.smtp.starttls.enable", "true"); // Para conectar de manera segura al servidor SMTP
            // Los puertos pueden ser 25, 465 o 587
            props.put("mail.smtp.port", "25"); // El puerto SMTP seguro de Google
        }
    }

    //Solo texto HTML
    public static void sendMail(String destinatario, String asunto, String cuerpoHTML) {
        loadConfig();
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(props.getProperty(KEY_SMTP_FROM)));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject("[SIMU] " + asunto);

            Multipart parts = new MimeMultipart();
            BodyPart bodyMail = new MimeBodyPart();
            String html = Mail.plantillaSIMU(cuerpoHTML);
            bodyMail.setContent(html, "text/html");
            parts.addBodyPart(bodyMail);
            message.setContent(parts);

            Transport transport = session.getTransport("smtp");
            transport.connect(props.getProperty(KEY_SMTP_SERVER),
                    props.getProperty(KEY_SMTP_FROM),
                    props.getProperty(KEY_SMTP_PASSWORD));
            transport.sendMessage(message, message.getAllRecipients());
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }

    // Con archivos adjuntos
    public static void sendMail(String destinatario, String asunto, String cuerpoHTML, List<File> archivos) throws IOException {
        loadConfig();
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(props.getProperty(KEY_SMTP_FROM)));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject("[SIMU] " + asunto);

            Multipart parts = new MimeMultipart();
            BodyPart bodyMail = new MimeBodyPart();
            String html = Mail.plantillaSIMU(cuerpoHTML);
            bodyMail.setContent(html, "text/html");
            parts.addBodyPart(bodyMail);

            for (File archivo : archivos) {
                MimeBodyPart attached = new MimeBodyPart();
                attached.attachFile(archivo);
                parts.addBodyPart(attached);
            }

            message.setContent(parts);

            Transport transport = session.getTransport("smtp");
            transport.connect(props.getProperty(KEY_SMTP_SERVER),
                    props.getProperty(KEY_SMTP_FROM),
                    props.getProperty(KEY_SMTP_PASSWORD));
            transport.sendMessage(message, message.getAllRecipients());
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }

    public static String plantillaSIMU(String html) {
        String rh = "<div style=\"display: flex; flex-direction: row; width: 100%;\">";
        rh += "<div style=\"padding: 10px; width: 100px;\">";
        rh += "<img src=\"https://drive.google.com/uc?export=view&id=1UcoicrRxhPHwkEBaMeXpT1kBtAjpR4rm\" alt=\"Logo de SIMU\" width=\"80\" height=\"auto\">";
        rh += "</div>";
        rh += "<div style=\"padding: 10px;\">";
        rh += html; // Es el cuerpo que se inserta
        rh += "<p style=\"margin-top: 25px;\"><strong>Atentamente</strong><br>";
        rh += "Equipo de SIMU</p>";
        rh += "</div>";
        rh += "</div>";

        return rh;
    }
}
