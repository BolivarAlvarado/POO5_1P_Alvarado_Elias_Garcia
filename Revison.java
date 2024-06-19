import java.util.ArrayList;

public class Revision{
  private String codigoRe;
  private Articulo articulo;
  private Revisor revisor;
  private ArrayList<String> comentrarios;
  private Decision decision;

  public Revision(String codigoRE, Articulo articulo, Revisor revisor, ArrayList<String>comentarios, Desicion decision){
    this.codigoRe=codigoRe;
    this.articulo=articulo;
    this.revisor=revisor;
    this.comentarios=comentarios;
    this.decision=decision;
  }
  public String getCodigoRe(){
    return codigoRe;
  }
  public void setCodigoRe(String codigoRe)(){
    this.codigoRe=codigoRe;
  }
  public Articulo getArticulo(){
    return articulo;
  }
  public void serArticulo(Articulo articulo){
    this.articulo=articulo;
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
  public void setComentarios(ArrayList<String> comentarios){
    this.comentarios=comentarios;
  }
  public Desicion getDesicion(){
    return revision;
  }
  public void setDesicion(Desicion desicion){
    this.desicion=desicion;
  }
}
  
