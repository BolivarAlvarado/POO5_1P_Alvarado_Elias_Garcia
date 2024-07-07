import java.util.Scanner;
public class Editor extends Usuario{
   private String nombreJournal;
   private Revision revision;
   private EstadoArticulo estadoArticulo;


  public Editor(String user, String password, String nombre, String apellido){
    super(user,password,nombre,apellido,RolUsuario.EDITOR);
    this.correoElectronico = generarCorreoElectronico(nombre, apellido);
    Editorial.editores.add(this);
   }
   @Override
   public String generarCorreoElectronico(String nombre, String apellido){
      String nombreUsuario = nombre.toLowerCase() + "." + apellido.toLowerCase();
      return nombreUsuario + "@gmail.com";
   }



   @Override
   public void decidirSobreArticulo(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese el codigo del artículo: ");
    String codigoIngresado = sc.nextLine();
    for(Revision revision : Editorial.revisiones){
      if(revision.getArticulo().getCodigoArti().equals(codigoIngresado)){
        System.out.println(revision.toString());
        setRevision(revision);
        System.out.println("------------------------------------ ");
        tomarDecision(revision);
      }
    }
    sc.close();
   }

   public void tomarDecision(Revision revision){
    Scanner sc = new Scanner(System.in);
    System.out.println("Revisor: " + revision.getRevisor().getNombre() + " " + revision.getRevisor().getApellido());
    System.out.println("Ingrese su decision para el artículo " + revision.getArticulo().getTitulo());
    System.out.println("1. Aceptar");
    System.out.println("2. Rechazar");
    int decision = sc.nextInt();
    sc.nextLine();
    switch (decision) {
      case 1:
        this.estadoArticulo = EstadoArticulo.PUBLICADO;
        break;
      case 2:
        this.estadoArticulo = EstadoArticulo.RECHAZADO;
        break;
      default:
      System.out.println("Opcion no valida");
        break;
    }
    sc.close();
  }




  public String getNombreJournal(){
    return nombreJournal;
  }
  public void setNombreJournal(String nombreJournal){
    this.nombreJournal=nombreJournal;
  }
  public Revision getRevision(){
    return revision;
  }
  public void setRevision(Revision revision){
    this.revision = revision;
  }
  public EstadoArticulo getEstadoArticulo(){
    return estadoArticulo;
  }
  public  void setEstadoArticulo(EstadoArticulo estadoArticulo){
    this.estadoArticulo = estadoArticulo;
  }
}