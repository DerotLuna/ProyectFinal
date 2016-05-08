import java.util.Arrays;

public class Board{
  private Box[] boxes;
  private int numberOfBoxes;
  private boolean[][] neighborhood;
  private byte dimension; //pueden ser filas y columnas o un atributo que defina las casillas
  /* Buscar la manera de no tener la dimension, porque en un tablero en forma de rombo ya la dimension como la definimos
     no nos serviria. O cualquier otro tipo de tablero que no sea ni cuadrado o rectangular*/

  public Board(byte dimension){
    this.dimension = dimension;
    this.numberOfBoxes = dimension*dimension;
    //this.numberOfBoxes = columns*rows;
    boxes = new Box[numberOfBoxes];
    for (byte counter = 0; counter < numberOfBoxes; counter++) { //no creo que se necesiten mas de 127 casillas, digo que el max sera 100.
      boxes[counter] = new Box(counter);
    }
    neighborhood = new boolean[dimension][dimension];
    for (byte counterRows = 0; counterRows < dimension; counterRows++) {
      for (byte counterColumns = 0; counterColumns < dimension; counterColumns++) {
        neighborhood[counterRows][counterColumns] = false;
      }
    }
  }

  public void statusBox(){
    boxes[5].getStatus();
    boxes[8].setStatus(new LockedBox());
    boxes[8].getStatus();
  }
}
