import java.util.ArrayList;
import java.util.Scanner;
public class Editorial {
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<Autor> autores = new ArrayList<>();
    public static ArrayList<Articulo> articulos = new ArrayList<>();
    public static ArrayList<Editor> editores = new ArrayList<>();
    public static ArrayList<Revisor> revisores = new ArrayList<>();
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
    }

    //metodo par iniciar Sesión
    public static void iniciarSesion(Scanner sc){
        System.out.println("Ingrese su usuario: ");
        String userV = sc.nextLine();
        System.out.println("Ingrese su contraseña: ");
        String contraV = sc.nextLine();
        for(Usuario usuario: usuarios){
            if(usuario.getPassword().equals(contraV) && usuario.getUser().equals(userV)){
                System.out.println("Bienvenido.... "); // mensaje de bienvenida
                if (usuario instanceof Revisor){
                    System.out.println("Revisión de artículo"); // El usuario es un revisor
                }else if(usuario instanceof Editor){
                    System.out.println("Registro de decisión final del artīculo"); // El usuario es un editor
                }
                return;
            } 
        }
        System.out.println("Usuario o contraseña incorrectos...");
    }


    public static void someterArticulo(Scanner sc){
        Autor autor = Autor.ingresarDatosAutor(sc);
        Articulo articulo = Articulo.ingresarDatosArticulo(sc, autor);
        autor.setArticulo(articulo); 
        //guardar datos autor y guardar datos articulo en archivo
        System.out.println("Desea enviar el artículo a revisión 'S' , 'N': ");
        String opc2 = sc.nextLine();
        if (opc2.equalsIgnoreCase("S")){
            articulo.enviarArticuloARevision();
        }
       
    }


    public void asignarRevisores(Articulo articulo, ArrayList<Revisor> revisor){
    }

    public void notificarAutor(Articulo articulo, EstadoArticulo decision){}
    
}