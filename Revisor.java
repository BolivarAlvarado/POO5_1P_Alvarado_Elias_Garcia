public class Revisor extends Usuario{
  private String especialidad;
  private int numArtRe;

  public Revisor(String user, String password,String nombre,String apellido, String CorreoElectronico,String especialidad,int numArtRe){
    super(user,password,nombre,apellido,CorreoElectronico,RolUsuario.REVISOR);
    this.especialidad=especialidad;
    this.numArtRe = numArtRe;
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
  public void setNumArtRe(int numArtRe){
    this.numArtRe = numArtRe;
  }
  
}
