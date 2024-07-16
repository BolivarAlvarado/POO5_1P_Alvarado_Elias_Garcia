package com.mycompany.correo1;
/**
 * Clase abstracta que representa a un usuario en el sistema.
 * Proporciona métodos para la gestión de usuarios y envío de correos electrónicos.
 */
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.Scanner;
public abstract class Usuario {
    protected String user;
    protected String password;
    protected String nombre;
    protected String apellido;
    protected String correoElectronico;
    protected RolUsuario rol;

    public abstract String generarCorreoElectronico(String nombre, String apellido);
    
    /**
     * Permite al usuario(Editor/Revisor) decidir sobre un artículo.
     * 
     * @param nombreArticulo El nombre del artículo en cuestión.
     * @param sc Un objeto Scanner para la entrada del usuario.
     */

    public abstract void decidirSobreArticulo(String nombreArticulo, Scanner sc);

    /**
     * Constructor para la clase Usuario.
     * 
     * @param user El nombre de usuario.
     * @param password La contraseña del usuario.
     * @param nombre El nombre real del usuario.
     * @param apellido El apellido del usuario.
     * @param rol El rol del usuario en el sistema.
     * @param correo El correo electrónico del usuario.
     */
    public Usuario(String user, String password, String nombre, String apellido, RolUsuario rol,String correo){
        this.user = user;
        this.correoElectronico = correo;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
    }
    /**
     * Envía un correo electrónico al destinatario especificado.
     * 
     * @param destinatario El correo electrónico del destinatario.
     * @param asunto El asunto del correo electrónico.
     * @param cuerpo El cuerpo del correo electrónico.
     */
    public void enviarCorreo(String destinatario, String asunto, String cuerpo){
        Properties props=new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("editorial.proyecto1.parcial@gmail.com", "pszalxluqqnpmjlo");
            }
            });
        try {
            // Crear el mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("editorial.proyecto1.parcial@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(cuerpo);

            // Enviar el mensaje
            Transport.send(message);

            System.out.println("Correo enviado exitosamente");

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public String getCorreoElectronico(){
        return correoElectronico;
    }

    public String getUser(){
        return user;
    }

    public String getPassword(){
        return password;
    }

    public RolUsuario getRol(){
        return rol;
    }
}
