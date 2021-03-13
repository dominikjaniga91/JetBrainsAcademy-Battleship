package game.board;

class Row {

    private final char rowLetter;
    private final Field[] fields;

    public Row(char rowLetter, Field[] fields) {
        this.rowLetter = rowLetter;
        this.fields = fields;
    }
}
