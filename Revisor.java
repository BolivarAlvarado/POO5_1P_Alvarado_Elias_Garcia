import java.util.Scanner;
import java.util.ArrayList;

public class Revisor extends Usuario{
  private String especialidad;
  private int numArtRe;
  private ArrayList<String> articulosRevisor = new ArrayList<>();
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
  public void decidirSobreArticulo(String nombreArticulo){
    if (nombreArticulo.equals(" ")){
      System.out.println("Error");
    }else{
      try (Scanner sc = new Scanner(System.in)) {
        System.out.print("Ingrese su especialidad: ");
        String especialidad = sc.nextLine();
        System.out.println("Tomar decisión sobre el articulo: " + nombreArticulo);
        System.out.println("1. ACEPTAR");
        System.out.println("2. RECHAZAR");
        int opc = sc.nextInt();
        sc.nextLine();
        switch (opc) {
          case 1:
            setDecisionRevisor(Decision.ACEPTADO);
            setEspecialidad(especialidad);
            masNumArtRe();;
            Editorial.escribirArchivo("revisores.txt", toString());
            System.out.println("Volviendo al menú....");
            break;
          case 2:
            setDecisionRevisor(Decision.RECHAZADO);
            setEspecialidad(especialidad);
            masNumArtRe();
            Editorial.escribirArchivo("revisores.txt", toString());
            System.out.println("Volviendo al menú....");
            break;
          default:
          System.out.println("Opcion inválida");
            break;
        }
      }
    }

  }

    public String proporcionarComentarios(){
      try (Scanner sc = new Scanner(System.in)) {
      System.out.println("Estos son los artículos que se le ha asignado");
      for (String articulo : articulosRevisor){
        System.out.println(" * " + articulo);
      }
      System.out.println("----------------------------------------------");
      System.out.print("Ingrese el titulo del artículo del cual desea proporcionar comentarios: ");
      String nombreArticulo = sc.nextLine();
      for(String articulo : articulosRevisor){
        if(articulo.equals(nombreArticulo)){
          System.out.println("Ingrese los comentarios del artículo: ");
          String comentario = sc.nextLine();
          for(Revision revision: Editorial.revisiones){
            if(revision.getArticulo().getTitulo().equals(nombreArticulo)){
              System.out.println("Comentarios agregados a la revisión");
              revision.agregarComentario(comentario);
            }
          }
          return nombreArticulo;
        }
      }
      return " ";
    }
  }


  public void mostrarTareaRealizar(){
    System.out.println("Tarea encargada: Revisión de artículo");
    System.out.println("----------------------------------------------");
    if(Editorial.articulos.equals(null)){
      System.out.println("No se han ingresado artículos");
    }else{
      String nombreArticulo = proporcionarComentarios();
      decidirSobreArticulo(nombreArticulo);
    }
  }

  public String toString(){
    return "Nombre: " + nombre +
     ", Apellido: " + apellido + 
     ", Especialidad: " + especialidad + 
     ", Artículo: " + articulosRevisor.toString() + 
     ", Decisión: " + decisionRevisor + 
     ", Artículos revisados: " + numArtRe;
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
  public void masNumArtRe(){
    this.numArtRe++;
  }

  public void setDecisionRevisor(Decision decision){
    this.decisionRevisor = decision;
  }

  public Decision getDecisionRevisor(){
    return decisionRevisor;
  }



  public ArrayList<String> getArticulosRevisor(){
    return articulosRevisor;
  }

  public void setArticulo(String articulo){
    articulosRevisor.add(articulo);
  }
  
}
