import java.util.Arrays;

public class Menu{
  //Atributo de opciones pero se necesita una clase que haga esas opciones que determine sus formas, etc
  private World world;
  private Player[] players; //aqui van todos los jugadores

  public Menu(){
    players = new Player[5]; //por los momentos pongamos un limite de solo dos
    /*supongamos que solo hay un limite de 10 usuario, se puede buscar la manera
      de que no sea un array si no una lista, para que asi no sea un numero limitado
      si no que se vayan agregando los usuarios a medida que se desee*/

    // Aqui se deberian cargar los usuarios en el array, los que se conozcan, supongamos que por los momentos existen solo dos.
    players[0] = new Player("Ruben Luna");
    players[1] = new Player("Alejandro Martinez");
    byte dimension = 10;
    world = new World(players[0], dimension);
  }

  public void playGame(){
    world.initializeWorld();
    world.movePiece();
  }
}
