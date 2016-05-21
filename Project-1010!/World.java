import java.util.Arrays;
import java.util.Scanner;

public class World{
  private int score;
  //private Menu subMenu; //atributo posible, o puede que sea un metodo!!!
  private Player player;
  private Piece[] capsule;
  private final byte limitCapsule;
  private byte dimension;
  private Board board;

  Scanner scanner = new Scanner(System.in);

  public World(Player player, byte dimension){
    this.player = player;
    this.score = 0; //validar que el juego sigue o si es una partida nueva
    this.limitCapsule = 3;
    this.capsule = new Piece[limitCapsule];
    this.dimension = dimension;
    this.board = new SquareBoard(dimension);
  }

  /*Se puede pasar el usuario por aqui o hacer un setter para asi cambiarlo
    hay que evaluar las contras de cada forma de iniciar el jugador.
    O se puede pasar por el constructor, puesto que al salirse o al perder un juego y salir a menu principal, el mundo se sale y
    se crearia de nuevo(mejor opcion es pasarla por constructor creo)*/
  public void initializeWorld(){
    /*Determino filas y columnas como constantes, debido que estas irian a capsule y capsule para mi
      siempre sera igual un almacenador, sin importar la forma del tablero. Incluso podria ponerlo de una vez en el
      constructor con su valores.
    */
    board.shapeBoard();

    for (byte counterOfPieces = 0; counterOfPieces < limitCapsule; counterOfPieces ++) {
      capsule[counterOfPieces] = new Piece(11); //le paso el numero de tipos de piezas
    }

    System.out.println("Jugador: " + player.getUser() + " Puntaje actual: " + score);
  }

  public int scanner_PositionPiece_Row_Column(int answer){
		int give_Back = 0; boolean flag = true;
		while(flag == true){
			if (answer == 1) System.out.print(" Que pieza desea mover?: ");
			else if (answer == 2) System.out.print(" Posicion casilla referencia: ");
			else System.out.print(" Ingrese columna: ");
			give_Back = scanner.nextInt(); System.out.print("\n");
			if (answer == 1 && (give_Back < limitCapsule) && (give_Back >= 0)) flag = false;
			else if (answer != 1 && (give_Back < dimension*dimension) && (give_Back >= 0)) flag = false;
			else System.out.print(" Valor incorrecto. \n");
		}
		return give_Back;
	}

  public void movePiece(){
    //byte deltaX = 2, deltaY = 2;

    for (byte counterOfPieces = 0; counterOfPieces < limitCapsule; counterOfPieces ++) {
      System.out.println("Pieza "+ "(" + counterOfPieces + "): " + capsule[counterOfPieces].getTypePiece() + " " + capsule[counterOfPieces].getSizePiece());
    }

    int positionPiece =  scanner_PositionPiece_Row_Column(1), positionBox =  scanner_PositionPiece_Row_Column(2);
    //board.checkPositions(capsule[positionPiece], row, column);
    boolean answer = board.checkPositions(capsule[positionPiece], positionBox);
    if(answer)
      System.out.println("La pieza: " + capsule[positionPiece].getTypePiece() + " " + capsule[positionPiece].getSizePiece() + " puede ser colocada");
    else
      System.out.println("La pieza: " + capsule[positionPiece].getTypePiece() + " " + capsule[positionPiece].getSizePiece() + " no puede ser colocada");
  }

}
