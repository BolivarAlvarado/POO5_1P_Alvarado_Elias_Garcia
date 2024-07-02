import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Editorial {
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<Autor> autores = new ArrayList<>();
    public static ArrayList<Articulo> articulos = new ArrayList<>();
    public static ArrayList<Revision> revisiones = new ArrayList<>();
    public static void main(String[] args) {
        //Al ejecutar la aplicación, se mostrarán las opciones de Someter Artículo e Iniciar Sesión
        //S = someter articulo , I = iniciar sesion
        Scanner sc = new Scanner(System.in);
        System.out.println("Opciones 'S' O 'I': ");
        String opc = sc.nextLine();
        if(opc.equalsIgnoreCase("S")){
            someterArticulo(sc); 
        }else{
            iniciarSesion(sc);
        }
        sc.close();
    }

    //metodo para iniciar Sesión
    public static void iniciarSesion(Scanner sc){
        System.out.println("Ingrese su usuario: ");
        String userV = sc.nextLine();
        System.out.println("Ingrese su contraseña: ");
        String contraV = sc.nextLine();
        for(Usuario usuario: usuarios){
            if(usuario.getPassword().equals(contraV) && usuario.getUser().equals(userV)){ // Comprueba si el usuario, cotraseña ingresado esta en las lista de usuarios
                System.out.println("Bienvenido.... "); // mensaje de bienvenida
                // Mostrar su tarea a realizar dependiendo del tipo de usuario
                if (usuario instanceof Revisor){
                    System.out.println("Revisión de artículo");
                }else if(usuario instanceof Editor){
                    System.out.println("Registro de decisión final del artīculo"); 
                }
                return;
            } 
        }
        System.out.println("Usuario o contraseña incorrectos...");
    }

// Gestion de someter articulo
    public static void someterArticulo(Scanner sc){
        Autor autor = Autor.ingresarDatosAutor(sc); 
        escribirArchivo("autores.txt", autor.toString()); // guarda los datos ingresados en su respectivo archivo
        Articulo articulo = Articulo.ingresarDatosArticulo(sc, autor);
        autor.setArticulo(articulo); // VER COMO  AGREGAR  EL ARTICULO EN EL ARCHIVO 
        escribirArchivo("articulos.txt", articulo.toString());// guarda los datos ingresados en su rescpectivo archivo
        System.out.println("Desea enviar el artículo a revisión 'S' , 'N': "); //SI : 'S' , NO : 'N'
        String opc2 = sc.nextLine();
        if (opc2.equalsIgnoreCase("S")){
            articulo.enviarArticuloARevision(); // COMPLETAR ESTE METODO
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
    


    public void asignarRevisores(Articulo articulo, ArrayList<Revisor> revisor){
    }

    public void notificarAutor(Articulo articulo, EstadoArticulo decision){}
    
}