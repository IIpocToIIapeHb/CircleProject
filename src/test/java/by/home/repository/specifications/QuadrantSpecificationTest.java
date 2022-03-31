package by.home.repository.specifications;

import by.home.CircleObservable;
import by.home.IdGenerator;
import by.home.controller.DataReader;
import by.home.entity.Point;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class QuadrantSpecificationTest {



    private final static Quadrant QUADRANT_I = Quadrant.I;

    private final static CircleObservable CIRCLE_CROSSING_OX = new CircleObservable(new IdGenerator(),
            new Point(10, 5), 6);
    private final static CircleObservable CIRCLE_IN_I_QUADRANT = new CircleObservable(new IdGenerator(),
            new Point(10, 10), 6);
    private final static CircleObservable CIRCLE_IN_II_QUADRANT = new CircleObservable(new IdGenerator(),
            new Point(10, -10), 6);

    @Test
    public void testSpecifiedShouldReturnFalseWhenCircleCrossAnyAxis() {
        //given
        QuadrantSpecification quadrantSpecification = new QuadrantSpecification(QUADRANT_I);

        //when
        boolean realResult = quadrantSpecification.specified(CIRCLE_CROSSING_OX);

        //then
        assertFalse(realResult);
    }

    @Test
    public void testSpecifiedShouldReturnTrueWhenCircleInFirstQuadrant() {
        //given
        QuadrantSpecification quadrantSpecification = new QuadrantSpecification(QUADRANT_I);

        //when
        boolean realResult = quadrantSpecification.specified(CIRCLE_IN_I_QUADRANT);

        //then
        assertTrue(realResult);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenCircleNotInFirstQuadrant() {
        //given
        QuadrantSpecification quadrantSpecification = new QuadrantSpecification(QUADRANT_I);

        //when
        boolean realResult = quadrantSpecification.specified(CIRCLE_IN_II_QUADRANT);

        //then
        assertFalse(realResult);
    }

   /* @Test(expected = UnsupportedOperationException.class)
    public void testSpecified() {
        //given
        Quadrant quadrant = Mockito.mock(Quadrant.class);
        QuadrantSpecification quadrantSpecification = new QuadrantSpecification(quadrant);

        //when
        boolean realResult = quadrantSpecification.specified(CIRCLE_IN_II_QUADRANT);
    }*/
}
