package cisc181.lab_4;

public abstract class PieceEggLaying extends Piece {

    protected int numEggs;
    final public static int MAX_EGGS =2;

    //constructor for common fields
    public PieceEggLaying(String symbol, String color, int numEggs) {
        super(symbol);
        this.color = color;
        this.numEggs = numEggs;
    }

    //accessor for numEggs
    public int getNumEggs()  {
        return this.numEggs;
    }

    //increases numEggs by 1
    public void incrementNumEggs( ){
        this.numEggs++;
    }

    //will override in the subclasses
    public abstract PieceEggLaying layEgg();



}
