public class Revisor extends Usuario{
  private String especialidad;
  private int numArtRe;

  public Revisor(String user, String password,String nombre,String apellido, String correoElectronico,String especialidad,int numArtRe){
    super(user,password,nombre,apellido,correoElectronico,RolUsuario.REVISOR);
    this.especialidad=especialidad;
    this.numArtRe = numArtRe;
    Editorial.revisores.add(this);
  }

  @Override
  public void generarCorreoElectronico(){} 



  @Override
  public void decidirSobreArticulo(){}




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
