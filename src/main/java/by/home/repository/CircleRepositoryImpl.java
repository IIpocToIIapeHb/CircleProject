package by.home.repository;

import by.home.CircleObservable;
import by.home.repository.specifications.Specification;
import org.apache.log4j.Logger;

import java.util.*;

public class CircleRepositoryImpl implements CircleRepository {

    private final static Logger LOGGER = Logger.getLogger(CircleRepositoryImpl.class);

    private Map<Integer, CircleObservable> store;

    public CircleRepositoryImpl(Map<Integer, CircleObservable> store) {
        this.store = store;
    }

    @Override
    public void add(CircleObservable circle) {
        store.put(circle.getId(), circle);
    }

    @Override
    public void delete(CircleObservable circle) {
        store.remove(circle.getId());
    }

    @Override
    public void update(CircleObservable circle) {
        store.put(circle.getId(), circle);
    }

    @Override
    public List<CircleObservable> query(Specification specification) {
        List<CircleObservable> circles = new ArrayList<>();
        for (CircleObservable circle : store.values()) {
            if (specification.specified(circle)) {
                circles.add(circle);
            }

        }
        if (circles.isEmpty()) {
            LOGGER.info("There is no circle suitable for the specification " + specification);
        }
        return circles;
    }

    @Override
    public void sort(Comparator<CircleObservable> comparator) {
        List<CircleObservable> circles = new ArrayList<>(store.values());
        Collections.sort(circles, comparator);

        for (CircleObservable circle : circles) {
            System.out.println(circle);
        }
    }
}
