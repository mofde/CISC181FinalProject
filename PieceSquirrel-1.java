package cisc181.lab_4;

public class PieceSquirrel extends Piece implements Attacker,Clone {

    int numAttacked;

    //constructor that calls piece constructor
    public PieceSquirrel(String symbol, String color){
        super(symbol);
        this.color = color;
        this.hidden = false;
        this.numAttacked = 0;
    }

    public void speak() {
        System.out.println("Squirrel power!");
    }

    //Displays the valid path for this piece
    public boolean validPath(int startRowIndex, int startColIndex, int finalRowIndex, int finalColIndex){
        if ((startColIndex == finalColIndex + 1|| startColIndex == finalColIndex - 1) && (startRowIndex == finalRowIndex)){
            return true;
        }
        else if (startColIndex == finalColIndex && startRowIndex != finalRowIndex){
            return true;
        }
        else {
            return false;
        }
    }

    public void incrementNumAttacked( ){
        this.numAttacked++;
    }

    public void attack(int startRowIndex, int startColIndex, int attackRow, int attackCol){
        this.incrementNumAttacked();
        speak();
    }

    public void cloning(int startRowIndex, int startColIndex) {
        speak();
    }
}







