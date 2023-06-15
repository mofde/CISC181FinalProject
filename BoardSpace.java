package cisc181.lab_4;
public class BoardSpace {

    //fields
    public int row;
    public int col;
    public String color;
    public boolean isEmpty;
    public Piece thisPiece;

    //Constructor
    public BoardSpace(int row, int col, String color){
        this.row = row;
        this.col = col;
        this.color = color;
        this.isEmpty = true;
    }

    //accessors
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return col;
    }
    public Piece getPiece() {
        return thisPiece;
    }
    public String getSpaceColor() {
        return color;
    }
    public boolean isEmpty() {
        return isEmpty;
    }

    //mutator
    public void setPiece(Piece thisPiece) {
        this.thisPiece = thisPiece;
        this.isEmpty = false;
    }
    public Piece removePiece() {
        Piece currPiece = this.thisPiece;
        this.thisPiece = null;
        this.isEmpty = true;
        return currPiece;
    }

    //overriding toString
    public String toString(){
        if (isEmpty == true){
            return "------";
        }
        else{
            return thisPiece.toString();
        }
    }

}
