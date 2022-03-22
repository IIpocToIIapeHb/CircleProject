package by.home.logic;

import by.home.entity.Circle;

public class Calculator {

    public double calculateArea(Circle circle) {
        double circleArea = Math.PI * Math.pow(circle.getRadius(), 2);
        return circleArea;
    }

    public double calculatePerimetr(Circle circle) {
        double circlePerimetr = 2 * Math.PI * circle.getRadius();
        return circlePerimetr;
    }

    public boolean isCrossingAxis(Circle circle, double distance, Axis axis) {
        boolean result = true;

        double[] crossing = null;

        switch (axis) {
            case OX:
                crossing = calculatedistanceFromZeroToCrossingCircleWithOX(circle);
                if (distance == Math.abs(crossing[0]) && distance == Math.abs(crossing[1]))
                    result = true;
                break;
            case OY:
                crossing = calculatedistanceFromZeroToCrossingCircleWithOX(circle);
                if (distance == Math.abs(crossing[0]) && distance == Math.abs(crossing[1]))
                    result = true;

        }
        return result;
    }

    private double calculateLengthOfHalfChord(Circle circle, double distanceFromCenterToChord) {
        double theoryOfPifagor = Math.pow(circle.getRadius(), 2) - Math.pow(distanceFromCenterToChord, 2);
        double lengthOfHalfChord = Math.sqrt(theoryOfPifagor);
        return lengthOfHalfChord;
    }

    private double[] calculatedistanceFromZeroToCrossingCircleWithOX(Circle circle) {

        double distanceFromCenterToAxis = Math.abs(circle.getPoint().getY());
        double lengthOfHalfChordFormedByAxis = calculateLengthOfHalfChord(circle, distanceFromCenterToAxis);
        double crossing1 = circle.getPoint().getX() + lengthOfHalfChordFormedByAxis;
        double crossing2 = circle.getPoint().getX() - lengthOfHalfChordFormedByAxis;
        double[] result = {crossing1, crossing2};
        return result;
    }

    private double[] calculatedistanceFromZeroToCrossingCircleWithOY(Circle circle) {

        double distanceFromCenterToAxis = Math.abs(circle.getPoint().getX());
        double lengthOfHalfChordFormedByAxis = calculateLengthOfHalfChord(circle, distanceFromCenterToAxis);
        double crossing1 = circle.getPoint().getY() + lengthOfHalfChordFormedByAxis;
        double crossing2 = circle.getPoint().getY() - lengthOfHalfChordFormedByAxis;
        double[] result = {crossing1, crossing2};
        return result;
    }


}
