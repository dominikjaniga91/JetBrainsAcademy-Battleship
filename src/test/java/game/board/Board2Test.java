package game.board;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class Board2Test {

    private Board2 systemUnderTest;
    private final int size = 10;

    @BeforeMethod
    public void setUp() {
        systemUnderTest = new Board2(size);
    }

    @Test
    public void printBoard_printsEmptyBoard_whereThereIsNoShips() {
        //given
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
        systemUnderTest.print();

        //then
        Assert.assertEquals(outputStream.toString(), expected, "Boards should be equals");
    }

    @Test
    public void getBoardAsString_returnBoard_forGivenSize() {
        //given
        String expected = """
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

        //when
        String actual = systemUnderTest.getBoardAsString();

        //then
        Assert.assertEquals(actual, expected, "Boards should be the same");
    }

    @Test
    public void createBoard_returnMultiDimensionalArrayOfFields_forGivenInput() {
        //given
        Board2 board = new Board2(3);
        Field[][] expected = new Field[][] {
                {new Field(), new Field(), new Field(),},
                {new Field(), new Field(), new Field(),},
                {new Field(), new Field(), new Field(),},
        };

        //when
        Field[][] actual = board.createBoard();

        //then
        Assert.assertEquals(actual, expected, "Arrays should be the same");
    }
}
