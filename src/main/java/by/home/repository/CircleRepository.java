package by.home.repository;

import by.home.CircleObservable;
import by.home.entity.Circle;
import by.home.repository.specifications.Specification;

import java.util.Comparator;
import java.util.List;

public interface CircleRepository {

    void add(CircleObservable circle);

    void delete(CircleObservable circle);

    void update(CircleObservable circle);

    List<CircleObservable> query(Specification specification);

    void sort(Comparator<CircleObservable> comparator);
}
