
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Articulo{
  private String titulo;
  private String contenido;
  private String resumen;
  private ArrayList<String> palabrasClaves;
  private String codigoArti;
  private Autor autor;
  private EstadoArticulo estado;
  private static final String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

  private static String generarCodigoArticulo(){
    Random rd = new Random();
    StringBuilder codigo = new StringBuilder(5);
    for(int i = 0; i< 5;i++){
      int var = rd.nextInt(caracteres.length());
      codigo.append(caracteres.charAt(var));
    }
    return codigo.toString();
}

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

  public static Articulo ingresarDatosArticulo(Scanner sc, Autor autor){
    System.out.println("Ingrese el título del artículo: ");
    String titulo = sc.nextLine();
    System.out.println("Ingrese el contenido del artículo: ");
    String contenido = sc.nextLine();
    System.out.println("Ingrese la cantidad de palabras clave que va ingresar: ");
    int cantP = sc.nextInt();
    sc.nextLine();
    ArrayList<String> palabrasClaves = new ArrayList<>();
    for(int i = 0; i < cantP;i++){
      System.out.println("Ingrese la palabra clave: ");
      String pClave = sc.nextLine();
      palabrasClaves.add(pClave);
    }
    System.out.println("Ingrese resumen del artículo:");
    String resumen = sc.nextLine();

    return new Articulo(autor,titulo,contenido,palabrasClaves,EstadoArticulo.INGRESADO,resumen);
  }
  @Override
  public String toString(){
    return "------------------------------\n"
    +"Autor: " + autor.getNombre() + ", Título: " + titulo + "Código: "+ codigoArti + ", Contenido: " + contenido +  
    ", Palabras Claves: " + palabrasClaves.toString() + ", Estado artículo: " + estado + ", Resumen: " 
    + resumen;
  }


  public void enviarArticuloARevision(){
    //Asignar a dos revisores de la lista de revisores
    //enviar correo indicando que se les ha asignado el articulo
    this.estado = EstadoArticulo.EN_REVISION;
    asignarRevisores();
  } 

  private void asignarRevisores(){
    Random rd = new Random();
    int r1 = rd.nextInt(Editorial.revisores.size());
    int r2;
    do{
      r2 = rd.nextInt(Editorial.revisores.size());
    } while(r2 == r1);

    Revisor revisor1 = Editorial.revisores.get(r1);
    Revisor revisor2 = Editorial.revisores.get(r2);

    System.out.println("Revisores asignados al artículo: " + revisor1.getArticulo().getTitulo());
    System.out.println(revisor1.getNombre() + " " + revisor1.getApellido());
    System.out.println(revisor2.getNombre() + " " + revisor1.getApellido());
    
    //ASIGNAR A UNA REVISION
    Revision.verificarRevision(revisor1, revisor2);
    //METODO PARA ENVIAR CORREO
  }








  
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
