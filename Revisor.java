import java.util.Scanner;

public class Revisor extends Usuario{
  private String especialidad;
  private int numArtRe;
  private Articulo articulo;
  private Decision decisionRevisor;
  public Revisor(String user, String password,String nombre,String apellido, String correoElectronico,String especialidad,int numArtRe){
    super(user,password,nombre,apellido,correoElectronico,RolUsuario.REVISOR);
    this.especialidad=especialidad;
    this.numArtRe = numArtRe;
    this.decisionRevisor = Decision.PENDIENTE;
    Editorial.revisores.add(this);
  }

  @Override
  public void generarCorreoElectronico(){} 



  @Override
  public void decidirSobreArticulo(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Tomar decisión sobre el articulo: " + articulo.getTitulo());
    System.out.println("1. ACEPTAR");
    System.out.println("2. RECHAZAR");
    int opc = sc.nextInt();
    sc.nextLine();
    switch (opc) {
      case 1:
        this.decisionRevisor = Decision.ACEPTADO;
        break;
      case 2:
        this.decisionRevisor = Decision.RECHAZADO;
        break;
      default:
      System.out.println("Opcion invalida");
        break;
    }
  }

    public void proporcionarComentarios(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese el artículo del cual desea proporcionar comentarios: ");
    String nombreArticulo = sc.nextLine();
    for(Revision revision : Editorial.revisiones){
      if(revision.getArticulo().getTitulo().equalsIgnoreCase((nombreArticulo))){
          System.out.println("Revisor: " + this.getNombre() + " " + this.getApellido());
          System.out.println("Ingrese los comentarios del artículo " + articulo.getTitulo() + ":");
          String comentario = sc.nextLine();
          revision.agregarComentario(comentario);
      }
    }
  }




  public String getEspecialidad(){
    return especialidad;
  }
  public void setEspecialidad(String especialidad){
    this.especialidad=especialidad;
  }
  public int getNumArtRe(){
    return numArtRe;
  }
  public void setNumArtRe(int numArtRe){
    this.numArtRe = numArtRe;
  }

  public Articulo getArticulo(){
    return articulo;
  }

  public void setArticulo(Articulo articulo){
    this.articulo = articulo;
  }
  
}
