package game.board;

import java.util.Arrays;

class Row {

    private final char rowLetter;
    private final Field[] fields;

    public Row(int rowLetter, Field[] fields) {
        this.rowLetter = (char) rowLetter;
        this.fields = fields;
    }

    @Override
    public String toString() {
        String fields = Arrays.toString(this.fields)
                .replace(", ", "")
                .replace("[", "")
                .replace("]", "");
        return rowLetter + fields + "\n";
    }
}
