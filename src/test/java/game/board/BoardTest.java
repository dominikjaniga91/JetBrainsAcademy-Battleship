package game.board;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BoardTest {

    private Board systemUnderTest;

    @BeforeMethod
    public void setUp() {
        systemUnderTest = new Board();
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
}
