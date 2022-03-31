package by.home.repository.specifications;

import by.home.CircleObservable;

public class IdSpecification implements Specification {

    private final Integer id;

    public IdSpecification(Integer id) {
        this.id = id;
    }

    @Override
    public boolean specified(CircleObservable circle) {
        return circle.getId().equals(id);
    }
}
