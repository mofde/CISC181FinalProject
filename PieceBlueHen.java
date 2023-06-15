package cisc181.lab_4;

public class PieceBlueHen extends PieceEggLaying implements Attacker {

    private int numAttacked;
    private boolean fly;

    public PieceBlueHen(String symbol, String color, int numEggs, int numAttacked){
        super(symbol,color, numEggs);
        this.numAttacked = numAttacked;
        this.hidden = false;
        updateFly();
    }
    // constructor for when color information not available yet
    // and brand new piece that hasn’t laid eggs and hasn’t attacked
    public PieceBlueHen(String symbol){
        this(symbol,"",0,0);
    }

    //displays the blue hen saying go ud
    public void speak(){
        System.out.println("Go UD!");
    }

    //accessor for numAttacked
    public int getNumAttacked()  {
        return this.numAttacked;
    }

    //accessor for fly
    public boolean canFly () {
        return this.fly;
    }

    //uses pieceEggLaying to increase numEggs, then updates fly
    public void incrementNumEggs( ){
        super.incrementNumEggs();
        updateFly();
    }

    //increases numAttacked by 1 each time its called
    public void incrementNumAttacked( ){
        this.numAttacked++;
        updateFly();
    }

    //Displays the valid path for this piece
    public boolean validPath(int startRowIndex, int startColIndex, int finalRowIndex, int finalColIndex) {
        if (fly) {
            return true;
        } else {
            if ((startRowIndex == finalRowIndex + 1 || startRowIndex == finalRowIndex - 1) && (startColIndex == finalColIndex)) {
                return true;
            }
            if ((startColIndex == finalColIndex + 1 || startColIndex == finalColIndex - 1) && (startRowIndex == finalRowIndex)) {
                return true;
            } else {
                return false;
            }
        }
    }

    //increases numAttacked and displays the blue hen attacking with claws
    public void attack(int startRowIndex, int startColIndex, int attackRow, int attackCol){
        this.incrementNumAttacked();
        speak();
        System.out.println("Attack with claws!!");
    }

    //if this piece hasn't laid max eggs yet - allow it create new piece
    public PieceBlueHen layEgg(){
        // if this piece hasn't laid max eggs yet - allow it create new piece
        if( this.numEggs < MAX_EGGS){
            this.incrementNumEggs();
            // creates a new piece that has the same number of eggs laid and attacked pieces
            // as this piece
            return new PieceBlueHen(this.symbol,this.color,this.numEggs,this.numAttacked);
        }
        else{
            return null;
        }
    }

    //updates the ability to fly based on numEggs and numattacked
    private void updateFly( ) {
        if (this.numAttacked == 0) {
            this.fly = true;
        } else {
            this.fly = false;
        }
    }

}
