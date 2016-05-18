import java.util.Random;

public class Piece{
  private String shapeOfPiece;
  private String color;
  /*Atributo para saber que ocupa en Capsule o Board
    Se me ocurre hacer una clase padre entre tablero y capsula, donde compartan los atributos de casillas y numero de casillas.
    Al hacer eso, podre utilizar el polimorfismo para asi saber si la pieza pertene a tablero o a capsule. Esto es en caso
    de que sea necesario tener este tipo de dato, que creo que si.
  */
  Random randomNumber = new Random();
  public Piece(){
    byte shapeOfPiece = (byte)(randomNumber.nextInt()* 19 + 1);
    byte color = (byte)(randomNumber.nextInt()* 6 + 1);
    this.shapeOfPiece = shapePieces(shapeOfPiece);
  }

  public String shapePieces(byte shapeOfPiece){
    /*Esto me generaria las cosas random que necesite, modificar a un nombre mas
      mnemonico*/
      String typeOfPiece = "EMPTY";
      switch (shapeOfPiece) {
        case 1:
          typeOfPiece = "Cuadrado 2x2";
          break;
        case 2:
          typeOfPiece = "Cuadrado 3x3";
          break;
        case 3:
          typeOfPiece = "Cuadrado 1x1";
          break;
        case 4:
          typeOfPiece = "linea horizontal de 2 casillas";
          break;
        case 5:
          typeOfPiece = "linea horizontal de 3 casillas";
          break;
        case 6:
          typeOfPiece = "linea horizontal de 4 casillas";
          break;
        case 7:
          typeOfPiece = "linea horizontal de 5 casillas";
          break;
        case 8:
          typeOfPiece = "linea vertical de 2 casillas";
          break;
        case 9:
          typeOfPiece = "linea vertical de 3 casillas";
          break;
        case 10:
          typeOfPiece = "linea vertical de 4 casillas";
          break;
        case 11:
          typeOfPiece = "linea vertical de 5 casillas";
          break;
        case 12:
          typeOfPiece = "L de 3 casillas ";
          break;
        case 13:
          typeOfPiece = "L inversa hacia la izquierda 3 casillas";
          break;
        case 14:
          typeOfPiece = "L inversa hacia abajo 3 casillas";
          break;
        case 15:
          typeOfPiece = "L inversa hacia arriba 3 casillas";
          break;
        case 16:
          typeOfPiece = "L de 4 casillas";
          break;
        case 17:
          typeOfPiece = "L hacia la izquierda 4 casillas";
          break;
        case 18:
          typeOfPiece = "L hacia abajo de 4 casillas";
          break;
        case 19:
          typeOfPiece = "L hacia la derecha de 4 casillas";
          break;
        default:
          break;
      }
      return typeOfPiece;
  }

  public boolean displacement_Piece(){
    return true;
  }
}
