package cisc181.lab_4;
import java.util.Scanner;
import java.util.ArrayList;

public class PlayGame {

    public Game181 theGame;

    public PlayGame(Game181 theGame){
        this.theGame = theGame;
    }

    private char getValidActionType(){
        System.out.println("Type \'M\' to move your piece.");
        System.out.println("Type \'R\' to recruit your opponent's piece.");
        System.out.println("Type \'A\' to attack your opponent's piece.");
        System.out.println("Type \'C\' to clone your piece.");
        Scanner scnr = new Scanner(System.in);
        String userInput = scnr.next();
        while (!(userInput.charAt(0)== 'M' || userInput.charAt(0)== 'R' || userInput.charAt(0)== 'A'|| userInput.charAt(0)== 'C')){
            System.out.print("Type \'M\', \'R\', \'A\', or \'C\'.");
            userInput = scnr.next();
        }
        return userInput.charAt(0);
    }

    public void nextPlayersAction(){
        System.out.println(theGame.getCurrentTeam());
        System.out.println("Current score: Team " + theGame.getCurrentTeam().getTeamName() + ": " + theGame.getCurrentTeam().getTeamPoints() + " points and Team " + theGame.getOpponentTeam().getTeamName() + ": " + theGame.getOpponentTeam().getTeamPoints() + " points");
        boolean valid = true;
        while (valid) {
            char actionType = getValidActionType();
            if (actionType == 'C'){
                System.out.println("Enter the row and column index of the starting space.");
                Scanner scnr = new Scanner(System.in);
                int fromRow = scnr.nextInt();
                //System.out.println("Enter the column index of the starting space.");
                int fromCol = scnr.nextInt();
                ActionClone newClone = new ActionClone(theGame, fromRow, fromCol);
                boolean validAction = newClone.validAction();
                if (validAction) {
                    if (theGame.getBoard().getSpaces()[fromRow][fromCol].getPiece() instanceof PieceSquirrel){

                    }
                    newClone.performAction();
                    valid = false;
                } else {
                    System.out.println("Invalid action");
                }
            }
            else{
                System.out.println("Enter the row and column index of the starting space.");
                Scanner scnr = new Scanner(System.in);
                int fromRow = scnr.nextInt();
                //System.out.println("Enter the column index of the starting space.");
                int fromCol = scnr.nextInt();
                System.out.println("Enter the row and column index of the ending space.");
                int toRow = scnr.nextInt();
                //System.out.println("Enter the column index of the ending space.");
                int toCol = scnr.nextInt();
                if (actionType == 'M') {
                    ActionMove newMove = new ActionMove(theGame, fromRow, fromCol, toRow, toCol);
                    boolean validAction = newMove.validAction();
                    if (validAction) {
                        newMove.performAction();
                        if (!(toRow == theGame.mystery.getRow() && toCol == theGame.mystery.getColumn())){
                            nonMove(toRow, toCol);
                        }
                        valid = false;
                    }
                    else{
                        System.out.println("Invalid action");
                    }
                } else if (actionType == 'R') {
                    ActionRecruit newRecruit = new ActionRecruit(theGame, fromRow, fromCol, toRow, toCol);
                    boolean validAction = newRecruit.validAction();
                    if (validAction) {
                        newRecruit.performAction();
                        valid = false;
                    }
                    else{
                        System.out.println("Invalid action");
                    }
                } else if (actionType == 'A') {
                    ActionAttack newAttack = new ActionAttack(theGame, fromRow, fromCol, toRow, toCol);
                    boolean validAction = newAttack.validAction();
                    if (validAction) {
                        newAttack.performAction();
                        valid = false;
                    } else {
                        System.out.println("Invalid action");
                    }
                }
            }
        }
    }
    private char getNonMoveActionType(){
        System.out.println("Type \'R\' to recruit your opponent's piece.");
        System.out.println("Type \'A\' to attack your opponent's piece.");
        System.out.println("Type \'C\' to clone your piece.");
        Scanner scnr = new Scanner(System.in);
        String userInput = scnr.next();
        while (!(userInput.charAt(0)== 'R' || userInput.charAt(0)== 'A'|| userInput.charAt(0)== 'C')){
            System.out.print("Type \'R\', \'A\', or \'C\'.");
            userInput = scnr.next();
        }
        return userInput.charAt(0);
    }

    public void nonMove(int PieceRow, int PieceCol){
        theGame.changeTurn();
        System.out.println(theGame.getCurrentTeam());
        System.out.println("You have one more chance for " + theGame.getBoard().getSpaces()[PieceRow][PieceCol].getPiece() + " to move, attack, recruit, or clone!");
        boolean valid = true;
        Piece yourTurn = theGame.getBoard().spaces[PieceRow][PieceCol].getPiece();
        while (valid) {
            char actionType = getValidActionType();
            if (actionType == 'C') {
                /*
                System.out.println("Enter the row and column index of the starting space.");
                Scanner scnr = new Scanner(System.in);
                int fromRow = scnr.nextInt();
                //System.out.println("Enter the column index of the starting space.");
                int fromCol = scnr.nextInt();
                if (fromRow == PieceRow && fromCol == PieceCol) {

                 */
                ActionClone newClone = new ActionClone(theGame, PieceRow, PieceCol);
                boolean validAction = newClone.validAction();
                if (validAction) {
                    newClone.performAction();
                    valid = false;
                } else {
                    System.out.println("Invalid action");
                }
                /*} else {
                    System.out.println("Only the piece you moved last can complete the action.");
                }
                 */
            } else {
                //System.out.println("Enter the row and column index of the starting space.");
                Scanner scnr = new Scanner(System.in);
                //int fromRow = scnr.nextInt();
                //System.out.println("Enter the column index of the starting space.");
                //int fromCol = scnr.nextInt();
                if (actionType == 'R') {
                    System.out.println("Enter the row and column index where " + theGame.getBoard().getSpaces()[PieceRow][PieceCol].getPiece() + " should recruit.");
                    int toRow = scnr.nextInt();
                    int toCol = scnr.nextInt();
                    ActionRecruit newRecruit = new ActionRecruit(theGame, PieceRow, PieceCol, toRow, toCol);
                    boolean validAction = newRecruit.validAction();
                    if (validAction) {
                        newRecruit.performAction();
                        valid = false;
                    } else {
                        System.out.println("Invalid action");
                    }
                } else if (actionType == 'A') {
                    System.out.println("Enter the row and column index where " + theGame.getBoard().getSpaces()[PieceRow][PieceCol].getPiece() + " should attack.");
                    int toRow = scnr.nextInt();
                    int toCol = scnr.nextInt();
                    ActionAttack newAttack = new ActionAttack(theGame, PieceRow, PieceCol, toRow, toCol);
                    boolean validAction = newAttack.validAction();
                    if (validAction) {
                        newAttack.performAction();
                        valid = false;
                    } else {
                        System.out.println("Invalid action");
                    }
                }
                else if (actionType == 'M') {
                    System.out.println("Enter the row and column index where " + theGame.getBoard().getSpaces()[PieceRow][PieceCol].getPiece() + " should move.");
                    int toRow = scnr.nextInt();
                    int toCol = scnr.nextInt();
                    ActionMove newMove = new ActionMove(theGame, PieceRow, PieceCol, toRow, toCol);
                    boolean validAction = newMove.validAction();
                    if (validAction) {
                        newMove.performAction();
                        valid = false;
                    }
                }
            }
        }
    }


    public void playOurGame(){
        nextPlayersAction();
        System.out.println(theGame);
        boolean gameOver = theGame.isGameEnded();
        while (!gameOver){
            nextPlayersAction();
            System.out.println(theGame);
            gameOver = theGame.isGameEnded();
        }
        System.out.println("The game has ended.");
        if (theGame.isAWinner()){
            System.out.println("The winner is: team " + theGame.getWinner().getTeamName());
            System.out.println("Final score: team " + theGame.getWinner().getTeamName() + ": " +
                    theGame.getWinner().getTeamPoints() + " team " + theGame.getLoser().getTeamName() + ": " + theGame.getLoser().getTeamPoints());
        }
    }

    public static void main(String[] args) {

        // Create 3 pieces for Team A
        Piece nemoA = new PieceSharkBait("Nemo","Red");
        Piece blueHenA = new PieceBlueHen("Hen ","Red",0,0);
        Piece penguinA = new PiecePenguin("Peng","Red",0,0);
        Piece squirrelA = new PieceSquirrel("Sqrl", "Red");
        Piece butterflyA = new PieceButterfly("Bfly", "Red", 0, 0);
        // Create an array list to hold Team A's pieces
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(nemoA);
        piecesTeamA.add(blueHenA);
        piecesTeamA.add(penguinA);
        piecesTeamA.add(squirrelA);
        piecesTeamA.add(butterflyA);
        // Create 3 pieces for Team B
        Piece nemoB = new PieceSharkBait("Nemo","Green");
        Piece blueHenB = new PieceBlueHen("Hen ","Green",0,0);
        Piece penguinB = new PiecePenguin("Peng","Green",0,0);
        Piece squirrelB = new PieceSquirrel("Sqrl", "Green");
        Piece butterflyB = new PieceButterfly("Bfly", "Green", 0, 0);

        // Create an array list to hold Team B&#39;s pieces
        ArrayList<Piece> piecesTeamB = new ArrayList<>();

        piecesTeamB.add(nemoB);
        piecesTeamB.add(blueHenB);
        piecesTeamB.add(penguinB);
        piecesTeamB.add(squirrelB);
        piecesTeamB.add(butterflyB);
        // Create TeamA and TeamB objects and pass them the array lists of pieces
        Team teamA = new Team("A", "Red",piecesTeamA);
        Team teamB = new Team("B", "Green",piecesTeamB);
    // Create an instance of the game
        Game181 ourGame = new Game181(6, 6,teamA, teamB);
    // Print Board at start of game
        System.out.println(ourGame.getBoard().toString());
    // Create PlayGame object and play the game
        PlayGame play = new PlayGame(ourGame);
        System.out.println("The mystery space is row " + ourGame.mystery.getRow() + " column " +ourGame.mystery.getColumn());
        play.playOurGame();




        /*
        // Create 3 pieces for Team A
        Piece nemoA = new PieceSharkBait("Nemo","Red");
        Piece blueHenA = new PieceBlueHen("Hen ","Red",100,0);
        Piece penguinA = new PiecePenguin("Peng","Red",0,0);
        Piece baitA = new PieceSharkBait("bait","Red");
        Piece henA = new PieceBlueHen("BHen ","Red",100,0);
        Piece pengA = new PiecePenguin("Rico","Red",0,0);
        // Create an array list to hold Team A&#39;s pieces
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(nemoA);
        piecesTeamA.add(blueHenA);
        piecesTeamA.add(penguinA);
        piecesTeamA.add(baitA);
        piecesTeamA.add(henA);
        piecesTeamA.add(pengA);
        // Create 3 pieces for Team B
        Piece nemoB = new PieceSharkBait("Nemo","Green");
        Piece blueHenB = new PieceBlueHen("Hen ","Green",100,0);
        Piece penguinB = new PiecePenguin("Peng","Green",0,0);
        Piece baitB = new PieceSharkBait("bait","Green");
        Piece henB = new PieceBlueHen("BHen ","Green",100,0);
        Piece pengB = new PiecePenguin("Skip","Green",0,0);
        // Create an array list to hold Team B&#39;s pieces
        ArrayList<Piece> piecesTeamB = new ArrayList<>();

        piecesTeamB.add(nemoB);
        piecesTeamB.add(blueHenB);
        piecesTeamB.add(penguinB);
        piecesTeamB.add(baitB);
        piecesTeamB.add(henB);
        piecesTeamB.add(pengB);
        // Create TeamA and TeamB objects and pass them the array lists of pieces
        Team teamA = new Team("A", "Red",piecesTeamA);
        Team teamB = new Team("B", "Green",piecesTeamB);
        // Create an instance of the game
        Game181 ourGame = new Game181(10, 10,teamA, teamB);
        // Print Board at start of game
        System.out.println(ourGame.getBoard().toString());
        // Create PlayGame object and play the game
        PlayGame play = new PlayGame(ourGame);
        play.playOurGame();

         */


    }
}

