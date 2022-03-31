package by.home.repository.specifications;

import by.home.CircleObservable;
import by.home.IdGenerator;
import by.home.controller.DataReader;
import by.home.entity.Point;
import by.home.logic.Calculator;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class AreaSpecificationTest {

    private final double MIN_AREA = 0;
    private final double MAX_AREA = 100;

    private final static CircleObservable VALID_CIRCLE = new CircleObservable(new IdGenerator(),
            new Point(10, -10), 3);
    private final static double AREA_OF_VALID_CIRCLE = 28.2744;

    private final static CircleObservable INVALID_CIRCLE = new CircleObservable(new IdGenerator(),
            new Point(10, -10), 10);

    private final static double AREA_OF_INVALID_CIRCLE = 314.16;

    @Test
    public void testSpecifiedShouldReturnTrue() {
        //given
        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.calculateArea(VALID_CIRCLE)).thenReturn(AREA_OF_VALID_CIRCLE);

        AreaSpecification areaSpecification = new AreaSpecification(MIN_AREA, MAX_AREA, calculator);

        //when
        boolean realResult = areaSpecification.specified(VALID_CIRCLE);

        //then
        assertTrue(realResult);
    }

    @Test
    public void testSpecifiedShouldReturnFalse() {
        //given
        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.calculateArea(INVALID_CIRCLE)).thenReturn(AREA_OF_INVALID_CIRCLE);

        AreaSpecification areaSpecification = new AreaSpecification(MIN_AREA, MAX_AREA, calculator);

        //when
        boolean realResult = areaSpecification.specified(INVALID_CIRCLE);

        //then
        assertFalse(realResult);
    }
}
