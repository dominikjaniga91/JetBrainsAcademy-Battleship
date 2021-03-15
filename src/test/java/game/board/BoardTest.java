package game.board;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BoardTest {

    private Board systemUnderTest;
    private final int size = 10;

    @BeforeMethod
    public void setUp() {
        systemUnderTest = new Board(size);
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

    @Test(dataProvider = "sizes")
    public void createHeader_returnColumnNumbers_forGivenSize(int size, String expected) {
        //when
        String actual = systemUnderTest.createHeader(size);

        //then
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    private Object[][] sizes() {
        return new Object[][] {
                {4, "1 2 3 4"},
                {6, "1 2 3 4 5 6"},
                {1, "1"},
                {10, "1 2 3 4 5 6 7 8 9 10"},
                {11, "1 2 3 4 5 6 7 8 9 10 11"},
        };
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
        Board board = new Board(3);
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

    @Test
    public void setShipHorizontally_createShip_forGivenPositions() {
        //given
        Board board = new Board(5);
        var outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String expected = """
                          1 2 3 4 5
                        A ~ ~ ~ ~ ~
                        B ~ ~ ~ ~ ~
                        C ~ 0 0 0 ~
                        D ~ ~ ~ ~ ~
                        E ~ ~ ~ ~ ~
                        """;

        //when
        board.setShipHorizontally("C2", "C4");
        board.print();

        //then
        Assert.assertEquals(outputStream.toString(), expected);
    }

    @Test
    public void setShipVertically_createShip_forGivenPositions() {
        //given
        Board board = new Board(5);
        var outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String expected = """
                          1 2 3 4 5
                        A ~ ~ ~ ~ ~
                        B ~ 0 ~ ~ ~
                        C ~ 0 ~ ~ ~
                        D ~ 0 ~ ~ ~
                        E ~ ~ ~ ~ ~
                        """;

        //when
        board.setShipVertically("B2", "D2");
        board.print();

        //then
        Assert.assertEquals(outputStream.toString(), expected);
    }

    @Test
    public void markOppositeFieldsAsOccupied_markAllFieldsOnBoard_forBoardWithNineFields() {
        //given
        Board board = new Board(3);

        //when
        board.markOppositeFieldsAsOccupied(1, 1);
        boolean actual = board.fieldStream().allMatch(Field::isOccupied);

        //then
        Assert.assertTrue(actual, "All fields should be occupied");
    }
}
