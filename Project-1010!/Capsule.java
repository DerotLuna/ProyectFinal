import java.util.Arrays;

public class Capsule {
  //private Box[][] capsule; lo considero un atributo no necesario
  private byte dimension;
  //private int numberOfBoxes;
  private Object[] capsules; //aun no se de que tipo pone este atributo que almacenara las 3 capsulas que almacenan una pieza cada una
  private final byte numberOfPieces; //numeros de piezas a tener almacenadas para jugar

  public Capsule(byte dimension){
    this.dimension = dimension;
    //this.numberOfBoxes = dimension*dimension; por los momentos no lo veo como un atributo a tener.
    this.numberOfPieces = 3;
    capsules = new Object[numberOfPieces];
    for (byte counterCapsules = 0; counterCapsules < numberOfPieces; counterCapsules++) {
      Box[][] capsule = new Box[dimension][dimension];
      for (byte counterRows = 0; counterRows < dimension; counterRows++) { //no creo que se necesiten mas de 127 casillas, digo que el max sera 100.
        for (byte counterColumns = 0; counterColumns < dimension; counterColumns++) {
          capsule[counterRows][counterColumns] = new Box(counterRows+counterColumns);
        }
      }

        //Llama a un metodo que genera una pieza para ponerla en la capsula

        capsules[counterCapsules] = capsule;
      }


  }

  public void generatePieceCapsule(){

  }
}
