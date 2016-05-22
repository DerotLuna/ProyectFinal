import java.awt.Color;

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

  public boolean checkPositions(Piece piece, int positionBox){
    boolean checked = true;
    //creo que el pivote que definiremos seria un pivote logico, no podemos tener una variable, o no la veo por lo menos.
    String typePiece = piece.getTypePiece();
    byte sizePiece = piece.getSizePiece();
    Color color = piece.getColorPiece();
    if (typePiece == "Square") checked = squareEvaluations(sizePiece, positionBox, checked);
    else if (typePiece == "Vertical Line") checked = lineEvaluations(sizePiece, positionBox, 2, checked);
    else if (typePiece == "Horizontal Line") checked = lineEvaluations(sizePiece, positionBox, 1, checked);
    if (checked == true){
      addPiece(typePiece, sizePiece, positionBox , color);
    }
    return checked;
  }

  public boolean squareEvaluations(byte sizeSquare, int positionBox, boolean checked){
    String status = "FREE";

    if (sizeSquare == 1){
      if (boxes[positionBox].getStatusBox() != status) checked = false;
    }
    else{ //sera general para todos las dimensiones de los cuadrados
      int positionBoxDown = positionBox + dimension;
      int referenceBox = positionBoxDown;
      byte counterExit = 1;
      exit:
      while(counterExit < sizeSquare){
        byte counterJump = 1;
        while(counterJump < sizeSquare){
          if(positionBoxDown >= numberOfBoxes || !neighborhood[positionBox][positionBox + 1]){
            checked = false;
            break exit;
          }
          else{
            if(boxes[positionBox].getStatusBox() == status && boxes[positionBox + 1].getStatusBox() == status && boxes[positionBoxDown].getStatusBox() == status){
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
          if (boxes[positionBoxDown].getStatusBox() != status) checked = false;
        }
        counterExit ++;
        positionBox = referenceBox;
        positionBoxDown = referenceBox + dimension;
        referenceBox = positionBoxDown;
      }
    }
    return checked;
  }

  public boolean lineEvaluations(byte sizeLine, int positionBox, int option, boolean checked){
    String status = "FREE";
    byte counterExit = 1;

      if(option == 1){
        while(counterExit < sizeLine){
          if(positionBox >= numberOfBoxes || !neighborhood[positionBox][positionBox + 1]){
            checked = false;
            break;
          }
          else{
            if(boxes[positionBox].getStatusBox() == status && boxes[positionBox + 1].getStatusBox() == status) positionBox ++;
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
          if(positionBox >= numberOfBoxes || !neighborhood[positionBox + dimension][positionBox]){
            checked = false;
            break;
          }
          else{
            if(boxes[positionBox].getStatusBox() == status && boxes[positionBox + dimension].getStatusBox() == status) positionBox += dimension;
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

  private void addSquare(byte sizeSquare, int positionBox, Color color){
    Status fullBox = new FullBox();
    if(sizeSquare == 1){
      boxes[positionBox].setStatus(fullBox);
      boxes[positionBox].setColorBox(color);
    }
    else{
      int positionBoxDown = positionBox + dimension;
      byte counterExit = 1;
      while(counterExit <= sizeSquare){
        byte counterJump = 1;
        while(counterJump <= sizeSquare){
          boxes[positionBox].setStatus(fullBox);
          boxes[positionBox].setColorBox(color);
          counterJump ++;
          positionBox++;
        }
        positionBox = positionBoxDown;
        positionBox += dimension;
        counterExit ++;
      }
    }
  }

  private void addLine(byte sizeLine, int positionBox, int answer, Color color){
    Status fullBox = new FullBox();
    byte counterExit = 1;
    while(counterExit <= sizeLine){
      boxes[positionBox].setStatus(fullBox);
      boxes[positionBox].setColorBox(color);
      counterExit ++;
      if(answer == 1)  positionBox++;
      else positionBox += dimension;
    }
  }

  private void addL(byte sizeL, int positionBox, Color color){

  }

  public void addPiece(String typePiece, byte sizePiece,int positionBox ,Color color){
    if (typePiece == "Square") addSquare(sizePiece, positionBox, color);
    else if (typePiece == "Vertical Line") addLine(sizePiece, positionBox, 1, color);
    else if (typePiece == "Horizontal Line") addLine(sizePiece, positionBox, 2, color);
  }

  public void liberateBoxes(int [] delete, byte storedElements, int option){
    Status freeBox = new FreeBox();
    int counterExit = 0, positionBox = 0;
    if(option == 1){ //aqui liberamos casillas en fila
      while(counterExit <= storedElements){
        byte counterJump = 0;
        positionBox = delete[counterExit];
        while(counterJump < dimension){
          boxes[positionBox].setStatus(freeBox);
          positionBox ++;
          counterJump ++;
        }
        counterExit ++;
      }
    }
    else{ //aqui liberamos casillas en columna
      int finalBox = ((numberOfBoxes) - dimension) + delete[0];
      while(counterExit <= storedElements){
        if (counterExit != 0) finalBox += delete[counterExit] - delete[counterExit - 1];
        positionBox = delete[counterExit];

        while(positionBox <= finalBox){
          boxes[positionBox].setStatus(freeBox);
          positionBox += dimension;
        }
        counterExit ++;
      }
    }
  }

  public int deleteRowColumn(){
    int[] deleteRows = new int[dimension]; //almacenador de la primera casilla de la fila a eliminar
    int[] deleteColumns = new int[dimension]; //almacenador de la primera casilla de la columna a eliminar
    byte positionDeleteRows = 0, positionBoxDown = dimension, positionBox = 0, rowColumn = 0;
    String status = "FULL";
    while(positionBox < numberOfBoxes){ //evaluo todas las filas
      if(boxes[positionBox].getStatusBox() != status){
        //salto hacia la siguiente fila si en la fila que estoy hay una casilla libre
        positionBox = positionBoxDown;
        positionBoxDown += dimension;
        rowColumn = positionBox;
      }
      else{
        if(positionBox == positionBoxDown - 1){
          deleteRows[positionDeleteRows] = rowColumn;
          positionDeleteRows ++;
          rowColumn = positionBoxDown;
          positionBoxDown += dimension;
        }
        positionBox ++;
      }
    }

    positionBox = 0; rowColumn = 0;
    byte positionBoxNext = (byte) (positionBox + 1), positionDeleteColumns = 0; int finalBox = (numberOfBoxes) - dimension;
    while(rowColumn < dimension && positionBox < numberOfBoxes){ //evaluo todas las columnas
      if(boxes[positionBox].getStatusBox() != status){
        //salto hacia la siguiente fila si en la fila que estoy hay una casilla libre
        positionBox = positionBoxNext;
        positionBoxNext ++;
        rowColumn ++;
        finalBox ++;
      }
      else{
        if(positionBox == finalBox){
          deleteColumns[positionDeleteColumns] = rowColumn;
          positionDeleteColumns ++;
          rowColumn ++;
          positionBoxNext ++;
          finalBox ++;
        }
        positionBox += dimension;
      }
    }

    int deleteRowsColumns = positionDeleteRows + positionDeleteColumns;
    if (deleteRowsColumns != 0) {
      liberateBoxes(deleteRows, positionDeleteRows, 1);
      liberateBoxes(deleteColumns, positionDeleteColumns, 2);
      deleteRowsColumns ++;
    }

    return deleteRowsColumns;
  }
}
