package cisc181.lab_4;

public abstract class Piece {

    protected String symbol;
    protected String color;
    protected boolean hidden;

    //Constructor that sets the symbol to the string parameter and sets color
    public Piece(String symbol) {
        this.symbol = symbol;
        color = "";
    }

    public Piece(String symbol, String color){
        this.symbol = symbol;
        this.color = color;
        this.hidden = false;
    }

    //accessor for symbol
    public String getSymbol() {
        return symbol;
    }

    //accessor for color
    public String getColor(){
        return color;
    }

    //mutator method for color
    public void setColor(String color) {
        this.color = color;
    }

    //accessor for hidden
    public boolean isHidden() {
        return hidden;
    }

    //mutator for hidden
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    //abstract methods
    public abstract void speak();
    public abstract boolean validPath(int startRowIndex, int startColIndex, int finalRowIndex, int finalColIndex);

    //overriding toString to return the first letter of the color - symbol
    public String toString(){
        return color.charAt(0) + "-" + symbol;
    }


}
