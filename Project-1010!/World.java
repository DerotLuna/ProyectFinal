import java.util.Arrays;

public class World{
    private int score;
    //private Menu subMenu; //atributo posible, o puede que sea un metodo!!!
    private Player player;
    private Piece[] capsule;
    private final byte range;
  /*Atributos tentativos:
    private Board board;
    private Capsule capsule;*/

  public World(Player player){
    this.player = player;
    this.score = 0; //validar que el juego sigue o si es una partida nueva
    this.range = 3;
    this.capsule = new Piece[range];
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
    byte dimension = 3; //lo que se vaya a determinar, igual se cambiara este parametro y el atributo a donde va
    Board board = new Board(dimension);
    board.shapeBoard();
    for (byte counterOfPieces = 0; counterOfPieces < range; counterOfPieces ++) {
      capsule[counterOfPieces] = new Piece();
    }
    System.out.println("Jugador: " + player.getUser() + " Mejor puntaje: " + player.getBestScore() + " Puntaje actual: " + score);
    board.statusBox(); //pruebas

  }

}
