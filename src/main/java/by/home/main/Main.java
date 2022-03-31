package by.home.main;

import by.home.CircleObservable;
import by.home.CircleStore;
import by.home.IdGenerator;
import by.home.entity.Circle;
import by.home.entity.Point;
import by.home.logic.Axis;
import by.home.logic.Calculator;
import by.home.repository.CircleObserverRadiusComparator;
import by.home.repository.CircleRepository;
import by.home.repository.CircleRepositoryImpl;
import by.home.repository.specifications.Quadrant;
import by.home.repository.specifications.QuadrantSpecification;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(3,0);
        Circle circle = new Circle(point, 1);

        Calculator calculator = new Calculator();

        boolean result = calculator.isCrossingAxisOnDistance(circle,2, Axis.OX);
        System.out.println(result);

        CircleObservable cirCle = new CircleObservable(new IdGenerator(), new Point(6,6), 10);
        CircleStore store = CircleStore.getInstance();
        cirCle.attach(store);
        cirCle.setRadius(5);


        CircleObservable cirCle1 = new CircleObservable(new IdGenerator(), new Point(1,1), 10);
        cirCle1.attach(store);
        cirCle1.setRadius(1);

        CircleObservable cirCle2 = new CircleObservable(new IdGenerator(), new Point(10,10), 8);
        ////////////////////////////////////////////////////////////////////

        CircleRepository circleRepository = new CircleRepositoryImpl(new HashMap<>());
        circleRepository.add(cirCle);
        circleRepository.add(cirCle1);
        circleRepository.add(cirCle2);

        List<CircleObservable> circlesQuadrant =circleRepository.query(new QuadrantSpecification(Quadrant.I));

        for (Circle cIrCle:circlesQuadrant){
            System.out.println(cIrCle);
        }
        System.out.println("///////////////////////////////////////////////////////////////////////////////////");

        circleRepository.sort(new CircleObserverRadiusComparator());
    }
}
