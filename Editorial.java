package emailsender;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


public class Editorial{
    private static String emailFromString="edgarcia20033@gmail.com";
    private static String passString="MegMente123";


    private Properties props;


    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<Revisor> revisores = new ArrayList<>();
    public static ArrayList<Autor> autores = new ArrayList<>();
    public static ArrayList<Editor> editores = new ArrayList<>();
    public static ArrayList<Articulo> articulos = new ArrayList<>();
    public static ArrayList<Revision> revisiones = new ArrayList<>();
    
    public Editorial(){
        
        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    }
    

    public void enviarCorreo(String asunto, String contenido, String archivoUsuarios) {
        // Obtener la sesión
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailFromString, passString);
            }
        });
         try {
            // Leer destinatarios del archivo usuarios.txt
              if (revisores.isEmpty()) {
                System.out.println("No hay destinatarios en el archivo " + archivoUsuarios);
                return;
            }

            // Crear el mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailFromString));

            // Añadir destinatarios
            for (Revisor destinatario : revisores) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario.getCorreoElectronico()));
            }

            message.setSubject(asunto);
            message.setText(contenido);

            // Enviar el correo
            Transport.send(message);

            System.out.println("Correo enviado exitosamente");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
   


    public static void main(String[] args) {
        // Crear editor, revisor a partir del archivo de usuarios
        //cargarUsuarios();
        usuarios.forEach(u -> System.out.println("Usuario: " + u.getUser() + ", Contraseña: " + u.getPassword()+", ROL: " + u.getRol() ));
        //Mostrar las opciones 
        mostrarMenu();
        Editorial editorial = new Editorial();
        String asunto = "Asunto del correo";
        String contenido = "Contenido del correo";
        String archivoUsuarios = "usuarios.txt";
        
        editorial.enviarCorreo(asunto, contenido, archivoUsuarios);
    }
    

        

    public static void cargarUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\usuarios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                
                if (datos.length >= 5) { // Verificar que haya suficientes elementos en la línea
                    String rolUsuario = datos[0];
                    String user = datos[3];
                    String password = datos[4];
                    String nombre = datos[1];
                    String apellido = datos[2];

                    switch (rolUsuario) {
                        case "EDITOR":
                            // Crear y agregar editor a la lista de usuarios
                            Editor editor = new Editor(user, password, nombre, apellido);
                            usuarios.add(editor);
                            //editores.add(editor);
                            break;
                        case "REVISOR":
                            // Crear y agregar revisor a la lista de usuarios
                            Revisor revisor = new Revisor(user, password, nombre, apellido);
                            usuarios.add(revisor);
                            //revisores.add(revisor);
                            break;
                        default:
                            System.out.println("Tipo de usuario no permitido: " + rolUsuario);
                            break;
                    }
                } 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void mostrarUsuariosAsignados(){
        for(Revisor revisor : revisores){
            if(revisor.getArticulo() != null){

                System.out.println("Usuario: "+revisor.getUser() + ", Contraseña: "+revisor.getPassword() + ", Artículo asignado: "+revisor.getArticulo().getTitulo());
            }
        }
    }

   

    //metodo para iniciar Sesión
    public static void iniciarSesion(Scanner sc){
        System.out.println("Ingrese su usuario: ");
        String userV = sc.nextLine();
        System.out.println("Ingrese su contraseña: ");
        String contraV = sc.nextLine();
        boolean comprobarUsuario = false;
        for(Usuario usuario: usuarios){
            if(usuario.getPassword().equals(contraV) && usuario.getUser().equals(userV)){ // Comprueba si el usuario, cotraseña ingresado esta en las lista de usuarios
                comprobarUsuario = true;
                System.out.println("Bienvenido.... "); // mensaje de bienvenida
                if (usuario instanceof Revisor){
                    Revisor revisor = (Revisor) usuario;
                    revisor.mostrarTareaRealizar();
                    break;
                }else if(usuario instanceof Editor){
                    Editor editor = (Editor) usuario;
                    editor.mostarTareaRealizar();
                }
                break;
            } 
        }
        if(!comprobarUsuario){
            System.out.println("Usuario o contraseña incorrectos...");
            System.out.println("-----------------------------------------");
        }
    }


    public static void mostrarMenu(){
        //Al ejecutar la aplicación, se mostrarán las opciones de Someter Artículo e Iniciar Sesión
        Scanner sc = new Scanner(System.in);
        int op = 0;
        do{
            System.out.println("1. Someter Articulo");
            System.out.println("2. Iniciar Sesion");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Ha escogido la opcion de someter articulo");
                    Autor.someterArticulo(sc);
                    //asignar automaticamente a dos revisores  de la lista de revisores
                    break;
                case 2:
                    System.out.println("Ha escogido la opcion de Iniciar Sesión");
                    iniciarSesion(sc);
                    break;
                case 3:
                    System.out.println("Salir");
                    break;
                default:
                System.out.println("Opcion invalida");
                    break;
            }
        }while(op!=3);
        sc.close();

    }
    
    // public boolean equals(Object obj){ // ver donde usar, implementarlo con equlas
    //     if( this == obj){
    //         return true;
    //     }if( obj == null){
    //         return false;
    //     }if( getClass() != obj.getClass()){
    //         return false;
    //     }
    //     Usuario user = (Usuario) obj;
    //     if(!this.equals(revision.getArticulo())){
    //       return false;
    //     }
    //     return true;
    //   }

    

// metodo para escribir en los archivos
        public static void escribirArchivo(String nombreArchivo, Object objeto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            bw.write(objeto.toString() + "\n");
            System.out.println("Objeto escrito en el archivo");
        } catch (IOException e) {
            e.printStackTrace();
            }
        }
    
    // public static ArrayList<String> LeeFichero(String nombreArchivo) {
    //     ArrayList<String> lineas = new ArrayList<>();
    //     try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo, StandardCharsets.UTF_8))) {
    //         String linea;
    //         while ((linea = br.readLine()) != null) {
    //             System.out.println(linea);
    //             lineas.add(linea);
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return lineas;
    // }
        
}
