package by.home.repository;

import by.home.CircleObservable;
import by.home.IdGenerator;
import by.home.entity.Point;
import by.home.repository.specifications.Specification;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CircleRepositoryImplTest {

    private final static CircleObservable VALID_CIRCLE = new CircleObservable(new IdGenerator(),
            new Point(1, 1), 1);

    private final static CircleObservable INVALID_CIRCLE = new CircleObservable(new IdGenerator(),
            new Point(2, 2), 2);

    private static final List<CircleObservable> EXPECTED_LIST = (Arrays.asList(VALID_CIRCLE));
    private static final List<CircleObservable> EMPTY_LIST = (Arrays.asList());

    Map<Integer, CircleObservable> store = Mockito.mock(HashMap.class);

    Specification specification = Mockito.mock(Specification.class);

    @Test
    public void testQueryShouldReturnNotEmptyList() {
        //given
        when(store.values()).thenReturn(Arrays.asList(VALID_CIRCLE, INVALID_CIRCLE));

        when(specification.specified(VALID_CIRCLE)).thenReturn(true);
        when(specification.specified(INVALID_CIRCLE)).thenReturn(false);

        CircleRepositoryImpl repository = new CircleRepositoryImpl(store);

        //when
        List<CircleObservable> realList = repository.query(specification);

        //then
        assertEquals(EXPECTED_LIST, realList);

    }

    @Test
    public void testQueryShouldReturnEmptyList() {
        //given
        when(store.values()).thenReturn(Arrays.asList(INVALID_CIRCLE));

        when(specification.specified(INVALID_CIRCLE)).thenReturn(false);

        CircleRepositoryImpl repository = new CircleRepositoryImpl(store);

        //when
        List<CircleObservable> realList = repository.query(specification);

        //then
        assertEquals(EMPTY_LIST, realList);

    }
}
