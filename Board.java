package cisc181.lab_4;

public class Board {

    //fields
    private int numRows;
    private int numCols;
    public BoardSpace[][] spaces;

    //constructor (creates spaces array)
    public Board(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        spaces = new BoardSpace[numRows][numCols];
        setUpEmptyBoard();
    }

    //accessors
    public int getNumRows() {
        return numRows; }
    public int getNumColumns() {
        return numCols; }
    public BoardSpace[][] getSpaces() {
        return spaces; }

    //checks if the parameters for row and column index are within the bounds of the array
    public boolean inBounds(int rowIndex, int colIndex) {
        if (rowIndex > numRows -1  || rowIndex < 0) {
            return false ;
        } if (colIndex > numCols -1  || colIndex < 0) {
            return false;
        } else {
            return true;
        }
    }

    //fills each space on the board with a BoardSpace object
    // if statements in order to alternate colors
/*
    public void setUpEmptyBoard() {
        for (int rowIndex = 0; rowIndex < (numRows ); rowIndex++) {
            for (int colIndex = 0; colIndex < (numCols ); colIndex++) {
                if (rowIndex % 2 == 0) {
                    if (colIndex % 2 == 0) {
                        BoardSpace boardSpacePiece = new BoardSpace(rowIndex, colIndex, "Black");
                        boardSpacePiece.row = rowIndex;
                        boardSpacePiece.col = colIndex;
                        boardSpacePiece = spaces[rowIndex][colIndex];
                    }
                    if (colIndex % 2 == 1) {
                        BoardSpace boardSpacePiece2 = new BoardSpace(rowIndex, colIndex, "White");
                        boardSpacePiece2.row = rowIndex;
                        boardSpacePiece2.col = colIndex;
                        boardSpacePiece2 = spaces[rowIndex][colIndex];
                    }
                }
                if (rowIndex % 2 == 1) {
                    if (colIndex % 2 == 1) {
                        BoardSpace boardSpacePiece3 = new BoardSpace(rowIndex, colIndex, "Black");
                        boardSpacePiece3.row = rowIndex;
                        boardSpacePiece3.col = colIndex;
                        boardSpacePiece3 = spaces[rowIndex][colIndex];
                    }

                    if (colIndex % 2 == 0) {
                        BoardSpace boardSpacePiece4 = new BoardSpace(rowIndex, colIndex, "White");
                        boardSpacePiece4.row = rowIndex;
                        boardSpacePiece4.col = colIndex;
                        boardSpacePiece4 = spaces[rowIndex][colIndex];
                    }
                }
            }
        }
    }

 */

    public void setUpEmptyBoard(){
        // set up all spots on board - alternate colors with black and white
        // by default a space is empty
        boolean black = true;
        for(int row = 0; row < spaces.length; row++) {
            for (int col = 0; col < spaces[row].length; col++) {
                black = !black;
                spaces[row][col] = new BoardSpace(row,col,(black ? "Black" : "White"));;
                //System.out.println(spaces[row][col].getPiece().toString());
            }
        }
    }


    //using math.random to generate a random location on the board, then continuing the loop
    //until an empty space is found
    //once an empty space is found, the empty board space is returned
    public BoardSpace findRandomEmptySpace() {
        int newRowIndex = (int) Math.round(Math.random() * (this.numRows -1 ));
        int newColIndex = (int) Math.round(Math.random() * (this.numCols -1));
        while (spaces[newRowIndex][newColIndex].isEmpty() == false){
                newRowIndex = (int) Math.round(Math.random() * (this.numRows -1));
                newColIndex = (int) Math.round(Math.random() * (this.numCols -1));
        }
        return spaces[newRowIndex][newColIndex];
    }


    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :     ");

        for(int col = 0; col < spaces[0].length; col++){
            boardString.append(col + "       ");
        }
        boardString.append("\n");
        for(int row = 0; row < spaces.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < spaces[row].length; col++){
                boardString.append(spaces[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }



}
