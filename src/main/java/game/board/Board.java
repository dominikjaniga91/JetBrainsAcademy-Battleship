package game.board;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.rangeClosed;

class Board {


    public void print() {
        System.out.println("1 2 3 4 5 6 7 8 9 10\n" +
                "A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n" +
                "B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n" +
                "C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n" +
                "D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n" +
                "E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n" +
                "F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n" +
                "G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n" +
                "H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n" +
                "I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n" +
                "J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
    }

    String createHeader(int columns) {
        return rangeClosed(1, columns)
                .mapToObj(String::valueOf)
                .collect(joining(" "));
    }
}
