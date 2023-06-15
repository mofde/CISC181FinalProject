package cisc181.lab_4;

public class PieceSharkBait extends Piece implements Recruiter, Clone {

    //constructor that calls piece constructor
    public PieceSharkBait(String symbol, String color){
        super(symbol);
        this.color = color;
        this.hidden = false;
    }

    //displays the piece saying shark bait oooh ha haa
    public void speak(){
        System.out.println("Shark bait oooh ha haa!");
    }

    //Displays the valid path for this piece
    public boolean validPath(int startRowIndex, int startColIndex, int finalRowIndex, int finalColIndex){
        if ((startRowIndex == finalRowIndex + 2 || startRowIndex == finalRowIndex - 2)&& (startColIndex == finalColIndex - 2 || startColIndex == finalColIndex + 2)) {
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

    public void cloning(int startRowIndex, int startColIndex) {
        speak();
    }
}
