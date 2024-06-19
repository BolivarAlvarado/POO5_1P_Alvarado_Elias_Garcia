public class Editor extends Usuario{
   private String nombreJournal;
   private String codigoArticulo;
   private EstadoArticulo estadoArticulo;
   

  public Editor(String user, String password, String nombre, String apellido, String correoElectronico,String codigoArticulo, EstadoArticulo estadoArticulo){
    super(user,password,nombre,apellido,correoElectronico,RolUsuario.EDITOR);
    this.codigoArticulo = codigoArticulo;
    this.estadoArticulo = estadoArticulo;
   }
  public String getNombreJournal(){
    return nombreJournal;
  }
  public void setNombreJournal(String nombreJournal){
    this.nombreJournal=nombreJournal;
  }
  public String getCodigoArticulo(){
    return codigoArticulo;
  }
  public void setCodigoArticulo(String codigoArticulo){
    this.codigoArticulo=codigoArticulo;
  }
  public EstadoArticulo getEstadoArticulo(){
    return estadoArticulo;
  }
  public  void setEstadoArticulo(EstadoArticulo estadoArticulo){
    this.estadoArticulo = estadoArticulo;
  }
}