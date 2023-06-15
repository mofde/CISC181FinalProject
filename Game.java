package cisc181.lab_4;

import java.util.Collections;

public abstract class Game {

    //member fields
    protected Board theBoard;
    protected Team team1;
    protected Team team2;
    protected String turn;

    public Board initializeGameBoard(int numRows, int numCols){
        this.theBoard = new Board(numRows, numCols);
        for (int i = 0; i < team1.teamPieces.size(); ++i) {
            theBoard.findRandomEmptySpace().setPiece(team1.teamPieces.get(i));
        }
        for (int i = 0; i < team2.teamPieces.size(); ++i) {
            theBoard.findRandomEmptySpace().setPiece(team2.teamPieces.get(i));
        }
        return theBoard;
    }

    //Constructor
    public Game(int numRows, int numCols, Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
        turn = team1.getTeamName();
        initializeGameBoard(numRows, numCols);
    }

    //accessors
    public Board getBoard() {
        return this.theBoard;
    }

    /*
    public Team getCurrentTeam() {
        return this.team1;
    }

    public Team getOpponentTeam() {
        return this.team2;
    }

    public boolean isTurn(Team isTeam) {
        return (isTeam == getCurrentTeam());
    }

     */

    public Team getCurrentTeam(){
       return team1.getTeamName().equals(turn)? team1 : team2;
   }
    public Team getOpponentTeam(){
        return team1.getTeamName().equals(turn)? team2 : team1;
    }

    public boolean isTurn(Team team) {
        return team.getTeamName().equals(turn);
    }

    //mutator
    public void changeTurn(){
        this.turn = getOpponentTeam().getTeamName();
        /*
        if (isTurn(team1)){
            return team2.getTeamName();
        }
        else {
            return team1.getTeamName();
        }
    }
         */
    }

    //abstract methods
    public abstract boolean isAWinner();
    public abstract Team getWinner();
    public abstract boolean isGameEnded();


    public String toString() {
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\n" + getBoard().toString())
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\nIt is Team " + getCurrentTeam().getTeamName() + "'s turn\n");
        return retString.toString();
    }

}
