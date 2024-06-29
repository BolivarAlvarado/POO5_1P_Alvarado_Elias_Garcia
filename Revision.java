import java.util.ArrayList;

public class Revision{
  private String codigoRe;
  private Articulo articulo;
  private Revisor revisor;
  private ArrayList<String> comentarios;
  private Decision decision;

  public Revision(String codigoRe, Articulo articulo, Revisor revisor, ArrayList<String>comentarios, Decision decision){
    this.codigoRe=codigoRe;
    this.articulo=articulo;
    this.revisor=revisor;
    this.comentarios=comentarios;
    this.decision=decision;
    Editorial.revisiones.add(this);
  }
  public String getCodigoRe(){
    return codigoRe;
  }
  public void setCodigoRe(String codigoRe){
    this.codigoRe=codigoRe;
  }
  public Articulo getArticulo(){
    return articulo;
  }
  public void setArticulo(Articulo articulo){
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
  public void agregarComentario(String comentario){
    comentarios.add(comentario);
  }
  public Decision getDecision(){
    return decision;
  }
  public void setDecision(Decision decision){
    this.decision=decision;
  }
}
  
