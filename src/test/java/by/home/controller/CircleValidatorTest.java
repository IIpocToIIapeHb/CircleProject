package by.home.controller;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CircleValidatorTest {

    private static final String VALID_lINE = "2,3,4";
    private static final String INVALID_LINE = "2,4,4,";
    private static final String EMPTY_LINE = "";
    private static final String NULL_LINE = null;

    @Test
    public void testIsCircleShouldBeTrueWhenStringCircle() {

        //given
        CircleValidator circleValidator = new CircleValidator();

        //when
        Boolean realIsCircle = circleValidator.isCircle(VALID_lINE);

        //then
        assertEquals(true, realIsCircle);

    }

    @Test
    public void testIsCircleShouldBeTrueWhenStringNotCircle() {

        //given
        CircleValidator circleValidator = new CircleValidator();

        //when
        Boolean realIsCircle = circleValidator.isCircle(INVALID_LINE);

        //then
        assertEquals(false, realIsCircle);

    }

    @Test
    public void testIsCircleShouldBeTrueWhenStringEmpty() {

        //given
        CircleValidator circleValidator = new CircleValidator();

        //when
        Boolean realIsCircle = circleValidator.isCircle(EMPTY_LINE);

        //then
        assertEquals(false, realIsCircle);

    }

    @Test(expected = NullPointerException.class)
    public void testIsCircleShouldNullPointerException() {

        //given
        CircleValidator circleValidator = new CircleValidator();

        //when
        Boolean realIsCircle = circleValidator.isCircle(NULL_LINE);

    }

}
