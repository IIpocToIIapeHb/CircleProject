package by.home.controller;

import by.home.entity.Circle;
import by.home.entity.Point;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class DirectorTest {

    private final static String TEST_FILE_PATH = "testPath";
    private final static List<Circle> EXPECTED_CIRCLES = Arrays.asList(
            new Circle(new Point(2, 2), 5),
            new Circle(new Point(5, 10), 10),
            new Circle(new Point(0, 0), 2),
            new Circle(new Point(-8, 8), 5));

    @Test
    public void testReadShouldReturnCirclesList() throws DataException, RadiusException {

        //given
        DataReader dataReader = Mockito.mock(DataReader.class);
        when(dataReader.read(anyString())).thenReturn(Arrays.asList("2,2,5","5,10,10", "0,0,2", "-8,8,5"));

        CircleValidator circleValidator = Mockito.mock(CircleValidator.class);
        when(circleValidator.isCircle(anyString())).thenReturn(true);

        CircleCreator circleCreator = Mockito.mock(CircleCreator.class);
        when(circleCreator.create("2,2,5")).thenReturn(new Circle(new Point(2, 2), 5));
        when(circleCreator.create("5,10,10")).thenReturn(new Circle(new Point(5, 10), 10));
        when(circleCreator.create("0,0,2")).thenReturn(new Circle(new Point(0, 0), 2));
        when(circleCreator.create("-8,8,5")).thenReturn(new Circle(new Point(-8, 8), 5));


        Director director = new Director(dataReader,circleValidator,circleCreator);

        //when
        List<Circle> realCircles = director.read(TEST_FILE_PATH);

        //then
        assertEquals(EXPECTED_CIRCLES, realCircles);
    }
}
