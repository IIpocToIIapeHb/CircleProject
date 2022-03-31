package by.home;

import by.home.logic.Calculator;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CircleStore implements Observer{

    private final static Logger LOGGER = Logger.getLogger(CircleStore.class);

    private static CircleStore instance;
    private final Map<Integer, CircleParameters> parameters;
    private final Calculator calculator;

    private CircleStore(Map<Integer, CircleParameters> parameters,Calculator calculator){
        this.parameters=parameters;
        this.calculator=calculator;
    }

    public void update (CircleObservable circle){
        LOGGER.info("Circle has been changed");
        double perimeter = calculator.calculatePerimeter(circle);
        LOGGER.info("New perimeter = " + perimeter);
        double area = calculator.calculateArea(circle);
        LOGGER.info("New area = " + area);
        parameters.put(circle.getId(), new CircleParameters(perimeter, area));
    }

    public static CircleStore getInstance(){
        if (instance==null){
            instance = new CircleStore(new HashMap<>(),new Calculator());
        }
        return instance;
    }

}