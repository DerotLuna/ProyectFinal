import java.util.Random;

public class Piece{
  private String shape;
  private byte size;
  private String color;
  Random randomNumber = new Random();
  /*Atributo para saber que ocupa en Capsule o Board
    Se me ocurre hacer una clase padre entre tablero y capsula, donde compartan los atributos de casillas y numero de casillas.
    Al hacer eso, podre utilizar el polimorfismo para asi saber si la pieza pertene a tablero o a capsule. Esto es en caso
    de que sea necesario tener este tipo de dato, que creo que si.
  */

  public Piece(){
    byte shapeNumber = (byte)(randomNumber.nextInt()* 19 + 1);
    byte color = (byte)(randomNumber.nextInt()* 6 + 1);
    this.shape = shapePieces(shapeNumber);
  }

  public String shapePieces(byte shapeNumber){
    /*Esto me generaria las cosas random que necesite, modificar a un nombre mas
      mnemonico */

      String shape;//polsia

      if (shapeNumber == 1){
        size = 1;
        shape = "Cuadrado 1X1";
      }
      else if (shapeNumber == 2){
        size = 4;//tiene 4 casillas por decirlo de una manera, esto puede funcionar para el score (si es que lo usamos asi)
        shape = "Cuadrado 2X2";
      }
      else if (shapeNumber == 3){
        size = 9;
        shape = "Cuadrado 3X3";
      }
      else if (shapeNumber == 4){
        size = 2;
        shape = "linea horizontal de 2 casillas";
      }
      else if (shapeNumber == 5){
        size = 3;
        shape = "linea horizontal de 3 casillas";
      }
      else if (shapeNumber == 6){
        size = 4;
        shape = "linea horizontal de 4 casillas";
      }
      else if (shapeNumber == 7){
        size = 5;
        shape = "linea horizontal de 5 casillas";
      }
      else if (shapeNumber == 8){
        size = 2;
        shape = "Linea vertical de 2 casillas";
      }
      else if (shapeNumber == 9){
        size = 3;
        shape = "linea vertical de 3 casillas";
      }
      else if (shapeNumber == 10){
        size = 4;
        shape = "linea vertical de 4 casillas";
      }
      else if (shapeNumber == 11){
        size = 5;
        shape = "linea vertical de 5 casillas";
      }
      else if (shapeNumber == 12){
        size = 3;
        shape = "L de 3 casillas";
      }
      else if (shapeNumber == 13){
        size = 4;
        shape = "L de 4 casillas";
      }
      else if (shapeNumber == 14){
        size = 3;
        shape = "L con vista hacia la izquierda de 3 casillas";
      }
      else if (shapeNumber == 15){
        size = 4;
        shape = "L con vista hacia la izquierda de 4 casillas";
      }
      else if (shapeNumber == 16){
        size = 3;
        shape = "L invertida de 3 casillas";//capaz y se pueda pensar unos mejores nombres para esto.
      }
      else if (shapeNumber == 17){
        size = 4;
        shape = "L invertida de 4 casillas";
      }
      else if (shapeNumber == 18){
        size = 3;
        shape = "L invertida con vista hacia la izquierda de 3 casillas";
      }
      else{
        size = 4;
        shape = "L invertida con vista hacia la izquierda de 4 casillas";
      }

      return shape;
  }

  public boolean displacement_Piece(){
    return true;
  }
}
