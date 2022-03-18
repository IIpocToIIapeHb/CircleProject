package by.home.controller;

import by.home.entity.Circle;
import by.home.entity.Point;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DirectionTest {

    private final static String TEST_FILE_PATH = "./src/test/resources/testFile.txt";
    private final static List<Circle> EXPECTED_CIRCLES = Arrays.asList(
            new Circle(new Point(2, 2), 5),
            new Circle(new Point(5, 10), 10),
            new Circle(new Point(0, 0), 2),
            new Circle(new Point(-8, 8), 5));

    @Test
    public void testReadShouldReturnCirclesList() throws DataException, RadiusException {

        //given
        Direction direction = new Direction();

        //when
        List<Circle> realCircles = direction.read(TEST_FILE_PATH);

        //then
        assertEquals(EXPECTED_CIRCLES, realCircles);
    }
}
