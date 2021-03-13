package game.board;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.rangeClosed;

class Board {

    private final int size;
    private final Field[][] fields;
    private final char rowFirstLetter = 'A';

    public Board(int size) {
        this.size = size;
        this.fields = createBoard();
    }

    public void print() {
        System.out.printf("  %s%n%s", createHeader(size), getBoardAsString());
    }

    String createHeader(int columns) {
        return rangeClosed(1, columns)
                .mapToObj(String::valueOf)
                .collect(joining(" "));
    }

    String getBoardAsString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            builder.append((char) (rowFirstLetter + i));
            for (Field field : fields[i]) {
                builder.append(field);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    Field[][] createBoard() {
        Field[][] fields = new Field[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                fields[i][j] = new Field();
            }
        }
        return fields;
    }

    boolean markField(int row, int column) {
        if (row > size || row < size || column < size || column > size) {
            return false;
        }

        Field field = fields[row][column];
        if (field.isEmpty()) {
            field.markField();
            return true;
        }
        return false;
    }
}
