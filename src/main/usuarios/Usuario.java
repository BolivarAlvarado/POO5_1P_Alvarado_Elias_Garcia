package main.usuarios;


import main.RolUsuario;

public abstract class Usuario {
    protected String user;
    protected String password;
    protected String nombre;
    protected String apellido;
    protected String correoElectronico;
    protected RolUsuario rol;

    public abstract String generarCorreoElectronico(String nombre, String apellido); 
    public abstract void decidirSobreArticulo(String nombreArticulo);

    public Usuario(String user, String password, String nombre, String apellido,RolUsuario rol){
        this.user = user;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
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