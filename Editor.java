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
    System.out.println("Ingrese nombre del Journal: ");
    String nombreJournal = sc.nextLine();
    System.out.print("Ingrese el codigo del artículo: ");
    String codigoIngresado = sc.nextLine();
    
    for(Revision revision : Editorial.revisiones){
      if(revision.getArticulo().getCodigoArti().equals(codigoIngresado)){
        this.nombreJournal = nombreJournal;
        setRevision(revision);
        setEstadoArticulo(EstadoArticulo.EN_REVISION);
        System.out.println("------------------------------------ ");
        tomarDecision(revision);
        //revision.toString(); // mostrar datos de la revision
      }else{
        System.out.println("Codigo no encontrado...");
      }
    }
   }

   public void tomarDecision(Revision revision){
    Scanner sc = new Scanner(System.in);
    System.out.println("Editor: " + getNombre() + " " + getApellido());
    System.out.println("Ingrese su decisión para el artículo: " + revision.getArticulo().getTitulo());
    System.out.println("1. ACEPTAR");
    System.out.println("2. RECHAZAR");
    int decision = sc.nextInt();
    sc.nextLine();
    switch (decision) {
      case 1:
        estadoArticulo = EstadoArticulo.PUBLICADO;
        break;
      case 2:
        estadoArticulo = EstadoArticulo.RECHAZADO;
        break;
      default:
      System.out.println("Opción no válida");
        break;
    }
    sc.close();
  }

  public void mostarTareaRealizar(){
    System.out.println("Tarea a realizar de: " + getNombre() + " " + getApellido());
    System.out.println("Registro de decisión final del artīculo"); 
    decidirSobreArticulo();
    Editorial.escribirArchivo("revisiones.txt", toString());
    //notificar al autor sobre la decision final del articulo
  }

  public String toString(){ //DEBE MOSTAR EL NOMBRE DEL ARTICULO, LA  DECISION FINAL, COMENTARIOS DE LOS REVISORES Y ENVIAR CORREO
    return "Nombre del artículo: " + revision.getArticulo().getTitulo() + ", Decisión final: " + 
    estadoArticulo + ", Comentarios de los revisores: " + revision.getComentarios();
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