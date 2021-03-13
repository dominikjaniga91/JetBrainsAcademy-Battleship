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

    @Override
    public String toString() {
        return value;
    }

    public void markField() {
        value = " 0";
    }

    boolean isEmpty() {
        return !"0".equals(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return Objects.equals(value, field.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
