package com.mycompany.correo1;
import java.util.Scanner;

/**
 * Clase que representa a un editor en el sistema editorial.
 * Un editor puede tomar decisiones sobre los artículos y gestionar el proceso de revisión.
 */
public class Editor extends Usuario{
   private String nombreJournal;
   private Revision revision; //Atributo añadido para gestionar la revision de los articulos
   private EstadoArticulo estadoArticulo;
   

    /**
     * Constructor para crear un nuevo editor.
     * 
     * @param user El nombre de usuario del editor.
     * @param password La contraseña del editor.
     * @param nombre El nombre del editor.
     * @param apellido El apellido del editor.
     * @param correoElectronico El correo electrónico del editor.
     */
  public Editor(String user, String password, String nombre, String apellido, String correoElectronico){
    super(user,password,nombre,apellido,RolUsuario.EDITOR,correoElectronico);
    Editorial.editores.add(this);
   }

   @Override
   public String generarCorreoElectronico(String nombre, String apellido){
      String nombreUsuario = nombre.toLowerCase() + "." + apellido.toLowerCase();
      return nombreUsuario + "@gmail.com";
   }
    /**
     * Permite al Editor decidir sobre un artículo.
     * 
     * @param codigoIngresado El código del artículo, en el cual tomará su decisión.
     * @param sc Un objeto Scanner para la entrada del usuario.
     */
   @Override
   public void decidirSobreArticulo(String codigoIngresado,Scanner sc){
    System.out.println("Ingrese nombre del Journal: ");
    String nombreJournal = sc.nextLine();
    setNombreJournal(nombreJournal);

    //busca si el artículo ya paso por el proceso de revisión de los revisores
    for(Revision revision : Editorial.revisiones){
      if(revision.getArticulo().getCodigoArti().equals(codigoIngresado)){
        System.out.println("Estos son los comentarios ingresados por los revisores y su decisión");
        System.out.println(revision.getComentarios() + " " + revision.getArticulo().getEstado());
        setRevision(revision); // se le asigna la revisión al editor
        setEstadoArticulo(EstadoArticulo.EN_REVISION); //se cambia el estado del artículo
        System.out.println("------------------------------------ ");
        tomarDecision(revision,sc); //inicia el proceso de toma de decisión del editor
        break;
      }else{
        System.out.println("Codigo no encontrado...");
      }
    }
   }

    /**
     * Toma una decisión sobre un artículo revisado.
     * 
     * @param revision La revisión del artículo.
     * @param sc Un objeto Scanner para leer la entrada del usuario.
     */
   public void tomarDecision(Revision revision,Scanner sc){
    System.out.println("Editor: " + getNombre() + " " + getApellido());
    System.out.println("Ingrese su decisión para el artículo: " + revision.getArticulo().getTitulo());
    System.out.println("1. ACEPTAR");
    System.out.println("2. RECHAZAR");
    System.out.print("Ingrese opción: ");
    int decision = sc.nextInt();
    sc.nextLine();
    switch (decision) {
      case 1:
        setEstadoArticulo(EstadoArticulo.PUBLICADO);
        Editorial.escribirArchivo("revisiones.txt", toString()); //se guardan los datos en el archivo
        //Se notifica al autor los resultados de su artículo
        enviarCorreo(revision.getArticulo().getAutor().getCorreoElectronico(),"RESUTADOR FINAL",toString()); //Correo del autor
        System.out.println("Volviendo al menú...");
        break;
      case 2:
        setEstadoArticulo(EstadoArticulo.RECHAZADO);
        Editorial.escribirArchivo("revisiones.txt", toString()); //se guardan los datos en el archivo
        //Se notifica al autor los resultados de su artículo
        enviarCorreo(revision.getArticulo().getAutor().getCorreoElectronico(),"RESUTADOR FINAL",toString());
        System.out.println("Volviendo al menú...");
        break;
      default:
      System.out.println("Opción no válida");
        System.out.println("Volviendo al menú...");
        break;
    }
  }

  /**
  * Muestra las tareas a realizar por el editor.
  * 
  * @param sc Un objeto Scanner para leer la entrada del usuario.
  */
  public void mostarTareaRealizar(Scanner sc){
    System.out.println("Tarea a realizar de: " + getNombre() + " " + getApellido());
    System.out.println("Registro de decisión final del artículo");
    System.out.println("Articulos revisados: ");

    //Muestra los artículos revisados, con su código
    for (int i = 0; i < Editorial.revisiones.size(); i++) {
        Revision revisionActual = Editorial.revisiones.get(i);
        boolean estaRepetido = false;

        // Comparar con revisiones anteriores
    for (int j = 0; j < i; j++) {
        Revision revisionAnterior = Editorial.revisiones.get(j);
        if (revisionActual.getArticulo().getCodigoArti().equals(revisionAnterior.getArticulo().getCodigoArti())) {
            estaRepetido = true;
            break;
        }
    }
    if (!estaRepetido) {
        System.out.println("Título: " + revisionActual.getArticulo().getTitulo() + ", Codigo: " + revisionActual.getArticulo().getCodigoArti());
    }
}

    System.out.print("Ingrese el codigo del artículo: ");
    String codigoIngresado = sc.nextLine();
    decidirSobreArticulo(codigoIngresado,sc);
  }
  
  @Override
  public String toString(){ 
    // Debe mostrar el nombre del artículo, la decisión final, comentarios de los revisores y enviar correo
    return "Nombre del artículo: " + revision.getArticulo().getTitulo() +
    ", Editor: " + getNombre() + " " + getApellido() +
     ", Decisión final: " + estadoArticulo +
      ", Comentarios de los revisores: " + revision.getComentarios();
  }

  // Métodos getters y setters
  public String getNombreJournal(){
    return nombreJournal;
  }
  public void setNombreJournal(String nombreJournal){
    this.nombreJournal=nombreJournal;
  }
  public Revision getRevision(){
    return revision;
  }
  public void setRevision(Revision revision){
    this.revision = revision;
  }
  public EstadoArticulo getEstadoArticulo(){
    return estadoArticulo;
  }
  public  void setEstadoArticulo(EstadoArticulo estadoArticulo){
    this.estadoArticulo = estadoArticulo;
  }
}