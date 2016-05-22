import java.util.Random;
import java.awt.Color;

public class Piece{
  private static final Color[] COLORS = {Color.red, Color.blue, Color.green, Color.yellow, Color.pink, Color.magenta, Color.cyan};
  private final byte NUMBER_OF_PIECE;
  private String type; // hay tres tipos en 1010: cuadrado, linea, l
  private byte size; //la altura de la pieza (en l es la parte mas larga)
  private Color color;
  private byte id;

  Random randomNumber = new Random();
  public Piece(){
    NUMBER_OF_PIECE = 19;
    int randomPiece = (int)(randomNumber.nextDouble() * NUMBER_OF_PIECE + 1);
     color = COLORS[randomNumber.nextInt(COLORS.length)];
     /*Pido de mi arreglo PIECE_COLORS que me retorne un color random en una de las posiciones*/
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

  public Color getColorPiece(){
    return this.color;
  }

  public void shapePieces(int number){
    if (number == 1){
      this.size = 1;
      this.type = "Square";
    }
    else if (number == 2){
      this.size = 2;//tiene 4 casillas por decirlo de una manera, esto puede funcionar para el score (si es que lo usamos asi)
      this.type = "Square";
    }
    else if (number == 3){
      this.size = 3;
      this.type = "Square";
   }
   else if (number == 4){
      this.size = 2;
      this.type = "Horizontal Line";
    }
   else if (number == 5){
      this.size = 3;
      this.type = "Horizontal Line";
   }
   else if (number == 6){
      this.size = 4;
      this.type = "Horizontal Line";
   }
   else if (number == 7){
      this.size = 5;
      this.type = "Horizontal Line";
   }
   else if (number == 8){
      this.size = 2;
      this.type = "Vertical Line";
   }
   else if (number == 9){
     this.size = 3;
     this.type = "Vertical Line";
   }
  else if (number == 10){
     this.size = 4;
     this.type = "Vertical Line";
   }
   else if (number == 11){
     this.size = 5;
     this.type = "Vertical Line";
   }
   else if (number == 12){
     this.size = 3;
     this.type = "L";
   }
   else if (number == 13){
     this.size = 4;
     this.type = "L";
   }
   else if (number == 14){
     this.size = 3;
     this.type = "L hacia la izquierda";
   }
   else if (number == 15){
     this.size = 4;
     this.type = "L hacia la izquierda";
   }
   else if (number == 16){
     this.size = 3;
     this.type = "L invertida";//capaz y se pueda pensar unos mejores nombres para esto.
   }
   else if (number == 17){
     this.size = 4;
     this.type = "L invertida";
   }
   else if (number == 18){
     this.size = 3;
     this.type = "L invertida hacia la izquierda";
   }
   else if (number == 19){
     this.size = 4;
     this.type = "L invertida hacia la izquierda";
   }
   else System.out.println("El numero es: " + number);
  }
}
