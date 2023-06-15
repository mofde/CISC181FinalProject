package cisc181.lab_4;

import java.util.ArrayList;

public class Team {

    protected String teamName;
    protected String teamColor;
    protected ArrayList<Piece> teamPieces = new ArrayList<Piece>();
    protected int teamPoints;

    //Constructor
    public Team(String teamName, String teamColor, ArrayList<Piece> teamPieces){
        this.teamName = teamName;
        this.teamColor = teamColor;
        this.teamPieces = teamPieces;
        this.teamPoints = 0;
    }

    //Accessors
    public String getTeamName() {
        return teamName;
    }
    public String getTeamColor() {
        return teamColor;
    }
    public ArrayList<Piece> getTeamPieces() {
        return teamPieces;
    }

    //mutator methods
    public void removePieceFromTeam (Piece removedPiece){
        teamPieces.remove(teamPieces.indexOf(removedPiece));
    }
    public void addPieceToTeam(Piece addedPiece){
        addedPiece.color = teamColor;
        teamPieces.add(addedPiece);
    }

    //toString method for printing team name, color, and pieces
    @Override
    public String toString() {
        String list = "";
        for (int i = 0; i < teamPieces.size(); ++i) {
            list = list + " " + teamPieces.get(i).toString();
        }
        return ("Team " + teamName + " : " + teamColor + "\n" + "Pieces :" + list);
    }

    public int getTeamPoints() {
        return teamPoints;
    }

    public void addTeamPoints(int teamPoints) {
        this.teamPoints = this.teamPoints + teamPoints;
    }
}
