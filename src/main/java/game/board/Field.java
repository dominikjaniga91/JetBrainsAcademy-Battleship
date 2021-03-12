package game.board;

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
