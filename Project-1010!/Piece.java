import java.util.Random;

public class Piece{
  private String type; // hay tres tipos en 1010: cuadrado, linea, l
  private byte size; //la altura de la pieza (en l es la parte mas larga)
  private String color;
  private byte id;
  /*Atributo para saber que ocupa en Capsule o Board
    Se me ocurre hacer una clase padre entre tablero y capsula, donde compartan los atributos de casillas y numero de casillas.
    Al hacer eso, podre utilizar el polimorfismo para asi saber si la pieza pertene a tablero o a capsule. Esto es en caso
    de que sea necesario tener este tipo de dato, que creo que si.
  */
  Random randomNumber = new Random();
  public Piece(int numberOfPieces){
    int randomPiece = (int)(randomNumber.nextDouble() * numberOfPieces + 1);
    int randomColor = (int)(randomNumber.nextDouble() * 6 + 1);
    shapePieces(randomPiece);
    //this.id = id;
    //this.color = colors(randomColor);
  }

  public String getTypePiece(){
    return this.type;
  }

  public byte getSizePiece(){
    return this.size;
  }

  public void shapePieces(int shapeNumber){
    if (shapeNumber == 1){
      this.size = 1;
      this.type = "Square";
    }
    else if (shapeNumber == 2){
      this.size = 2;//tiene 4 casillas por decirlo de una manera, esto puede funcionar para el score (si es que lo usamos asi)
      this.type = "Square";
    }
    else if (shapeNumber == 3){
      this.size = 3;
      this.type = "Square";
   }
   else if (shapeNumber == 4){
      this.size = 2;
      this.type = "Horizontal Line";
    }
   else if (shapeNumber == 5){
      this.size = 3;
      this.type = "Horizontal Line";
   }
   else if (shapeNumber == 6){
      this.size = 4;
      this.type = "Horizontal Line";
   }
   else if (shapeNumber == 7){
      this.size = 5;
      this.type = "Horizontal Line";
   }
   else if (shapeNumber == 8){
      this.size = 2;
      this.type = "Vertical Line";
   }
   else if (shapeNumber == 9){
     this.size = 3;
     this.type = "Vertical Line";
   }
  else if (shapeNumber == 10){
     this.size = 4;
     this.type = "Vertical Line";
   }
   else if (shapeNumber == 11){
     this.size = 5;
     this.type = "Vertical Line";
   }
   else if (shapeNumber == 12){
     this.size = 3;
     this.type = "L";
   }
   else if (shapeNumber == 13){
     this.size = 4;
     this.type = "L";
   }
   else if (shapeNumber == 14){
     this.size = 3;
     this.type = "L hacia la izquierda";
   }
   else if (shapeNumber == 15){
     this.size = 4;
     this.type = "L hacia la izquierda";
   }
   else if (shapeNumber == 16){
     this.size = 3;
     this.type = "L invertida";//capaz y se pueda pensar unos mejores nombres para esto.
   }
   else if (shapeNumber == 17){
     this.size = 4;
     this.type = "L invertida";
   }
   else if (shapeNumber == 18){
     this.size = 3;
     this.type = "L invertida hacia la izquierda";
   }
   else if (shapeNumber == 19){
     this.size = 4;
     this.type = "L invertida hacia la izquierda";
   }
   else System.out.println("El numero es: " + shapeNumber);
  }

  public boolean displacement_Piece(){
    return true;
  }
}
