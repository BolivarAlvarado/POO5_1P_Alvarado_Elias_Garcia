import java.util.ArrayList;

public class Articulo{

  private String titulo;
  private String contenido;
  private String resumen;
  private String codigoArti;
  private ArrayList<String> palaCla;
  private Autor autor;
  private EstadoArticulo estado;

  private String generarCodigoArticulo(){
    return "Codigo";
}

  public Articulo(String titulo, String contenido, String resumen, String codigoArti, ArrayList<String> palaCla,Autor autor, EstadoArticulo estado){
    this.titulo = titulo;
    this.contenido = contenido;
    this.resumen = resumen;
    this.codigoArti = generarCodigoArticulo();
    this.palaCla = palaCla;
    this.autor = autor;
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
    return palaCla;
  }
  public void setPalaCla(ArrayList<String> palaCla){
    this.palaCla=palaCla;
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
