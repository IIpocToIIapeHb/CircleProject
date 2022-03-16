package by.home.controller;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class DataReaderTest {
    private final static String TEST_FILE_PATH = "./src/test/resources/testFile.txt";

    @Test
    public void testReadShouldReturnLinesListWhenFileExists() {
        // given

        DataReader reader = new DataReader();

        // when
        List<String> lines = reader.read(TEST_FILE_PATH);

        // then
        List<String> expectedLines = new ArrayList<String>();
        expectedLines.add("2,2,5");
        expectedLines.add("5,10,-10");
        expectedLines.add("0,0,2");
        expectedLines.add("-8,8,5");

        assertEquals(expectedLines, lines);

    }


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test(expected = Exception.class)
    public void testReadShouldReturnExceptiobWhenFileNotExists() throws IOException {

        // given
        DataReader reader = new DataReader();

        // when
        List<String> lines = reader.read(TEST_FILE_PATH);

        // then
        exception.expect(IOException.class);
    }

}
