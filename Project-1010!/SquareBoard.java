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

  public boolean squareEvaluations(byte dimensionSquare, int positionBox, boolean checked){

    if (dimensionSquare == 1){
      if (boxes[positionBox].getStatusBox() != "FREE") checked = false;
    }
    else{ //sera general para todos las dimensiones de los cuadrados
      int positionBoxDown = positionBox + dimension;
      int referenceBox = positionBoxDown;
      byte counterExit = 1;
      exit:
      while(counterExit < dimensionSquare){
        byte counterJump = 1;
        while(counterJump < dimensionSquare){
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

        if (counterExit == dimensionSquare - 1){
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

  public boolean lineEvaluations(byte lineSize, int positionBox, int answer, boolean checked){

    byte counterExit = 1;

      if(answer == 1){
        while(counterExit < lineSize){
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
        while(counterExit < lineSize){
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

  public boolean lEvaluation(byte lSize ,int positionBox ,boolean checked){

    int pivot = positionBox;
    byte exitCounter = 0;

    while(exitCounter < lSize){
      if ((positionBox > numberOfBoxes) || (positionBox >= numberOfBoxes - dimension) || (neighborhood[pivot][pivot + 1] == false)){ //falta un condicional
        checked = false;
        break;
      }
      else {
        if (pivot == positionBox){
          if ((boxes[pivot].getStatusBox() == "FREE") && (boxes[pivot + 1].getStatusBox() == "FREE")) pivot += dimension;
          else{
            checked = false;
            break;
          }
        }
        else {
          if (((boxes[pivot].getStatusBox()) == "FREE")) pivot++;
          else{
            checked = false;
            break;
          }
        }
      }
      exitCounter ++;
     }
    return checked;
  }

  public boolean leftLEvaluation(byte sizeOfPiece ,int positionBox ,boolean checked){
      byte exitCounter = 0;
      int counterJump = positionBox - dimension;
      while(exitCounter < sizeOfPiece){

        if ((positionBox <= dimension) || (positionBox > numberOfBoxes) || (neighborhood[counterJump][counterJump + 1] == false)){ //or (neighborhood[][])
          checked = false;
          break;
        }
        else {
          if ((boxes[positionBox].getStatusBox() == "FREE") && (boxes[counterJump + 1].getStatusBox() == "FREE"))positionBox++;
          else{
            checked = false;
            break;
          }

          if (exitCounter == (sizeOfPiece - 1)){
            positionBox -= dimension;
            if ((boxes[positionBox].getStatusBox() == "FREE") && (boxes[positionBox + 1].getStatusBox() == "FREE")) positionBox++;
            else{
              checked = false;
              break;
            }
          }
        }
        exitCounter++;
      }
      return checked;
  }

  public boolean investedLEvaluation(byte sizeOfPiece ,int positionBox ,boolean checked){

    byte exitCounter = 0;
    int upCounter = positionBox - dimension;

    while(exitCounter < sizeOfPiece){
      if (upCounter < 0){
        checked = false;
        break;
      }

      if ((positionBox > numberOfBoxes)){
        checked = false;
        break;
      }
      else {
        if (exitCounter == 0){
          if (neighborhood[upCounter][positionBox] == false){
            checked = false;
            break;
          }
          else{
            if ((boxes[positionBox].getStatusBox() == "FREE") && (boxes[upCounter].getStatusBox() == "FREE")) positionBox -= dimension;
            else {
              checked = false;
              break;
            }
          }
        }
        else {
          if(neighborhood[upCounter][positionBox + 1] == false){
            checked = false;
            break;
          }
          else{
            if (boxes[positionBox + 1].getStatusBox() == "FREE"){
              positionBox ++;
              upCounter++;
            }
            else{
              checked = false;
              break;
            }
          }
        }
      }
      exitCounter ++;
    }
    return checked;

  }

  public boolean leftInvestedLEvaluation(byte sizeOfPiece ,int positionBox ,boolean checked){
    byte exitCounter = 0;
    byte counterJump = 1;

    while (exitCounter < sizeOfPiece){

      if (positionBox > numberOfBoxes){
        checked = false;
        break;
      }
      else {
        if (counterJump == sizeOfPiece - 1){
            if (neighborhood[positionBox][positionBox + dimension] == false){
              checked = false;
              break;
            }
            else {
              if (boxes[positionBox].getStatusBox() == "FREE") positionBox += dimension;
              else {
                checked = false;
                break;
              }
            }

        }
        else if (counterJump < sizeOfPiece -1){
          if (neighborhood[positionBox][positionBox + 1] == false){
            checked = false;
            break;
          }
          else {
            if (boxes[positionBox].getStatusBox() == "FREE") positionBox ++;
            else {
              checked = false;
              break;
            }
          }

        }
        else {
          if (boxes[positionBox].getStatusBox() == "FREE") positionBox ++;
          else{
            checked = false;
            break;
          }

        }
        counterJump++;
        exitCounter++;
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
    else if (typeOfPiece == "L") checked = lEvaluation(sizeOfPiece , positionBox, checked);
    else if (typeOfPiece == "L hacia la izquierda") checked = leftLEvaluation(sizeOfPiece ,positionBox ,checked);
    else if (typeOfPiece == "L invertida") checked = investedLEvaluation(sizeOfPiece ,positionBox ,checked);
    else checked = leftInvestedLEvaluation(sizeOfPiece ,positionBox ,checked);
    return checked;
  }
}
/*pequeno detalle por arreglar */
