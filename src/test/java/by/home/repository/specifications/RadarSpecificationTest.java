package by.home.repository.specifications;

import by.home.CircleObservable;
import by.home.IdGenerator;
import by.home.entity.Point;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RadarSpecificationTest {

    private final static CircleObservable VALID_CIRCLE = new CircleObservable(new IdGenerator(),
            new Point(5, -5), 3);

    private final static CircleObservable INVALID_CIRCLE = new CircleObservable(new IdGenerator(),
            new Point(100, -100), 3);

    private final static double DISTANCE_FROM_ZERO = 10;


    @Test
    public void testSpecifiedShouldReturnTrueWhenCircleInRadarArea() {
        //given
        RadarSpecification radar = new RadarSpecification(DISTANCE_FROM_ZERO);
        //when
        boolean realResult = radar.specified(VALID_CIRCLE);
        //then
        assertTrue(realResult);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenCircleInRadarArea() {
        //given
        RadarSpecification radar = new RadarSpecification(DISTANCE_FROM_ZERO);
        //when
        boolean realResult = radar.specified(INVALID_CIRCLE);
        //then
        assertFalse(realResult);
    }
}
