import java.util.ArrayList;
import java.util.Scanner;


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


  //Gestion de revision
//Asignar automaticamente a dos revisores de la lista de revisores
//Enviar un correo a los revisores indicando que se les ha asignado un articulo(en el contenido del mail incluir a los datos del articulo)


public void notificarAutor(Articulo articulo, EstadoArticulo decision){}

    // public boolean equals(Object obj){ // ver donde usar, implementarlo con equlas
    //     if( this == obj){
    //         return true;
    //     }if( obj == null){
    //         return false;
    //     }if( getClass() != obj.getClass()){
    //         return false;
    //     }
    //     Articulo articulo = (Articulo) obj;
    //     if(!this.equals(revision.getArticulo())){
    //       return false;
    //     }
    //     return true;
    //   }

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
//los revisores deben ingresar a la aplicacion para proporcionar comentarios y tomar decision
//Los cometarios y la decision de los revisores deben almacenarse en el archivo correspondiente

  // public boolean equals(Object obj){ // ver donde usar, implementarlo con equlas
  //   if( this == obj){
  //       return true;
  //   }if( obj == null){
  //       return false;
  //   }if( getClass() != obj.getClass()){
  //       return false;
  //   }
  //   Revision revision = (Revision) obj;
  //   if(!this.articulo.equals(revision.getArticulo())){
  //     return false;
  //   }
  //   return true;
  // }

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
    sc.close();
  }


  @Override
  public String toString(){
    return "--------------------------\n" + "Artículo: " + articulo.getTitulo() + ", Revisor: " + revisor.getNombre() + ", Comentarios: "+comentarios + ", Decision: " + decision;

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
  
