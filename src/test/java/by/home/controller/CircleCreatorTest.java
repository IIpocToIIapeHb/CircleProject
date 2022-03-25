package by.home.controller;

import by.home.entity.Circle;
import by.home.entity.Point;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class CircleCreatorTest {

    private static final String CIRCLE_LINE_WITH_POSITIVE_RADIUS = "1,2,3";
    private static final String CIRCLE_LINE_WITH_NEGATIVE_RADIUS = "1,2,-3";
    private static final Circle EXPEXTED_CIRCLE = new Circle(new Point(1, 2), 3);

    @Test
    public void testCreateSholdCreateCircleWhenRadiosPositive()  {
        //given
        CircleCreator circleCreator = new CircleCreator();
        //when
        Optional<Circle> realCircle = circleCreator.create(CIRCLE_LINE_WITH_POSITIVE_RADIUS);
        //then
        assertEquals(EXPEXTED_CIRCLE, realCircle);

    }

    @Test(expected = ValidationException.class) //then
    public void testCreateSholdCreateCircleWhenRadiosNegative() throws ValidationException {
        //given
        CircleCreator circleCreator = new CircleCreator();
        //when
        Optional<Circle> realCircle = circleCreator.create(CIRCLE_LINE_WITH_NEGATIVE_RADIUS);

    }
}
