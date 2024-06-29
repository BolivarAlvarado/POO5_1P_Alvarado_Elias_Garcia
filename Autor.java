import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Autor extends Usuario{
    private String codigoAutor;
    private String institucion;
    private String campoInvestigacion;
    private ArrayList<Articulo> articulos;
private static final String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

  private String generarCodigoAutor(){
    Random rd = new Random();
    StringBuilder codigo = new StringBuilder(5);
    for(int i = 0; i< 5;i++){
      int var = rd.nextInt(caracteres.length());
      codigo.append(caracteres.charAt(var));
    }
    return codigo.toString();
}
    public Autor(String nombre, String apellido, String correoElectronico, String institucion, String campoInvestigacion){
        super(nombre,apellido,correoElectronico,RolUsuario.AUTOR);
        this.institucion = institucion;
        this.campoInvestigacion = campoInvestigacion;
        this.codigoAutor = generarCodigoAutor();
        this.articulos = new ArrayList<>();
        Editorial.autores.add(this);
    }


    public static Autor ingresarDatosAutor(Scanner sc){
        System.out.println("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su apellido: ");
        String apellido = sc.nextLine();
        System.out.println("Ingrese su correo Electrónico: ");
        String correoElectronico = sc.nextLine();
        System.out.println("Ingrese su institución: ");
        String institucion = sc.nextLine();
        System.out.println("Ingrese su campo de investigación: ");
        String campoInvestigacion = sc.nextLine();
        sc.close();
        return new Autor(nombre, apellido, correoElectronico, institucion, campoInvestigacion);
    }



    public void setArticulo(Articulo articulo){
        articulos.add(articulo);
    }

    public ArrayList<Articulo> getArticulos(){
        return articulos;  
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
    public void setInstitucion(String institucion){
        this.institucion = institucion;
    }
    public void setCampoInvestigacion(String campoInvestigacion){
        this.campoInvestigacion = campoInvestigacion;
    }
}
