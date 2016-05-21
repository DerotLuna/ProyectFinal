public class SquareBoard extends Board{
  private final byte id;

  public SquareBoard(byte dimension){
    super(dimension);
    this.id = 1;
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
      if (rowAndColumn == counter) counter = counterStrike;
      if (counterStrike < numberOfBoxes - 1) counterStrike ++;
      rowAndColumn ++;
    }
  }

  public int getIdBoard(){
    return this.id;
  }

  public boolean squareEvaluations(byte sizeSquare, int positionBox, boolean checked){

    if (sizeSquare == 1){
      if (boxes[positionBox].getStatusBox() != "FREE") checked = false;
    }
    else{ //sera general para todos las dimensiones de los cuadrados
      int positionBoxDown = positionBox + dimension;
      int referenceBox = positionBoxDown;
      byte counterExit = 1;
      exit:
      while(counterExit < sizeSquare){
        byte counterJump = 1;
        while(counterJump < sizeSquare){
          if(positionBoxDown >= numberOfBoxes || neighborhood[positionBox][positionBox + 1] == false){
            checked = false;
            break exit;
          }
          else{
            if(boxes[positionBox].getStatusBox() == "FREE" && boxes[positionBox + 1].getStatusBox() == "FREE" && boxes[positionBoxDown].getStatusBox() == "FREE"){
              positionBox ++;
              positionBoxDown ++;
            }
            else{
              checked = false;
              break exit;
            }
          }
          counterJump ++;
        }

        if (counterExit == sizeSquare - 1){
          positionBoxDown ++;
          if (boxes[positionBoxDown].getStatusBox() != "FREE") checked = false;
        }
        counterExit ++;
        positionBox = referenceBox;
        positionBoxDown = referenceBox + dimension;
        referenceBox = positionBoxDown;
      }
    }
    return checked;
  }

  public boolean lineEvaluations(byte sizeLine, int positionBox, int answer, boolean checked){

    byte counterExit = 1;

      if(answer == 1){
        while(counterExit < sizeLine){
          if(positionBox >= numberOfBoxes || neighborhood[positionBox][positionBox + 1] == false){
            checked = false;
            break;
          }
          else{
            if(boxes[positionBox].getStatusBox() == "FREE" && boxes[positionBox + 1].getStatusBox() == "FREE") positionBox ++;
            else{
              checked = false;
              break;
            }
          }
          counterExit ++;
        }
      }
      else{
        while(counterExit < sizeLine){
          if(positionBox >= numberOfBoxes || neighborhood[positionBox + dimension][positionBox] == false){
            checked = false;
            break;
          }
          else{
            if(boxes[positionBox].getStatusBox() == "FREE" && boxes[positionBox + dimension].getStatusBox() == "FREE") positionBox += dimension;
            else{
              checked = false;
              break;
            }
          }
          counterExit ++;
        }
      }
    return checked;
  }

  public boolean checkPositions(Piece piece, int positionBox){
    boolean checked = true;
    //creo que el pivote que definiremos seria un pivote logico, no podemos tener una variable, o no la veo por lo menos.
    String typeOfPiece = piece.getTypePiece();
    byte sizeOfPiece = piece.getSizePiece();
    if (typeOfPiece == "Square") checked = squareEvaluations(sizeOfPiece, positionBox, checked);
    else if (typeOfPiece == "Vertical Line") checked = lineEvaluations(sizeOfPiece, positionBox, 1, checked);
    else if (typeOfPiece == "Horizontal Line") checked = lineEvaluations(sizeOfPiece, positionBox, 2, checked);

    return checked;
  }
}
