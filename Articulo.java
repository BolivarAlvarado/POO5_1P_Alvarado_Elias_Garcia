public class Articulo{
  private String titulo;
  private String contenido;
  private String resumen;
  private String codigoArti;
  private ArrayList<String> palaCla;
  private Autor autor;
  private EstadoArticulo estado;
  public Articulo(String titulo, String contenido, String resumen, String codigoArti, ArrayList<String> palaCla,Autor autor, EstadoArticulo estado){
    this.titulo=titulo;
    this.contenido=contenido;
    this.resumen=resumen;
    this.codigoArti=codigoArti;
    this.palaCla=palaCla;
    this.autor=autor;
  }
  public String getTitulo(){
    retun titulo;
  }
  public void setTitulo(String titulo){
    this.titulo=titulo;
  }
  public String getContenido(){
    retun titulo;
  }
  public void setContenido(String contenido){
    this.contenido=contenido;
  }
  public String getResumen(){
    retun resumen;
  }
  public void setResumen(String resumen){
    this.resumen=resumen;
  }
  public String getCodigoArti(){
    retun titulo;
  }
  public void setCodigoArti(String codigoArti){
    this.codigoArti=codigoArti;
  }
  public String getPalaCla(){
    retun palaCla;
  }
  public void setPalaCla(String palaCla){
    this.palaCla=palaCla;
  }
  public String getAutor(){
    retun autor;
  }
  public void setAutor(String autor){
    this.autor=autor;
  }
}
