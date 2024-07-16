package com.mycompany.correo1;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Clase que representa a un revisor que puede evaluar artículos y proporcionar comentarios.
 * Un revisor tiene una especialidad y un número de artículos revisados.
 */
public class Revisor extends Usuario{
  private String especialidad;
  private int numArtRe;
  private ArrayList<Articulo> articulosRevisor = new ArrayList<>();
  private Decision decisionRevisor;

  /**
  * Constructor de la clase Revisor.
  * @param user El nombre de usuario del revisor.
  * @param password La contraseña del revisor.
  * @param nombre El nombre del revisor.
  * @param apellido El apellido del revisor.
  * @param correo El correo electrónico del revisor.
  */  
  public Revisor(String user, String password,String nombre,String apellido,String correo){
    super(user,password,nombre,apellido,RolUsuario.REVISOR,correo);
    this.decisionRevisor = Decision.PENDIENTE;
    this.numArtRe = 0;
    Editorial.revisores.add(this);
  }

  @Override
  public String generarCorreoElectronico(String nombre, String apellido){
    String nombreUsuario = nombre.toLowerCase() + "." + apellido.toLowerCase();
    return nombreUsuario + "@gmail.com"; 
  } 

  /**
  * Permite al revisor decidir sobre un artículo específico.
  * @param nombreArticulo El título del artículo a evaluar.
  * @param sc Scanner para capturar la entrada del usuario.
  */  
  @Override
  public void decidirSobreArticulo(String nombreArticulo, Scanner sc){
    if (nombreArticulo.equals(" ")){
      System.out.println("Error");
    }else{
        System.out.print("Ingrese su especialidad: ");
        String especialidad = sc.nextLine();
        System.out.println("Tomar decisión sobre el artículo: " + nombreArticulo);
        System.out.println("1. ACEPTAR");
        System.out.println("2. RECHAZAR");
        System.out.print("Ingrese opción: ");
        int opc = sc.nextInt();
        sc.nextLine(); 
        switch (opc) {
          case 1:
            setDecisionRevisor(Decision.ACEPTADO);
            setEspecialidad(especialidad);
            masNumArtRe();
            Editorial.escribirArchivo("revisores.txt", toString());
            break;
          case 2:
            setDecisionRevisor(Decision.RECHAZADO);
            setEspecialidad(especialidad);
            masNumArtRe();
            Editorial.escribirArchivo("revisores.txt", toString());
            break;
          default:
          System.out.println("Opcion inválida");
            break;
        }   
    }
  }
    /**
     * Permite al revisor proporcionar comentarios sobre los artículos asignados.
     * @param sc Scanner para capturar la entrada del usuario.
     */
    public void proporcionarComentarios(Scanner sc){
        System.out.println("Estos son los artículos que se le ha asignado");
        for (Articulo articulo : articulosRevisor){
          System.out.println(" * " + articulo);
        }
        System.out.println("----------------------------------------------");
        System.out.print("Ingrese el titulo del artículo del cual desea proporcionar comentarios: ");
        String nombreArticulo = sc.nextLine();
        //Busca si el artículo se le ha asignado
        for(Articulo articulo : articulosRevisor){
          if(articulo.getTitulo().equals(nombreArticulo)){
            System.out.print("Ingrese los comentarios del artículo: ");
            String comentario = sc.nextLine();
            for(Revision revision: Editorial.revisiones){
              if(revision.getArticulo().getTitulo().equals(nombreArticulo)){
                revision.agregarComentario(comentario);
                decidirSobreArticulo(nombreArticulo,sc);
                revision.setDecision(getDecisionRevisor());
                Editorial.escribirArchivo("revisiones.txt", revision.toString());
                System.out.println("Comentarios agregados a la revisión");
                System.out.println("Volviendo al menú....");
                break;
              }
            }
          }else{
            System.out.println("Usted no tiene asignada la revisión de ese artīculo o no esta dentro de la aplicación");
          }
        }
  }

    /**
     * Muestra las tarea que se le han encargado.
     * @param sc Scanner para capturar la entrada del usuario.
     */
  public void mostrarTareaRealizar(Scanner sc){
    System.out.println("Tarea encargada: Revisión de artículo");
    System.out.println("----------------------------------------------");
    if(Editorial.articulos.equals(null)){
      System.out.println("No se han ingresado artículos");
    }else{
      proporcionarComentarios(sc);
    }
  }
  /**
  * Devuelve una representación en forma de cadena del revisor.
  * @return Cadena que representa al revisor con su nombre, apellido, especialidad,
   artículos revisados, decisión y el  número de artículos que ha revisado.
  */
  public String toString(){
    return "Nombre: " + nombre +
     ", Apellido: " + apellido + 
     ", Especialidad: " + especialidad + 
     ", Artículo: " + articulosRevisor.toString() + 
     ", Decisión: " + decisionRevisor + 
     ", Artículos revisados: " + numArtRe;
  }



  // Métodos getters y setters
  public String getEspecialidad(){
    return especialidad;
  }
  public void setEspecialidad(String especialidad){
    this.especialidad=especialidad;
  }
  public int getNumArtRe(){
    return numArtRe;
  }
  public void masNumArtRe(){
    this.numArtRe++;
  }

  public void setDecisionRevisor(Decision decision){
    this.decisionRevisor = decision;
  }

  public Decision getDecisionRevisor(){
    return decisionRevisor;
  }



  public ArrayList<Articulo> getArticulosRevisor(){
    return articulosRevisor;
  }
  public ArrayList<String> getNombreArticulos(){
    ArrayList<String> nombresArticulo = new ArrayList<>();
    for(Articulo nombre : articulosRevisor){
      nombresArticulo.add(nombre.getTitulo());
    }
    return nombresArticulo;
  }
  public void setArticulo(Articulo articulo){
    articulosRevisor.add(articulo);
  }
}