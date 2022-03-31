package by.home.repository.specifications;

import by.home.CircleObservable;
import by.home.logic.Calculator;

public class AreaSpecification implements Specification {

    private final double minArea;
    private final double maxArea;

    private final Calculator calculator;

    public AreaSpecification(double minArea, double maxArea, Calculator calculator) {
        this.minArea = minArea;
        this.maxArea = maxArea;
        this.calculator = calculator;
    }

    @Override
    public boolean specified(CircleObservable circle) {

        double circleArea = calculator.calculateArea(circle);

        return (circleArea >= minArea && circleArea <= maxArea);

    }
}
