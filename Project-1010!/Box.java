public class Box{
  private Status status;
  private final byte id;

  public Box(int id){
    this.id = (byte) id;
    this.status = new FreeBox(); //cambiara, puede tener otro estado al crearse (dependiendo del estilo de juego).
  }

  public void setStatus(Status status){
    this.status = status;
  }

  public void getStatus(){
      status.getStatus();
  }
}
