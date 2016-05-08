public class Piece{
  private String shape;
  private String color;
  /*Atributo para saber que ocupa en Capsule o Board
    Se me ocurre hacer una clase padre entre tablero y capsula, donde compartan los atributos de casillas y numero de casillas.
    Al hacer eso, podre utilizar el polimorfismo para asi saber si la pieza pertene a tablero o a capsule. Esto es en caso
    de que sea necesario tener este tipo de dato, que creo que si.
  */
  public Piece(){

  }

  public void generate_Piece(){
    /*Esto me generaria las cosas random que necesite, modificar a un nombre mas
      mnemonico*/
  }

  public boolean displacement_Piece(){
    return true;
  }
}
