abstract class Usuario {
    protected String user;
    protected String password;
    protected String nombre;
    protected String apellido;
    protected String CorreoElectronico;
    protected RolUsuario rol;

    public Usuario(String user, String password, String nombre, String apellido, 
    String CorreoElectronico,RolUsuario rol){
        this.user = user;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.CorreoElectronico = CorreoElectronico;
        this.rol = rol;
    }

    public void IniciarSesion(String user, String password){
        System.out.println("metodo para iniciar sesion");
    }
}