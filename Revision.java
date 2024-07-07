import java.util.ArrayList;
import java.util.Scanner;


public class Revision{
  private Articulo articulo; //articulo
  private Revisor revisor; // revisor
  private ArrayList<String> comentarios; // comentarios del revisor
  private Decision decision; // decisiion del articulo

  public Revision(Articulo articulo, Revisor revisor){
    this.revisor = revisor;
    this.articulo = articulo;
    this.comentarios = new ArrayList<>();
    this.decision = null;
    Editorial.revisiones.add(this);
  }


  //Gestion de revision
//Asignar automaticamente a dos revisores de la lista de revisores
//Enviar un correo a los revisores indicando que se les ha asignado un articulo(en el contenido del mail incluir a los datos del articulo)


public void notificarAutor(Articulo articulo, EstadoArticulo decision){}


public static void enviarCorreo(Articulo articulo, Revisor revisor){
  System.out.println(revisor.getNombre() + revisor.getApellido() + " se le ha asignado la revision del artículo: " + articulo.getTitulo());
  System.out.println("Datos del Artículo: \n" + "Titulo: "+articulo.getTitulo() + "\n" + "Autor: "+articulo.getAutor() + "\n" + "Contenido" + "\n" +articulo.getContenido()+"\n"  +"Resumen"+ "\n"  + articulo.getResumen());
  
}

  public void proporcionarComentarios(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Revisor: " + revisor.getNombre() + " " + revisor.getApellido());
    System.out.println("Ingrese los comentarios del artículo " + articulo.getTitulo() + ":");
    String comentario = sc.nextLine();
    comentarios.add(comentario);
    
  }

  public void tomarDecision(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Revisor: " + revisor.getNombre() + " " + revisor.getApellido());
    System.out.println("Ingrese su decision para el artículo " + articulo.getTitulo());
    System.out.println("1. Aceptar");
    System.out.println("2. Rechazar");
    int decision = sc.nextInt();
    sc.nextLine();
    switch (decision) {
      case 1:
        this.decision = Decision.ACEPTADO;
        break;
      case 2:
        this.decision = Decision.RECHAZADO;
        break;
      default:
      System.out.println("Opcion no valida");
        break;
    }
  }


  @Override
  public String toString(){
    return "--------------------------\n" + "Artículo: " + articulo.getTitulo() + "Revisor: " + revisor.getNombre() + "Comentarios: "+comentarios + "Decision: " + decision;

  }
  
  public Articulo getArticulo(){
    return articulo;
  }

  public Revisor getRevisor(){
    return revisor;
  }
  public void setRevisor(Revisor revisor){
    this.revisor=revisor;
  }
  public ArrayList<String> getComentarios(){
    return comentarios;
  }
  public void agregarComentario(String comentario){
    comentarios.add(comentario);
  }
  public Decision getDecision(){
    return decision;
  }
  public void setDecision(Decision decision){
    this.decision=decision;
  }
}
  
