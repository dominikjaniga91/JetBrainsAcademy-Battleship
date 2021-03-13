package game.board;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.rangeClosed;

class Board {

    private final int size;
    private final Field[][] fields;
    private final char rowFirstLetter = 'A';
    private final static int ARRAY_OFFSET = 1;

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

    void createShip(String begin, String end) {
        if (begin.charAt(0) == end.charAt(0)) {
            setShipHorizontally(begin, end);
        }
    }

    void setShipHorizontally(String begin, String end) {
        String rowLetter = String.valueOf(begin.charAt(0));
        int rowIndex = Rows.valueOf(rowLetter).getIndex();
        int beginColumn = Integer.parseInt(begin.replace(rowLetter, "")) - ARRAY_OFFSET;
        int endColumn = Integer.parseInt(end.replace(rowLetter, "")) - ARRAY_OFFSET;

        for (int i = beginColumn; i <= endColumn ; i++) {
            fields[rowIndex][i].markField();
        }

    }

    void setShipVertically(String begin, String end) {
        int column = getColumnIndex(begin);
        int beginRow = getRowIndex(begin);
        int endRow = getRowIndex(end);

        for (int i = beginRow; i <= endRow ; i++) {
            fields[i][column].markField();
        }
    }

    private int getColumnIndex(String begin) {
        return Integer.parseInt(begin.replaceAll("\\D", "")) - ARRAY_OFFSET;
    }

    private int getRowIndex(String begin) {
        String beginRowLetter = String.valueOf(begin.charAt(0));
        return Rows.valueOf(beginRowLetter).getIndex();
    }
}
