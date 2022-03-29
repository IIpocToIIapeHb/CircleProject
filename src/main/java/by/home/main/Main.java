package by.home.main;

import by.home.CircleObservable;
import by.home.CircleStore;
import by.home.IdGenerator;
import by.home.entity.Circle;
import by.home.entity.Point;
import by.home.logic.Axis;
import by.home.logic.Calculator;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(3,0);
        Circle circle = new Circle(point, 1);

        Calculator calculator = new Calculator();

        boolean result = calculator.isCrossingAxisOnDistance(circle,2, Axis.OX);
        System.out.println(result);

        CircleObservable cirCle = new CircleObservable(new IdGenerator(), new Point(1,1), 10);
        CircleStore store = CircleStore.getInstance();
        cirCle.attach(store);
        cirCle.setRadius(5);
        System.out.println(cirCle.getId());

        CircleObservable cirCle1 = new CircleObservable(new IdGenerator(), new Point(1,1), 10);
        CircleStore store1 = CircleStore.getInstance();
        cirCle1.attach(store1);
        cirCle1.setRadius(6);
        System.out.println(cirCle1.getId());
    }
}
