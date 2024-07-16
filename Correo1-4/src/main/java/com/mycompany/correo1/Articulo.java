package com.mycompany.correo1;
import java.util.Random;

import java.util.Scanner;
import java.util.ArrayList;
/**
 * Clase que representa un artículo en el sistema editorial.
 * Contiene información sobre el título, contenido, resumen, palabras clave y estado del artículo.
 * También maneja la asignación de revisores y el envío de correos electrónicos relacionados.
 */
public class Articulo{
  private String titulo;
  private String contenido;
  private String resumen;
  private ArrayList<String> palabrasClaves;
  private String codigoArti;
  private Autor autor; // COMPROBAR SI SE USA, EN CASO QUE NO, ELIMINARLA
  private EstadoArticulo estado;
  private static final String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

  /**
  * Genera un código único para el artículo.
  * 
  * @return Un código de artículo aleatorio.
  */
  private static String generarCodigoArticulo(){
    Random rd = new Random();
    StringBuilder codigo = new StringBuilder(5);
    for(int i = 0; i< 5;i++){
      int var = rd.nextInt(caracteres.length());
      codigo.append(caracteres.charAt(var));
    }
    return codigo.toString();
}
    /**
     * Constructor para crear un nuevo artículo.
     * 
     * @param autor El autor del artículo.
     * @param titulo El título del artículo.
     * @param contenido El contenido del artículo.
     * @param palabrasClaves Lista de palabras clave asociadas al artículo.
     * @param estado El estado actual del artículo.
     * @param resumen Un resumen del artículo.
     */
  public Articulo(Autor autor,String titulo, String contenido, ArrayList<String> palabrasClaves, EstadoArticulo estado, String resumen){
    this.titulo = titulo;
    this.contenido = contenido;
    this.resumen = resumen;
    this.codigoArti = generarCodigoArticulo();
    this.palabrasClaves = palabrasClaves;
    this.estado = estado;
    this.autor = autor;
    Editorial.articulos.add(this);
  }

    /**
     * Ingresa los datos de un nuevo artículo a través de la entrada del usuario.
     * 
     * @param sc Un objeto Scanner para leer la entrada del usuario.
     * @param autor El autor que está ingresando el artículo.
     * @return Un nuevo objeto Articulo con los datos ingresados.
     */
  public static Articulo ingresarDatosArticulo(Scanner sc, Autor autor){
    System.out.println("------------------------------------");
    System.out.println(autor.getNombre() + " " + autor.getApellido() + ", Ingrese los datos de su artículo");
    System.out.println("------------------------------------");
    System.out.print("Ingrese el título del artículo: ");
    String titulo = sc.nextLine();
    System.out.print("Ingrese el contenido del artículo: ");
    String contenido = sc.nextLine();
    System.out.print("Ingrese la cantidad de palabras clave que va ingresar: ");
    int cantP = sc.nextInt();
    sc.nextLine();
    ArrayList<String> palabrasClaves = new ArrayList<>();
    for(int i = 1; i < cantP + 1;i++){
      System.out.println("Ingrese la palabra clave N(" +i+")");
      String pClave = sc.nextLine();
      palabrasClaves.add(pClave);
    }
    System.out.print("Ingrese resumen del artículo: ");
    String resumen = sc.nextLine();

    return new Articulo(autor,titulo,contenido,palabrasClaves,EstadoArticulo.INGRESADO,resumen);
  }

    /**
     * Representa el artículo como una cadena de texto.
     * 
     * @return Una representación en forma de cadena del artículo.
     */
  @Override
  public String toString(){
    return "Autor: "+ autor.getNombre() + " " + autor.getApellido() + 
    ", Título: " + titulo + 
    ", Código: "+ codigoArti + 
    ", Contenido: " + contenido +  
    ", Palabras Claves: " + palabrasClaves.toString() + 
    ", Estado artículo: " + estado + 
    ", Resumen: "  + resumen;
  }
    /**
     * Cambia el estado del artículo a 'en revisión' y asigna revisores.
     * @param this el articulo que llamo al método 
     */
  public void enviarArticuloARevision(){
    System.out.println("---------------------------------------");
    setEstado(EstadoArticulo.EN_REVISION);
    asignarRevisores(this); 
  } 
    /**
     * Asigna revisores al artículo tomando dos al azar de la lista de revisores
     * Envía correos electrónicos a los revisores notificando la asignación.
     * 
     * @param articulo El artículo al que se le asignarán revisores.
     */
  private void asignarRevisores(Articulo articulo){
    Random rd = new Random();
    if (Editorial.revisores.size() < 2){
      System.out.println("No hay suficientes revisores");
    }else{
      int r1 = rd.nextInt(Editorial.revisores.size());
      int r2;
      do{
        r2 = rd.nextInt(Editorial.revisores.size());
      } while(r2 == r1);
  
      Revisor revisor1 = Editorial.revisores.get(r1);
      revisor1.setArticulo(articulo);
      revisor1.enviarCorreo(revisor1.getCorreoElectronico(), "ASIGNACION DE ARTICULO", articulo.toString());

      Revisor revisor2 = Editorial.revisores.get(r2);
      revisor2.setArticulo(articulo);
      revisor2.enviarCorreo(revisor1.getCorreoElectronico(), "ASIGNACION DE ARTICULO", articulo.toString());
 
      System.out.println("Revisores asignados al artículo: " + articulo.getTitulo());
      System.out.println(" * " + revisor1.getNombre() + " " + revisor1.getApellido());
      System.out.println(" * " + revisor2.getNombre() + " " + revisor1.getApellido());
      
      //Se agrega la revisión del artículo a lista de revisiones para que cuando se acceda como editor, se pueda visualizar
      Revision.agregarRevision(revisor1, revisor2,articulo);
    }

  }

  // Métodos getters y setters
  public String getTitulo(){
    return titulo;
  }

  public void setTitulo(String titulo){
    this.titulo=titulo;
  }
  public String getContenido(){
    return contenido;
  }
  public void setContenido(String contenido){
    this.contenido=contenido;
  }
  public String getResumen(){
    return resumen;
  }
  public void setResumen(String resumen){
    this.resumen=resumen;
  }
  public String getCodigoArti(){
    return codigoArti;
  }
  public ArrayList<String> getPalaCla(){
    return palabrasClaves;
  }
  public void setPalaCla(ArrayList<String> palabrasClaves){
    this.palabrasClaves=palabrasClaves;
  }
  public Autor getAutor(){
    return autor;
  }
  public void setAutor(Autor autor){
    this.autor=autor;
  }
  public EstadoArticulo getEstado(){
    return estado;
  }
  public void setEstado(EstadoArticulo estado){
    this.estado = estado;
  }
  
}
