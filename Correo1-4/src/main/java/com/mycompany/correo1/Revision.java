package com.mycompany.correo1;
import java.util.ArrayList;


/**
 * Clase que representa una revisión realizada por un revisor a un artículo.
 * Una revisión contiene comentarios del revisor y su decisión sobre el artículo.
 */
public class Revision{
  private Articulo articulo; // Artículo bajo revisión
  private Revisor revisor; // Revisor que realiza la revisión
  private ArrayList<String> comentarios; // Comentarios del revisor
  private Decision decision; 

  /**
  * Constructor de la clase Revision.
  * @param revisor El revisor que realiza la revisión.
  * @param articulo El artículo que se está revisando.
  */
  public Revision(Revisor revisor, Articulo articulo){
    this.revisor = revisor;
    this.articulo = articulo;
    this.comentarios = new ArrayList<>();
    this.decision = null;
    Editorial.revisiones.add(this);
  }

  /**
  * Método estático para agregar dos revisiones para el mismo artículo con dos revisores diferentes.
  * @param revisor1 Primer revisor que realiza la revisión.
  * @param revisor2 Segundo revisor que realiza la revisión.
  * @param articulo El artículo que se está revisando.
  */
public static void agregarRevision(Revisor revisor1, Revisor revisor2, Articulo articulo){
  Revision revision1 = new Revision(revisor1, articulo);
  Revision revision2 = new Revision(revisor2, articulo);
  if(Editorial.revisiones.contains(revision1) || Editorial.revisiones.contains(revision2)){
    System.out.println("La revisión ya se encuentra en la lista de revisiones");
  }
  System.out.println("Inicie sesión para proporcionar comentarios y tomar su decisión");
  System.out.println("Volviendo al menú...");
  }

  /**
  * Devuelve una representación en forma de cadena de la revisión.
  * @return Cadena que representa la revisión con título del artículo, nombre del revisor, comentarios y decisión.
  */
  @Override
  public String toString(){
    return "Artículo: " + articulo.getTitulo() + 
    ", Revisor: " + revisor.getNombre() + 
    ", Comentarios: "+comentarios + 
    ", Decision: " + decision;
  }
  // Métodos getters y setters
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