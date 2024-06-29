abstract class Usuario {
    protected String user;
    protected String password;
    protected String nombre;
    protected String apellido;
    protected String CorreoElectronico;
    protected RolUsuario rol;

    public Usuario(String user, String password, String nombre, String apellido, String CorreoElectronico,RolUsuario rol){
        this.user = user;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.CorreoElectronico = CorreoElectronico;
        this.rol = rol;
    }

    public Usuario(String nombre,String apellido,String CorreoElectronico, RolUsuario rol){
        this.nombre = nombre;
        this.apellido = apellido;
        this.CorreoElectronico = CorreoElectronico;
        this.rol = rol;
    }

    public String getUser(){
        return user;
    }

    public String getPassword(){
        return password;
    }

    public RolUsuario getRol(){
        return rol;
    }

}