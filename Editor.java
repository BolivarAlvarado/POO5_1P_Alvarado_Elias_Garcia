public class Editor {
   private String nombreJournal;
   private String codigoArticulo;
   private EstadoArticulo estadpArticulo;
   

   public Editor(String codigoArticulo, EstadoArticulo estapArticulo){
      this.codigoArticulo = codigoArticulo
      this.estapArticulo = estapArticulo
   }
  public String getNombreJournal(){
    return nombreJournal;
  }
  public setNombreJournal(String nombreJournal){
    this.nombreJournal=nombreJournal
  }
  public String getCodigoArticulo(){
    return codigoArticulo;
  }
  public setCodigoArticulo(String codigoArticulo){
    this.codigoArticulo=codigoArticulo
  }
  public EstadoArticulo getEstadpArticulo(){
    return estadpArticulo;
  }
  public setEstadpArticulo(EstadoArticulo estadpArticulo){
    this.estadpArticulo=estadpArticulo
  }
