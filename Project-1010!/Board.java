import java.util.Arrays;

public abstract class Board{
  protected Box[] boxes;
  protected int numberOfBoxes;
  protected boolean[][] neighborhood;
  protected byte dimension; //pueden ser filas y columnas o un atributo que defina las casillas
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
    neighborhood = new boolean[numberOfBoxes][numberOfBoxes];
    for (int counterRows = 0; counterRows < numberOfBoxes; counterRows++) {
      for (int counterColumns = 0; counterColumns < numberOfBoxes; counterColumns++) {
          neighborhood[counterRows][counterColumns] = false;
      }
    }
  }

  public Box getBox(int positionBox){
    return this.boxes[positionBox];
  }

  public abstract void shapeBoard();

  //public abstract void typeOfPiece();

  //public abstract void checkPositions(Piece piece, byte row, byte column);
  public abstract boolean checkPositions(Piece piece, int positionBox);

  public void printBoard(){
    for (int counterRows = 0; counterRows < numberOfBoxes; counterRows++) {
      for (int counterColumns = 0; counterColumns < numberOfBoxes; counterColumns++)
          System.out.print("| " + neighborhood[counterRows][counterColumns] + " | ");
      System.out.println();
    }
  }

  public abstract int deleteRowColumn();

  public void statusBox(){
    printBoard();
  }
}
