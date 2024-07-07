import java.util.Scanner;

public class Revisor extends Usuario{
  private String especialidad;
  private int numArtRe;
  private Articulo articulo;
  private Decision decisionRevisor;
  
  public Revisor(String user, String password,String nombre,String apellido){
    super(user,password,nombre,apellido,RolUsuario.REVISOR);
    this.correoElectronico = generarCorreoElectronico(nombre, apellido);
    this.decisionRevisor = Decision.PENDIENTE;
    this.numArtRe = 0;
    Editorial.revisores.add(this);
  }

  @Override
  public String generarCorreoElectronico(String nombre, String apellido){
    String nombreUsuario = nombre.toLowerCase() + "." + apellido.toLowerCase();
    return nombreUsuario + "@gmail.com"; 
  } 



  @Override
  public void decidirSobreArticulo(){//ver si se pasa articulo como parametro
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese su especialidad: ");
    String especialidad = sc.nextLine();
    System.out.println("Tomar decisión sobre el articulo: " + articulo.getTitulo());
    System.out.println("1. ACEPTAR");
    System.out.println("2. RECHAZAR");
    int opc = sc.nextInt();
    sc.nextLine();
    switch (opc) {
      case 1:
        this.decisionRevisor = Decision.ACEPTADO;
        this.especialidad = especialidad;
        this.numArtRe++;
        Editorial.escribirArchivo("revisores.txt", toString());
        System.out.println("Volviendo al menú....");
        break;
      case 2:
        this.decisionRevisor = Decision.RECHAZADO;
        this.especialidad = especialidad;
        this.numArtRe++;
        Editorial.escribirArchivo("revisores.txt", toString());
        System.out.println("Volviendo al menú....");
        break;
      default:
      System.out.println("Opcion invalida");
        break;
    }
  }

    public void proporcionarComentarios(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese el titulo del artículo del cual desea proporcionar comentarios: ");
    String nombreArticulo = sc.nextLine();
    for(Revision revision : Editorial.revisiones){
      if(revision.getArticulo().getTitulo().equals(nombreArticulo)){
          System.out.println("Revisor: " + this.getNombre() + " " + this.getApellido());
          System.out.println("Ingrese los comentarios del artículo " + revision.getArticulo().getTitulo() + ":");
          String comentario = sc.nextLine();
          revision.agregarComentario(comentario);
          decidirSobreArticulo();
      }
    }
  }

  public void mostrarTareaRealizar(){
    System.out.println("Tarea a realizar de: " + getNombre() + " " + getApellido());
    System.out.println("Revisión de artículo");
    proporcionarComentarios();
    //proporcionar comentarios y una decision
  }

  public String toString(){
    return "Nombre: " + nombre + ", Apellido: " + apellido + ", Especialidad: " + especialidad + ", Artículo: "
    + articulo.getTitulo() + ", Decisión: " + decisionRevisor + ", Artículos revisados: " + numArtRe;
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
