abstract class Usuario {
    protected String user;
    protected String password;
    protected String nombre;
    protected String apellido;
    protected String CorreoElectronico;
    protected rolUsuario rol;

    public void IniciarSesion(String user, String password){
        System.out.println("metodo para iniciar sesion");
    }
}