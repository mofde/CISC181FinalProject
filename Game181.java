package cisc181.lab_4;

public class Game181 extends Game{

    BoardSpace mystery;

    public Game181(int numRows, int numCols, Team team1, Team team2){
        super(numRows, numCols, team1, team2);
        mystery = theBoard.findRandomEmptySpace();
    }

    public boolean isAWinner() {
        if (isGameEnded() == true) {
            if (team1.getTeamPoints() != team2.getTeamPoints()) {
                return true;
            }
        }
        return false;
    }

    public Team getWinner() {
        if(isAWinner() == true){
            if (team1.getTeamPoints() > team2.getTeamPoints()){
                return team1;
            }
            else{
                return team2;
            }
        }
        return null;
    }

    public Team getLoser() {
        if(isAWinner() == true){
            if (getWinner() == team2){
                return team1;
            }
            else{
                return team2;
            }
        }
        return null;
    }

    public boolean isGameEnded(){
        if (team1.teamPieces.isEmpty() == true || team2.teamPieces.isEmpty() == true ) {
            return true;
        }
        else{
            return false;
        }
    }

    public void mysterySpace(){
        getCurrentTeam().removePieceFromTeam(mystery.getPiece());
        getOpponentTeam().addPieceToTeam(mystery.getPiece());
    }

}
