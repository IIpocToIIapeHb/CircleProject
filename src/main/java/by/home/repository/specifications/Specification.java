package by.home.repository.specifications;

import by.home.CircleObservable;
import by.home.entity.Circle;

public interface Specification {

    boolean specified(CircleObservable circle);

}
