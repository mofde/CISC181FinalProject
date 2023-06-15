package cisc181.lab_4;

import java.util.ArrayList;

public class ActionClone extends Action {

    // constructor

    public ActionClone(Game181 game, int fromRow, int fromCol){
        super(game, fromRow,fromCol,0,0);
    }

    // Check to see if this is valid Recruit Action
    public boolean validAction() {
        // check if from space valid
        if(fromSpaceValid() ) {
            // get the piece that is in the from BoardSpace
            Piece fromPiece = game.getBoard().getSpaces()
                    [fromRow][fromCol].getPiece();
            // check to see if this piece has implemented the Cloner interface
            if ((game.getCurrentTeam().getTeamPieces().size() < game.getOpponentTeam().getTeamPieces().size())&& (Clone.class.isAssignableFrom(fromPiece.getClass()))){
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
    // this method calls the Piece's clone method
    private void cloning() {
        // Get the piece that is in the fromSpace
        Piece pieceToClone = game.getBoard().getSpaces()[fromRow][fromCol].getPiece();
        if (pieceToClone instanceof PieceSharkBait) {
            ((PieceSharkBait) pieceToClone).cloning(fromRow, fromCol);
        } else if (pieceToClone instanceof PieceSquirrel) {
            ((PieceSquirrel) pieceToClone).cloning(fromRow, fromCol);
        }
    }

    public void performAction(){
        cloning();
        Piece clonedPiece = game.getBoard().getSpaces()[fromRow][fromCol].getPiece();
        int col = game.getBoard().findRandomEmptySpace().getColumn();
        int row = game.getBoard().findRandomEmptySpace().getRow();
        if (clonedPiece instanceof PieceSharkBait) {
            PieceSharkBait clone = new PieceSharkBait(clonedPiece.getSymbol(), clonedPiece.getColor());
            game.getBoard().getSpaces()[row][col].setPiece(clone);
            game.getCurrentTeam().addPieceToTeam(clone);
        } else if (clonedPiece instanceof PieceSquirrel) {
            PieceSquirrel clone = new PieceSquirrel(clonedPiece.getSymbol(), clonedPiece.getColor());
            game.getBoard().getSpaces()[row][col].setPiece(clone);
            game.getCurrentTeam().addPieceToTeam(clone);
        }
        game.getCurrentTeam().addTeamPoints(2);
        System.out.println(clonedPiece + " has a clone on row " + row + " col " + col);
        game.changeTurn();
    }

    public void performActionSb(){
        cloning();
        PieceSharkBait clonedPiece = (PieceSharkBait) game.getBoard().getSpaces()[fromRow][fromCol].getPiece();
        PieceSharkBait clone = new PieceSharkBait(clonedPiece.getSymbol(), clonedPiece.getColor());
        int col = game.getBoard().findRandomEmptySpace().getColumn();
        int row = game.getBoard().findRandomEmptySpace().getRow();
        game.getBoard().getSpaces()[row][col].setPiece(clone);
        game.getCurrentTeam().addPieceToTeam(clone);
        game.getCurrentTeam().addTeamPoints(2);
        System.out.println(clonedPiece + " has a clone on row " + row + " col " + col);
        game.changeTurn();
    }

}
