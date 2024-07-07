import java.util.ArrayList;
import java.util.Scanner;


public class Revision{
  private Articulo articulo; //articulo
  private Revisor revisor; // revisor
  private ArrayList<String> comentarios; // comentarios del revisor
  private Decision decision; // decisiion del articulo

  public Revision(Revisor revisor){
    this.revisor = revisor;
    this.articulo = revisor.getArticulo();
    this.comentarios = new ArrayList<>();
    this.decision = null;
    Editorial.revisiones.add(this);
  }


  //Gestion de revision
//Asignar automaticamente a dos revisores de la lista de revisores
//Enviar un correo a los revisores indicando que se les ha asignado un articulo(en el contenido del mail incluir a los datos del articulo)


public void notificarAutor(Articulo articulo, EstadoArticulo decision){}


public static void verificarRevision(Revisor revisor1, Revisor revisor2) {
  Revision revision1 = new Revision(revisor1);

  if(Editorial.revisiones.contains(revision1)){
    System.out.println("La revisión ya se encuentra en la lista de revisiones");
  }else{
    System.out.println("Revisión del artículo: " + revision1.getArticulo().getTitulo() + "agregada");
    Editorial.revisiones.add(revision1);
  }

  Revision revision2 = new Revision(revisor2);
  if(Editorial.revisiones.contains(revision2)){
    System.out.println("La revisión ya se encuentra en la lista de revisiones");
  }else{
    System.out.println("Revisión del artículo: " + revision2.getArticulo().getTitulo() + "agregada");
    Editorial.revisiones.add(revision2);
  }
  System.out.println("Inicie sesión para proporcionar comentarios y tomar su decisión");
  
  // boolean existeRevision = false;

  // for (Revision revision : Editorial.revisiones) {
  //     if (revision.getArticulo().getCodigoArti().equals(articulo.getCodigoArti())) {
  //         // Proporcionar comentarios y tomar decisión
  //         revision.proporcionarComentarios();
  //         revision.tomarDecision();
  //         Editorial.escribirArchivo("revisiones.txt", revision.toString());
  //         existeRevision = true;
  //     }
  // }

  // if (!existeRevision) {
  //     articulo.enviarArticuloARevision();
  // }

}


public static void enviarCorreo(Revisor revisor){
  System.out.println(revisor.getNombre() + revisor.getApellido() + " se le ha asignado la revision del artículo: " + revisor.getArticulo().getTitulo());
  System.out.println("Datos del Artículo: \n" + "Titulo: "+revisor.getArticulo().getTitulo() + 
  "\n" + "Autor: "+revisor.getArticulo().getAutor() + "\n" + "Contenido" + "\n" + 
  revisor.getArticulo().getContenido()+"\n"  +"Resumen"+ "\n"  + revisor.getArticulo().getResumen());
  
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
  
