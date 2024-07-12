package main.usuarios;


import java.util.Scanner;

import main.RolUsuario;
import main.revision.Articulo;
import main.revision.Decision;
import main.revision.Revision;
import main.Editorial;
import java.util.ArrayList;
//Guardar los datos de los revisores en un archivo revisores.txt
public class Revisor extends Usuario{
  private String especialidad;
  private int numArtRe;
  private ArrayList<Articulo> articulosRevisor = new ArrayList<>();
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
        System.out.println("Tomar decisión sobre el artículo: " + nombreArticulo);
        System.out.println("1. ACEPTAR");
        System.out.println("2. RECHAZAR");
        int opc = sc.nextInt();
        sc.nextLine();
        switch (opc) {
          case 1:
            setDecisionRevisor(Decision.ACEPTADO);
            setEspecialidad(especialidad);
            masNumArtRe();
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

    public void proporcionarComentarios(){
      try (Scanner sc = new Scanner(System.in)) {
      System.out.println("Estos son los artículos que se le ha asignado");
      for (Articulo articulo : articulosRevisor){
        System.out.println(" * " + articulo);
      }
      System.out.println("----------------------------------------------");
      System.out.print("Ingrese el titulo del artículo del cual desea proporcionar comentarios: ");
      String nombreArticulo = sc.nextLine();
      for(Articulo articulo : articulosRevisor){
        if(articulo.getTitulo().equals(nombreArticulo)){
          System.out.println("Ingrese los comentarios del artículo: ");
          String comentario = sc.nextLine();
          for(Revision revision: Editorial.revisiones){
            if(revision.getArticulo().getTitulo().equals(nombreArticulo)){
              revision.agregarComentario(comentario);
              decidirSobreArticulo(nombreArticulo);
              revision.setDecision(getDecisionRevisor());
              Editorial.escribirArchivo("revisiones.txt", revision.toString());
              System.out.println("Comentarios agregados a la revisión");
            }
          }
        }
      }
    }
  }


  public void mostrarTareaRealizar(){
    System.out.println("Tarea encargada: Revisión de artículo");
    System.out.println("----------------------------------------------");
    if(Editorial.articulos.equals(null)){
      System.out.println("No se han ingresado artículos");
    }else{
      proporcionarComentarios();
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



  public ArrayList<Articulo> getArticulosRevisor(){
    return articulosRevisor;
  }

  public void setArticulo(Articulo articulo){
    articulosRevisor.add(articulo);
  }
  
}
