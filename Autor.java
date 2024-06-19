public class Autor extends Usuario{
    private String codigoAutor;
    private String institucion;
    private String campoInvestigacion;

    private String generarCodigoAutor(){
        return "Codigo";
    }
    public Autor(String user, String password, String nombre, String apellido, String correoElectronico,String codigoAutor, String institucion, String campoInvestigacion){
        super(user,password,nombre,apellido,correoElectronico,RolUsuario.AUTOR);
        this.institucion = institucion;
        this.campoInvestigacion = campoInvestigacion;
        this.codigoAutor = generarCodigoAutor();
    }
    public String getCodigoAutor(){
        return codigoAutor;
    }
    public String getInstitucion(){
        return institucion;
    }
    public String getCampoInvestigacion(){
        return campoInvestigacion;
    }
    public void setCodigoAutor(String codigoAutor){
        this.codigoAutor = codigoAutor;
    }
    public void setInstitucion(String institucion){
        this.institucion = institucion;
    }
    public void setCampoInvestigacion(String campoInvestigacion){
        this.campoInvestigacion = campoInvestigacion;
    }
}
