package game.board;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BoardTest {

    @Test
    public void printBoard_printsEmptyBoard_whereThereIsNoShips() {
        //given
        Board board = new Board();
        String expected = """
                        1 2 3 4 5 6 7 8 9 10
                        A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
                        B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
                        C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
                        D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
                        E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
                        F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
                        G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
                        H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
                        I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
                        J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~     
                        """;
        var outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //when
        board.print();

        //then
        Assert.assertEquals(outputStream.toString(), expected, "Boards should be equals");



    }
}
