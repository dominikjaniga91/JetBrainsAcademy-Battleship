package game.board;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

class Board {

    private final int size;
    private final Row[] rows;

    public Board(int size) {
        this.size = size;
        this.rows = createRows();
    }

    public void print() {
        String rows = Arrays.toString(this.rows)
                .replace(", ", "")
                .replace("[", "")
                .replace("]", "");;
        System.out.printf("  %s%n%s", createHeader(10), rows);
    }

    String createHeader(int columns) {
        return rangeClosed(1, columns)
                .mapToObj(String::valueOf)
                .collect(joining(" "));
    }

    Row[] createRows() {
        char firstLetter = 'A';
        return range(0, size)
                .mapToObj(i -> createRow(firstLetter + i, i))
                .toArray(Row[]::new);
    }

    Row createRow(int letterCode, int row) {
        Field[] fields = range(0, size)
                .mapToObj(column -> new Field(row, column))
                .toArray(Field[]::new);
        return new Row(letterCode, fields);
    }
}
