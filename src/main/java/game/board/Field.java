package game.board;

import java.util.Objects;

/**
 * Represent the field in the battle board. Empty field is represented
 * byt '~' mark. The field that contains the part of ship is represented by '0'.
 *
 * @author Dominik Janiga
 * @version 1.0
 */
class Field {

    private String value = " ~";
    private boolean isOccupied = false;
    private int row;
    private int column;

    @Override
    public String toString() {
        return value;
    }

    public void markField() {
        value = " 0";
        isOccupied = true;
    }

    Field(){}

    Field(int row, int column) {
        this.row = row;
        this.column = column;
    }

    boolean isEmpty() {
        return !" 0".equals(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return row == field.row &&
                column == field.column &&
                Objects.equals(value, field.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public void markAsOccupied() {
        isOccupied = true;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    boolean isInBoardRange(int boardSize) {
        return row < boardSize && row >= 0 && column < boardSize && column >= 0;
    }

    public boolean hasTheSameRowAs(Field endField) {
        return this.row == endField.row;
    }

    public boolean hasTheSameColumnAs(Field endField) {
        return this.column == endField.column;
    }

    int getLengthToOtherField(Field other) {
        if (this.row == other.row) {
            return Math.abs(other.column - this.column + 1);
        }
        return Math.abs(other.row - this.row + 1);
    }
}
