import java.util.Scanner;
public class Editor extends Usuario{
   private String nombreJournal;
   private String codigoArticulo;
   private EstadoArticulo estadoArticulo;


  public Editor(String user, String password, String nombre, String apellido, String correoElectronico,String codigoArticulo, EstadoArticulo estadoArticulo){
    super(user,password,nombre,apellido,correoElectronico,RolUsuario.EDITOR);
    this.codigoArticulo = codigoArticulo;
    this.estadoArticulo = estadoArticulo;
    Editorial.editores.add(this);
   }
   @Override
   public void generarCorreoElectronico(){}



   @Override
   public void decidirSobreArticulo(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese el codigo del artículo: ");
    String codigoIngresado = sc.nextLine();
    for(Revision revision : Editorial.revisiones){
      if(revision.getArticulo().getCodigoArti().equals(codigoIngresado)){
        System.out.println(revision.toString());
        System.out.println("------------------------------------ ");
        tomarDecision(revision);
      }
    }
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
  }




  public String getNombreJournal(){
    return nombreJournal;
  }
  public void setNombreJournal(String nombreJournal){
    this.nombreJournal=nombreJournal;
  }
  public String getCodigoArticulo(){
    return codigoArticulo;
  }
  public EstadoArticulo getEstadoArticulo(){
    return estadoArticulo;
  }
  public  void setEstadoArticulo(EstadoArticulo estadoArticulo){
    this.estadoArticulo = estadoArticulo;
  }
}