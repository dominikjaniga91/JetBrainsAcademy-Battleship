package game.board;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class InputReaderTest {


    @Test
    public void read_returnInputAsString_fromScanner() {
        //given
        String expected = "test";
        System.setIn(new ByteArrayInputStream(expected.getBytes()));
        InputReader systemUnderTest = new InputReader(new Scanner(System.in));

        //when
        String actual = systemUnderTest.read();

        //then
        Assert.assertEquals(actual, expected, "Input should be the same");
    }
}
