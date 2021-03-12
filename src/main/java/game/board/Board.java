package game.board;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

class Board {

    private final int size;

    Board(int size) {
        this.size = size;
    }

    public void print() {
        System.out.printf("%s%n%s", createHeader(10), createRows(10));
    }

    String createHeader(int columns) {
        return rangeClosed(1, columns)
                .mapToObj(String::valueOf)
                .collect(joining(" "));
    }

    String createRows(int columns) {
        char firstLetter = 'A';
        return range(0, columns)
                .mapToObj(i -> createRow(firstLetter + i, columns))
                .collect(joining());
    }

    String createRow(int letterCode, int columns) {
        return (char) letterCode + " ~".repeat(columns) + "\n";
    }
}
