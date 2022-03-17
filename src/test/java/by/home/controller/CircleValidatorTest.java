package by.home.controller;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CircleValidatorTest {

    private static final String TRUE_CIRCLE_LINE = "2,3,4";
    private static final String FALSE_CIRCLE_LINE_WHEN_WRONG_LINE = "2,4,4,";
    private static final String FALSE_CIRCLE_LINE_WHEN_EMPTY_LINE = "";
    private static final String FALSE_CIRCLE_LINE_WHEN_NULL_LINE = null;


    @Test
    public void testIsCircleShouldBeTrueWhenStringCircle(){

        //given
        CircleValidator circleValidator = new CircleValidator();

        //when
       Boolean realIsCircle =  circleValidator.isCircle(TRUE_CIRCLE_LINE);

        //then
        assertEquals(true, realIsCircle);

    }

    @Test
    public void testIsCircleShouldBeTrueWhenStringNotCircle(){

        //given
        CircleValidator circleValidator = new CircleValidator();

        //when
        Boolean realIsCircle =  circleValidator.isCircle(FALSE_CIRCLE_LINE_WHEN_WRONG_LINE);

        //then
        assertEquals(false, realIsCircle);

    }

    @Test
    public void testIsCircleShouldBeTrueWhenStringEmpty(){

        //given
        CircleValidator circleValidator = new CircleValidator();

        //when
        Boolean realIsCircle =  circleValidator.isCircle(FALSE_CIRCLE_LINE_WHEN_EMPTY_LINE);

        //then
        assertEquals(false, realIsCircle);

    }

    @Test(expected = NullPointerException.class)
    public void testIsCircleShouldNullPointerException(){

        //given
        CircleValidator circleValidator = new CircleValidator();

        //when
        Boolean realIsCircle =  circleValidator.isCircle(FALSE_CIRCLE_LINE_WHEN_NULL_LINE);

    }

}
