package cisc181.lab_4;

public class PieceButterfly extends PieceEggLaying implements Recruiter {

    private int numAttacked;

    //constructor that calls piece constructor
    public PieceButterfly(String symbol, String color, int numEggs, int numAttacked) {
        super(symbol, color, numEggs);
        this.numAttacked = numAttacked;
        this.hidden = false;
    }

    //displays the piece saying shark bait oooh ha haa
    public void speak(){
        System.out.println("Fly, butterfly, fly!");
    }

    //Displays the valid path for this piece
    public boolean validPath(int startRowIndex, int startColIndex, int finalRowIndex, int finalColIndex){
        if ((startRowIndex == finalRowIndex + 2 || startRowIndex == finalRowIndex - 2)&& (startColIndex == finalColIndex - 2 || startColIndex == finalColIndex + 2)) {
            return true;
        }
        else if ((startRowIndex == finalRowIndex + 1 || startRowIndex == finalRowIndex - 1)&& (startColIndex == finalColIndex)){
            return true;
        }
        else if ((startColIndex == finalColIndex + 1 || startColIndex == finalColIndex - 1)&& (startRowIndex == finalRowIndex)) {
            return true;
        }
        else {
            return false;
        }
    }

    //displays that a member of the other team has been traded to this team
    public void recruit(int startRowIndex, int startColIndex, int recruitRow, int recruitCol){
        speak();
        System.out.println("You're on my team now!");
    }

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


}





