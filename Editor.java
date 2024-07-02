public class Editor extends Usuario{
   private String nombreJournal;
   private String codigoArticulo;
   private EstadoArticulo estadoArticulo;
   

  public Editor(String user, String password, String nombre, String apellido, String correoElectronico,String codigoArticulo, EstadoArticulo estadoArticulo){
    super(user,password,nombre,apellido,correoElectronico,RolUsuario.EDITOR);
    this.codigoArticulo = codigoArticulo;
    this.estadoArticulo = estadoArticulo;
    Editorial.editores.add(this);
   }
   @Override
   public void generarCorreoElectronico(){}



   @Override
   public void decidirSobreArticulo(){}




  public String getNombreJournal(){
    return nombreJournal;
  }
  public void setNombreJournal(String nombreJournal){
    this.nombreJournal=nombreJournal;
  }
  public String getCodigoArticulo(){
    return codigoArticulo;
  }
  public EstadoArticulo getEstadoArticulo(){
    return estadoArticulo;
  }
  public  void setEstadoArticulo(EstadoArticulo estadoArticulo){
    this.estadoArticulo = estadoArticulo;
  }
}