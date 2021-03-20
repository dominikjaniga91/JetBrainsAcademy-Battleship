package game.board;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FieldTest {

    @Test
    public void isEmpty_returnTrue_forAnEmptyField() {
        //given
        Field field = new Field();

        //when
        boolean actual = field.isEmpty();

        //then
        Assert.assertTrue(actual, "Method should return true");
    }


    @Test(dataProvider = "rowsAndColumns")
    public void isInBoardRange_returnTrue_whenFieldIsLocatedInBoard(int row, int column) {
        //given
        Field field = new Field(row, column);

        //when
        boolean actual = field.isInBoardRange(10);

        //then
        Assert.assertTrue(actual, "Method should return true");
    }

    @DataProvider
    public static Object[][] rowsAndColumns() {
        return new Object[][]{
                {1,1},
                {3,8},
                {9,1},
                {0,4},
                {5,0},
                {6,6},
                {3,3},
                {8,2},
                {1,4},
        };
    }

    @Test(dataProvider = "invalidRowsAndColumns")
    public void isInBoardRange_returnFalse_whenFieldIsNotLocatedInBoard(int row, int column) {
        //given
        Field field = new Field(row, column);

        //when
        boolean actual = field.isInBoardRange(10);

        //then
        Assert.assertFalse(actual, "Method should return false");
    }

    @DataProvider
    public static Object[][] invalidRowsAndColumns() {
        return new Object[][]{
                {-1,-1},
                {3,-8},
                {-9,1},
                {0,-4},
                {11,0},
                {11,11},
                {13,13},
                {-8,-2},
        };
    }
}
