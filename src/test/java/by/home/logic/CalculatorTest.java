package by.home.logic;

import by.home.entity.Circle;
import by.home.entity.Point;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class CalculatorTest {

    private static final Circle TEST_CIRCLE = new Circle(new Point(0,0),5);
    private static final double EXPECTED_AREA = 78.53975;
    private static final double EXPECTED_PERIMETER = 31.4159;
    private static final double VALID_DISTANCE_OF_CROSSING_AXIS = 5;
    private static final double INVALID_DISTANCE_OF_CROSSING_AXIS = 4;
    private static final Axis CROSSING_OX_AXIS = Axis.OX;

    @Test
    public void testCalculateAreaShouldReturnCircleArea() {
        //given
        Calculator calculator = new Calculator();
        //when
        double realArea = calculator.calculateArea(TEST_CIRCLE);
        //then
        assertEquals(EXPECTED_AREA, realArea, 0.0001);
    }

    @Test
    public void testCalculatePerimeterShouldReturnCirclePerimeter() {
        //given
        Calculator calculator = new Calculator();
        //when
        double realPerimeter = calculator.calculatePerimeter(TEST_CIRCLE);
        //then
        assertEquals(EXPECTED_PERIMETER, realPerimeter, 0.0001);
    }

    @Test
    public void testIsCrossingAxisOnDistanceShouldReturnTrueWhenCircleCrossOXAxisOnDistance() {
        //given
        Calculator calculator = new Calculator();
        //when
        boolean isCrossing = calculator.isCrossingAxisOnDistance(TEST_CIRCLE,
                                                                 VALID_DISTANCE_OF_CROSSING_AXIS,CROSSING_OX_AXIS);
        //then
        assertTrue(isCrossing);
    }

    @Test
    public void testIsCrossingAxisOnDistanceShouldReturnFalseWhenCircleCrossOXAxisOnDistance() {
        //given
        Calculator calculator = new Calculator();
        //when
        boolean isCrossing = calculator.isCrossingAxisOnDistance(TEST_CIRCLE,
                                                                 INVALID_DISTANCE_OF_CROSSING_AXIS,CROSSING_OX_AXIS);
        //then
        assertFalse(isCrossing);
    }

}
