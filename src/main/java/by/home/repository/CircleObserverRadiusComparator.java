package by.home.repository;

import by.home.CircleObservable;

import java.util.Comparator;

public class CircleObserverRadiusComparator implements Comparator<CircleObservable> {

    private final static int DELTA = 1000;

    @Override
    public int compare(CircleObservable o1, CircleObservable o2) {
        return (int) (o1.getRadius() * DELTA - o2.getRadius() * DELTA);
    }
}
