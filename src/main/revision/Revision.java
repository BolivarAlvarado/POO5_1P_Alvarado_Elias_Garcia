package main.revision;


import java.util.ArrayList;

import main.Editorial;
import main.usuarios.Revisor;

public class Revision{
  private Articulo articulo; //articulo
  private Revisor revisor; // revisor
  private ArrayList<String> comentarios; // comentarios del revisor
  private Decision decision; // decisiion del articulo

  public Revision(Revisor revisor, Articulo articulo){
    this.revisor = revisor;
    this.articulo = articulo;
    this.comentarios = new ArrayList<>();
    this.decision = null;
    Editorial.revisiones.add(this);
  }

public void notificarAutor(Articulo articulo, EstadoArticulo decision){}

public static void agregarRevision(Revisor revisor1, Revisor revisor2, Articulo articulo){
  Revision revision1 = new Revision(revisor1, articulo);
  Revision revision2 = new Revision(revisor2, articulo);
  if(Editorial.revisiones.contains(revision1) || Editorial.revisiones.contains(revision2)){
    System.out.println("La revisión ya se encuentra en la lista de revisiones");
  }
  System.out.println("Inicie sesión para proporcionar comentarios y tomar su decisión");
  System.out.println("Volviendo al menú...");
  }



public static void enviarCorreo(Revisor revisor){ 
  // revisor.getNombre() + " "+revisor.getApellido() + " se le ha asignado la revision del artículo: " + revisor.getArticulo().getTitulo() +
  // "Datos del Artículo: \n" + "Titulo: "+revisor.getArticulo().getTitulo() + 
  // "\n" + "Autor: "+revisor.getArticulo().getAutor() + "\n" + "Contenido" + "\n" + 
  // revisor.getArticulo().getContenido()+"\n"  +"Resumen"+ "\n"  + revisor.getArticulo().getResumen();

}

  @Override
  public String toString(){
    return "Artículo: " + articulo.getTitulo() + 
    ", Revisor: " + revisor.getNombre() + 
    ", Comentarios: "+comentarios + 
    ", Decision: " + decision;
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
  
