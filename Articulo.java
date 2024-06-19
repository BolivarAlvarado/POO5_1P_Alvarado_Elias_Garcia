import java.util.ArrayList;

public class Articulo{

  private String titulo;
  private String contenido;
  private String resumen;
  private String codigoArti;
  private ArrayList<String> palabrasClaves;
  private Autor autor;
  private EstadoArticulo estado;

  private String generarCodigoArticulo(){
    return "Codigo";
}

  public Articulo(String titulo, String contenido, ArrayList<String> palabrasClaves,Autor autor, EstadoArticulo estado, String resumen){
    this.titulo = titulo;
    this.contenido = contenido;
    this.resumen = resumen;
    this.codigoArti = generarCodigoArticulo();
    this.palabrasClaves = palabrasClaves;
    this.autor = autor;
    this.estado = estado;
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
