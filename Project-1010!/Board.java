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
    neighborhood = new boolean[numberOfBoxes][numberOfBoxes];
    for (int counterRows = 0; counterRows < numberOfBoxes; counterRows++) {
      for (int counterColumns = 0; counterColumns < numberOfBoxes; counterColumns++) {
          neighborhood[counterRows][counterColumns] = false;
      }
    }
  }

  public void shapeBoard(){
    byte rowAndColumn = 0;
    byte counterStrike = dimension;
    byte counter = (byte)(counterStrike - 1);
    while (rowAndColumn < (numberOfBoxes - 1)){

      if(rowAndColumn <= counter){
        if (counter < numberOfBoxes - 1){
          neighborhood[rowAndColumn][counterStrike] = true;
          neighborhood[counterStrike][rowAndColumn] = true;
        }
        if (rowAndColumn < counter){
          neighborhood[rowAndColumn + 1][rowAndColumn] = true;
          neighborhood[rowAndColumn][rowAndColumn + 1] = true;
        }
      }
      System.out.println("rowAndColumn " + rowAndColumn);
      System.out.println("counterStrike " + counterStrike);
      System.out.println("counter " + counter);
      if (rowAndColumn == counter) counter = counterStrike;
      if (counterStrike < numberOfBoxes - 1) counterStrike ++;
      rowAndColumn ++;
    }
  }

  public void printBoard(){
    for (int counterRows = 0; counterRows < numberOfBoxes; counterRows++) {
      for (int counterColumns = 0; counterColumns < numberOfBoxes; counterColumns++)
          System.out.print("| " + neighborhood[counterRows][counterColumns] + " | ");
      System.out.println();
    }
  }

  public void statusBox(){
    printBoard();
    boxes[5].getStatus();
    boxes[8].setStatus(new LockedBox());
    boxes[8].getStatus();
  }
}
