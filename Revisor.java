public class Revisor extends Usuario{
  private String especialidad;
  private int numArtRe;
  public Revisor(String user, String password,String nombre,String apellido, String CorreoElectronico,Rolusuario rol,String especialidad,int numArtRe){
    super(user, password, apellido, CorreoElectronico, rol);
    this.especialidad=especialidad;
    this numArtRe
  }
  public String getEspecialidad(){
    return especialidad;
  }
  public void setEspecialidad(String especialidad){
    this.especialidad=especialidad;
  }
  public int getNumArtRe(){
    return numArtRe;
  }
  public void setNumArtRe(){
    this.numArtRe=numArtRe;
  }
  
}
