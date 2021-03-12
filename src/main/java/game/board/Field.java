package game.board;

/**
 * Represent the field in the battle board. Empty field is represented
 * byt '~' mark. The field that contains the part of ship is represented by '0'.
 *
 * @author Dominik Janiga
 * @version 1.0
 */
class Field {

    private String value = " ~";
    private int row;
    private int column;

    Field(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return value;
    }
}
