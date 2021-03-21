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

    @Test(dataProvider = "theSameRows")
    public void hasTheSameRowAs_returnTrue_whenTwoFieldsHasTheSameRow(int beginRow, int beginColumn, int endRow, int endColumn) {
        //given
        Field startField = new Field(beginRow, beginColumn);
        Field endField = new Field(endRow, endColumn);

        //when
        boolean actual = startField.hasTheSameRowAs(endField);

        //then
        Assert.assertTrue(actual, "Method should return true");
    }

    @DataProvider
    private Object[][] theSameRows() {
        return new Object[][] {
                {1, 1, 1, 4},
                {2, 4, 2, 8},
                {3, 5, 3, 7},
        };
    }

    @Test(dataProvider = "notTheSameRows")
    public void hasTheSameRowAs_returnFalse_whenTwoFieldsHasNotTheSameRow(int beginRow, int beginColumn, int endRow, int endColumn) {
        //given
        Field startField = new Field(beginRow, beginColumn);
        Field endField = new Field(endRow, endColumn);

        //when
        boolean actual = startField.hasTheSameRowAs(endField);

        //then
        Assert.assertFalse(actual, "Method should return false");
    }

    @DataProvider
    private Object[][] notTheSameRows() {
        return new Object[][] {
                {3, 1, 1, 4},
                {2, 4, 1, 8},
                {3, 5, 4, 7},
        };
    }

    @Test(dataProvider = "theSameColumns")
    public void hasTheSameColumnAs_returnTrue_whenTwoFieldsHasTheSameColumn(int beginRow, int beginColumn, int endRow, int endColumn) {
        //given
        Field startField = new Field(beginRow, beginColumn);
        Field endField = new Field(endRow, endColumn);

        //when
        boolean actual = startField.hasTheSameColumnAs(endField);

        //then
        Assert.assertTrue(actual, "Method should return true");
    }

    @DataProvider
    private Object[][] theSameColumns() {
        return new Object[][] {
                {3, 1, 1, 1},
                {2, 4, 1, 4},
                {3, 5, 4, 5},
        };
    }

    @Test(dataProvider = "notTheSameColumns")
    public void hasTheSameColumnAs_returnFalse_whenTwoFieldsHasNotTheSameColumn(int beginRow, int beginColumn, int endRow, int endColumn) {
        //given
        Field startField = new Field(beginRow, beginColumn);
        Field endField = new Field(endRow, endColumn);

        //when
        boolean actual = startField.hasTheSameColumnAs(endField);

        //then
        Assert.assertFalse(actual, "Method should return false");
    }

    @DataProvider
    private Object[][] notTheSameColumns() {
        return new Object[][] {
                {3, 1, 1, 4},
                {2, 4, 1, 7},
                {3, 5, 4, 1},
        };
    }

    @Test(dataProvider = "fieldsAndLengths")
    public void getLengthToOtherField_returnLengthBetweenFields_forGivenTwoFields(Field startField, Field endField, int expected) {
        //when
        int actual = startField.getLengthToOtherField(endField);

        //then
        Assert.assertEquals(actual, expected, "The lengths should be the same");
    }

    @DataProvider
    public static Object[][] fieldsAndLengths() {
        return new Object[][]{
                {new Field(1,1),  new Field(1,4), 4},
                {new Field(1,1),  new Field(5,1), 5},
                {new Field(3,1),  new Field(3,4), 4},
                {new Field(2,2),  new Field(3,2), 2},
                {new Field(3,5),  new Field(3,7), 3},
        };
    }
}
