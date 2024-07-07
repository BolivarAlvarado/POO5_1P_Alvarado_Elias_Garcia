import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Editorial {
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<Revisor> revisores = new ArrayList<>();
    public static ArrayList<Autor> autores = new ArrayList<>();
    public static ArrayList<Editor> editores = new ArrayList<>();
    public static ArrayList<Articulo> articulos = new ArrayList<>();
    public static ArrayList<Revision> revisiones = new ArrayList<>();
    public static void main(String[] args) {
        // Crear editor, revisor a partir del archivo de usuarios
        mostrarMenu();
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
                // Mostrar su tarea a realizar dependiendo del tipo de usuario
                if (usuario instanceof Revisor){
                    System.out.println("Tarea a realizar de: " + usuario.getNombre());
                    Revisor revisor = (Revisor) usuario;
                    System.out.println("Revisión de artículo");
                    //Agregar lo demas
                }else if(usuario instanceof Editor){
                    System.out.println("Tarea a realizar de: " + usuario.getNombre()); 
                    Editor editor = (Editor) usuario;
                    System.out.println("Registro de decisión final del artīculo"); 
                    //Agregar lo demas
                }
                break;
            } 
        }
        if(!comprobarUsuario){
            System.out.println("Usuario o contraseña incorrectos...");
        }
    }


    public static void mostrarMenu(){
        //Al ejecutar la aplicación, se mostrarán las opciones de Someter Artículo e Iniciar Sesión
        Scanner sc = new Scanner(System.in);
        int op = 0;
        do{
            System.out.println("Seleccione una opcion: ");
            System.out.println("0. Someter Articulo");
            System.out.println("1. Iniciar Sesion");
            System.out.println("2. Salir");
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 0:
                    System.out.println("Ha escogido la opcion de someter articulo");
                    Autor.someterArticulo(sc);
                    //asignar automaticamente a dos revisores  de la lista de revisores
                    break;
                case 1:
                    System.out.println("Ha escogido la opcion de Iniciar Sesion");
                    iniciarSesion(sc);
                    break;
                case 2:
                    System.out.println("Salir");
                    break;
                default:
                System.out.println("Opcion no valida");
                    break;
            }
 
        }while(op!=2);
        sc.close();

    }

    public void verificarRevision(Articulo articulo, Revisor revisor) {
        boolean existeRevision = false;
    
        for (Revision revision : revisiones) {
            if (revision.getArticulo().getCodigoArti().equals(articulo.getCodigoArti())) {
                // Proporcionar comentarios y tomar decisión
                revision.proporcionarComentarios();
                revision.tomarDecision();
                escribirArchivo("revisiones.txt", revision.toString());
                existeRevision = true;
            }
        }
    
        if (!existeRevision) {
            articulo.enviarArticuloARevision();
        }
    }
    

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
