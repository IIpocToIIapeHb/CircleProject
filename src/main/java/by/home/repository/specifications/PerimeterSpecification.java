package by.home.repository.specifications;

import by.home.CircleObservable;
import by.home.logic.Calculator;

public class PerimeterSpecification implements Specification {

    private final double minPerimeter;
    private final double maxPerimeter;

    private final Calculator calculator;

    public PerimeterSpecification(double minPerimeter, double maxPerimeter, Calculator calculator) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
        this.calculator = calculator;
    }

    @Override
    public boolean specified(CircleObservable circle) {

        double circlePerimeter = calculator.calculateArea(circle);

        return (circlePerimeter >= minPerimeter && circlePerimeter <= maxPerimeter);

    }
}
