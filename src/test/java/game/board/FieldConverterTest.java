package game.board;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FieldConverterTest {

    private FieldConverter fieldConverter;

    @BeforeMethod
    public void setUp() {
        fieldConverter = new FieldConverter();
    }

    @Test(dataProvider = "userInputs")
    public void read_returnFieldWithRowAndColumn_forGivenUserInput(String input, Field expected) {
        //when
        Field actual = fieldConverter.read(input);

        //then
        Assert.assertEquals(actual, expected, "Fields should be the same");

    }

    @DataProvider
    private Object[][] userInputs() {
        return new Object[][] {
                {"B3", new Field(1, 2)},
                {"A1", new Field(0, 0)},
                {"B9", new Field(1, 8)},
                {"D4", new Field(3, 3)},
        };
    }
}
