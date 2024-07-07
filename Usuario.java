abstract class Usuario {
    protected String user;
    protected String password;
    protected String nombre;
    protected String apellido;
    protected String correoElectronico;
    protected RolUsuario rol;

    public abstract void generarCorreoElectronico(); 
    public abstract void decidirSobreArticulo();

    public Usuario(String user, String password, String nombre, String apellido, String correoElectronico,RolUsuario rol){
        this.user = user;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.rol = rol;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public String getCorreoElectronico(){
        return correoElectronico;
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