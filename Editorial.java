//package emailsender;
import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;
import java.io.*;
//import java.util.Properties;
//import javax.mail.*;
//import javax.mail.internet.*;


public class Editorial{
    //private static String emailFromString="edgarcia20033@gmail.com";
   // private static String passString="MegMente123";


    //private Properties props;


    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<Revisor> revisores = new ArrayList<>();
    public static ArrayList<Autor> autores = new ArrayList<>();
    public static ArrayList<Editor> editores = new ArrayList<>();
    public static ArrayList<Articulo> articulos = new ArrayList<>();
    public static ArrayList<Revision> revisiones = new ArrayList<>();
    
    public static void main(String[] args) {
        // Crear editor, revisor a partir del archivo de usuarios
        cargarUsuarios();
        //Mostrar las opciones 
        mostrarMenu();
        // Editorial editorial = new Editorial();
        // String asunto = "Asunto del correo";
        // String contenido = "Contenido del correo";
        // String archivoUsuarios = "usuarios.txt";
        
        //editorial.enviarCorreo(asunto, contenido, archivoUsuarios);
    }
    
    public static void mostrarMenu(){
        Scanner sc = new Scanner(System.in);
        int op = 0;
        do{
            System.out.println("-----------------------------------------------------");
            System.out.println("1. Mostar los usuarios");
            System.out.println("2. Mostar revisores asignados a un artīculo");
            System.out.println("3. Someter Artículo");
            System.out.println("4. Iniciar Sesión");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt();
            sc.nextLine();
            System.out.println("-----------------------------------------------------");

            switch (op) {
                case 1:
                    usuarios.forEach(u -> System.out.println("Usuario: " + u.getUser() + ", Contraseña: " + u.getPassword()+", ROL: " + u.getRol() ));
                    break;
                case 2:
                    mostrarUsuariosAsignados();
                    break;
                case 3:
                    System.out.println("Ha escogido la opción de Someter Artículo");
                    Autor.someterArticulo(sc);
                    break;
                case 4:
                    System.out.println("Ha escogido la opción de Iniciar Sesión");
                    iniciarSesion(sc);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                System.out.println("Opción Inválida");
                    break;
            }
        }while(op!=5);
        sc.close();
    }
    // public Editorial(){
        
    //     props = new Properties();
    //     props.put("mail.smtp.auth", "true");
    //     props.put("mail.smtp.starttls.enable", "true");
    //     props.put("mail.smtp.host", "smtp.gmail.com");
    //     props.put("mail.smtp.port", "587");
    // }
    

    // public void enviarCorreo(String asunto, String contenido, String archivoUsuarios) {
    //     // Obtener la sesión
    //     Session session = Session.getInstance(props, new javax.mail.Authenticator() {
    //         protected PasswordAuthentication getPasswordAuthentication() {
    //             return new PasswordAuthentication(emailFromString, passString);
    //         }
    //     });
    //      try {
    //         // Leer destinatarios del archivo usuarios.txt
    //           if (revisores.isEmpty()) {
    //             System.out.println("No hay destinatarios en el archivo " + archivoUsuarios);
    //             return;
    //         }

    //         // Crear el mensaje de correo
    //         Message message = new MimeMessage(session);
    //         message.setFrom(new InternetAddress(emailFromString));

    //         // Añadir destinatarios
    //         for (Revisor destinatario : revisores) {
    //             message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario.getCorreoElectronico()));
    //         }

    //         message.setSubject(asunto);
    //         message.setText(contenido);

    //         // Enviar el correo
    //         Transport.send(message);

    //         System.out.println("Correo enviado exitosamente");

    //     } catch (MessagingException e) {
    //         e.printStackTrace();
    //     }
    // }
   
        

    public static void cargarUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
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
                            break;
                        case "REVISOR":
                            // Crear y agregar revisor a la lista de usuarios
                            Revisor revisor = new Revisor(user, password, nombre, apellido);
                            usuarios.add(revisor);
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
        boolean comprobar = false;
        for(Revisor revisor : revisores){
            if(!revisor.getArticulosRevisor().isEmpty()){
                comprobar = true;
                System.out.println("Usuario: "+revisor.getUser() + ", Contraseña: "+revisor.getPassword() + ", Artículo(s) Asignado(s): "+revisor.getArticulosRevisor().toString());
            }
        }
        if(!comprobar)
            System.out.println("No hay revisores asignados, para asignar revisores ingrese un artículo");
    }

    public static void iniciarSesion(Scanner sc){
        System.out.println("Ingrese su usuario: ");
        String userV = sc.nextLine();
        System.out.println("Ingrese su contraseña: ");
        String contraV = sc.nextLine();
        boolean comprobarUsuario = false;
        for(Usuario usuario: usuarios){
            if(usuario.getPassword().equals(contraV) && usuario.getUser().equals(userV)){ 
                comprobarUsuario = true;
                if (usuario instanceof Revisor){
                    Revisor revisor = (Revisor) usuario;
                    System.out.println("------------------------------------------------");
                    System.out.println("Bienvenido " + revisor.getNombre() + " " + revisor.getApellido());
                    revisor.mostrarTareaRealizar();
                    break;
                }else if(usuario instanceof Editor){
                    Editor editor = (Editor) usuario;
                    System.out.println("------------------------------------------------");
                    System.out.println("Bienvenido " + editor.getNombre() + " " + editor.getApellido());
                    editor.mostarTareaRealizar(sc);
                }
                break;
            } 
        }
        if(!comprobarUsuario){
            System.out.println("Usuario o contraseña incorrectos...");
            System.out.println("-----------------------------------------");
        }
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
            if(objeto instanceof Autor){
                System.out.println(" escrito en el archivo" + nombreArchivo);
            }else if(objeto instanceof Revisor){
                System.out.println(" escrito en el archivo" + nombreArchivo);
            }else if(objeto instanceof Articulo){
                System.out.println(" escrito en el archivo" + nombreArchivo);
            }
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
