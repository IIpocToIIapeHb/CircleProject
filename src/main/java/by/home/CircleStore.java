package by.home;

import by.home.logic.Calculator;
import java.util.HashMap;
import java.util.Map;

public class CircleStore implements Observer{

    private static CircleStore instance;
    private final Map<Integer, CircleParameters> parameters = new HashMap<>();
    private final Calculator calculator = new Calculator();

    private CircleStore(){}

    public void update (CircleObservable circle){
        System.out.println("Circle has been changed");
        double perimeter = calculator.calculatePerimeter(circle);
        System.out.println("New perimeter = " + perimeter);
        double area = calculator.calculateArea(circle);
        System.out.println("New area = " + area);
        parameters.put(circle.getId(), new CircleParameters(perimeter, area));
    }

    public static CircleStore getInstance(){
        if (instance==null){
            instance = new CircleStore();
        }
        return instance;
    }

}