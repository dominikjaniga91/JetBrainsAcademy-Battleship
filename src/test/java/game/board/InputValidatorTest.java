package game.board;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InputValidatorTest {

    private InputValidator systemUnderTest;
    private int boardSize = 10;

    @BeforeMethod
    public void setUp() {
        systemUnderTest = new InputValidator(boardSize);
    }

    @Test(dataProvider = "coordinates")
    public void isInBoardRange_returnTrue_forValidBoardCoordinates( int row, int column) {
        //given
        boolean actual = systemUnderTest.isInBoardRange(row, column);

        //then
        Assert.assertTrue(actual, "Method should return true");
    }

    @DataProvider
    public static Object[][] coordinates() {
        return new Object[][]{
                {3, 5},
                {1, 10},
                {3, 4},
                {2, 5},
                {3, 7},
        };
    }
}
