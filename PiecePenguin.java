package cisc181.lab_4;

public class PiecePenguin extends PieceEggLaying implements Attacker, Recruiter {

    private int numAttacked;

    //Constructor
    public PiecePenguin(String symbol, String color, int numEggs, int numAttacked) {
        super(symbol, color, numEggs);
        this.numAttacked = numAttacked;
        this.hidden = false;
    }

    // constructor for when color information not available yet
    public PiecePenguin(String symbol) {
        this(symbol, "", 0, 0);
    }

    //speak method should print Smile and wave boys
    public void speak(){
        System.out.println("Smile and wave boys. Smile and wave.");
    }

    //Displays the valid path for this piece
    public boolean validPath(int startRowIndex, int startColIndex, int finalRowIndex, int finalColIndex){
        if ((startRowIndex == finalRowIndex) &&(startColIndex != finalColIndex)){
                return true;
            }
        if((startRowIndex == finalRowIndex + 1 || startRowIndex == finalRowIndex -1)&&(startColIndex == finalColIndex)){
                return true;
            }
        else{
            return false;
            }
    }

    //increases the numAttacked and displays attack ~with lasers~
    public void attack(int startRowIndex, int startColIndex, int attackRow, int attackCol){
        this.numAttacked++;
        speak();
        System.out.println("Attack with lasers!!");
    }

    //displays that a member of the other team has been traded to this team
    public void recruit(int startRowIndex, int startColIndex, int recruitRow, int recruitCol){
        speak();
        System.out.println("You're on my team now!");
    }

    //if this piece hasn't laid max eggs yet - allow it create new piece
    public PiecePenguin layEgg(){
        // if this piece hasn't laid max eggs yet - allow it create new piece
        if( this.numEggs < MAX_EGGS){
            this.incrementNumEggs();
            // this creates a new piece that has not laid any eggs
            // and has not attacked any pieces yet it will belong to this team so pass in Color
            return new PiecePenguin(this.symbol, this.color,0,0);
        }
        else{
            return null;
        }
    }


    //accessor for numAttacked
    public int getNumAttacked()  {
        return this.numAttacked;
    }

    //mutator for numAttacked (increased by 1)
    public void incrementNumAttacked( ){
        this.numAttacked++;
    }

}
