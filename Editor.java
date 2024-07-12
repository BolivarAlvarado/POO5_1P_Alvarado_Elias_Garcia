import java.util.Scanner;
public class Editor extends Usuario{
   private String nombreJournal;
   private Revision revision; //Atributo añadido para gestionar la revision de los articulos
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
   public void decidirSobreArticulo(String codigoIngresado){
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese nombre del Journal: ");
    String nombreJournal = sc.nextLine();
    setNombreJournal(nombreJournal);


    for(Revision revision : Editorial.revisiones){
      if(revision.getArticulo().getCodigoArti().equals(codigoIngresado)){
        System.out.println("Estos son los comentarios ingresados por los revisores");
        System.out.println(revision.getComentarios());
        setRevision(revision); // LE ASIGNAMOS LA REVISION AL EDITOR
        setEstadoArticulo(EstadoArticulo.EN_REVISION); //EL ESTADO ARTICULO ESTA EN REVISION
        System.out.println("------------------------------------ ");
        tomarDecision(revision,sc); // LLAMAMOS AL METODO PARA QUE EL EDITOR TOME LA DECISION
      }else{
        System.out.println("Codigo no encontrado...");
      }
    }
   }

   public void tomarDecision(Revision revision,Scanner sc){
    System.out.println("Editor: " + getNombre() + " " + getApellido());
    System.out.println("Ingrese su decisión para el artículo: " + revision.getArticulo().getTitulo());
    System.out.println("1. ACEPTAR");
    System.out.println("2. RECHAZAR");
    int decision = sc.nextInt();
    sc.nextLine();
    switch (decision) {
      case 1:
        setEstadoArticulo(EstadoArticulo.PUBLICADO);
        Editorial.escribirArchivo("revisiones.txt", toString()); //ESCRITURA DEL EDITOR
        //NOTIFICAR AL AUTOR LA DECISION DEL ARTICULO - LLAMAR AL METODO NOTIFICAR AUTOR
        break;
      case 2:
        setEstadoArticulo(EstadoArticulo.RECHAZADO);
        Editorial.escribirArchivo("revisiones.txt", toString()); //ESCRITURA DEL EDITOR
        //NOTIFICAR AL AUTOR LA DECISION DEL ARTICULO - LLAMAR AL METODO NOTIFICAR AUTOR
        break;
      default:
      System.out.println("Opción no válida");
        break;
    }
    sc.close();
  }

  public void mostarTareaRealizar(Scanner sc){
    System.out.println("Tarea a realizar de: " + getNombre() + " " + getApellido());
    System.out.println("Registro de decisión final del artículo"); 
    System.out.print("Ingrese el codigo del artículo: ");
    String codigoIngresado = sc.nextLine();
    decidirSobreArticulo(codigoIngresado);
    Editorial.escribirArchivo("revisiones.txt", toString()); //Verificar esto
    //notificar al autor sobre la decision final del articulo
  }
  
  @Override
  public String toString(){ //DEBE MOSTAR EL NOMBRE DEL ARTICULO, LA  DECISION FINAL, COMENTARIOS DE LOS REVISORES Y ENVIAR CORREO
    return "Nombre del artículo: " + revision.getArticulo().getTitulo() +
    ", Editor: " + getNombre() + " " + getApellido() +
     ", Decisión final: " + estadoArticulo +
      ", Comentarios de los revisores: " + revision.getComentarios();
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