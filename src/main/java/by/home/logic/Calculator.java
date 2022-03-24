package by.home.logic;

import by.home.controller.DataReader;
import by.home.entity.Circle;
import by.home.entity.Point;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public double calculateArea(Circle circle) {
        double circleArea = Math.PI * Math.pow(circle.getRadius(), 2);
        return circleArea;
    }

    public double calculatePerimetr(Circle circle) {
        double circlePerimetr = 2 * Math.PI * circle.getRadius();
        return circlePerimetr;
    }

    public boolean isCrossingAxisOnDistance(Circle circle, double distance, Axis axis) {
        List<Point> crossingPointsWithAxis = new ArrayList<Point>();
        boolean result = false;
        switch (axis) {
            case OX:
                crossingPointsWithAxis = calculatePointsOfCrossingCircleWithOX(circle);
                if (distance == Math.abs(crossingPointsWithAxis.get(0).getX())
                        || distance == Math.abs(crossingPointsWithAxis.get(1).getX())) ;
            {
                result = true;
            }
            break;
            case OY:
                crossingPointsWithAxis = calculatePointsOfCrossingCircleWithOY(circle);
                if (distance == Math.abs(crossingPointsWithAxis.get(0).getY())
                        || distance == Math.abs(crossingPointsWithAxis.get(1).getY())) ;
            {
                result = true;
            }
            break;
            default:
                throw new UnsupportedOperationException("There is know this this type:" + axis);
        }
        return result;
    }

    private double calculateLengthOfHalfChord(Circle circle, double distanceFromCenterToChord) {
        double theoryOfPifagor = Math.pow(circle.getRadius(), 2) - Math.pow(distanceFromCenterToChord, 2);
        double lengthOfHalfChord = Math.sqrt(theoryOfPifagor);
        return lengthOfHalfChord;
    }

    private List<Point> calculatePointsOfCrossingCircleWithOX(Circle circle) {

        Point centerPoint = circle.getPoint();

        List<Point> crossingPoints = new ArrayList<Point>();

        double distanceFromCenterToAxis = Math.abs(centerPoint.getY());

        double lengthOfHalfChordFormedByAxis = calculateLengthOfHalfChord(circle, distanceFromCenterToAxis);
        double crossing1 = centerPoint.getX() + lengthOfHalfChordFormedByAxis;
        double crossing2 = centerPoint.getX() - lengthOfHalfChordFormedByAxis;

        Point point1 = new Point(crossing1, 0);
        Point point2 = new Point(crossing2, 0);

        crossingPoints.add(point1);
        crossingPoints.add(point2);

        return crossingPoints;
    }

    private List<Point> calculatePointsOfCrossingCircleWithOY(Circle circle) {

        Point centerPoint = circle.getPoint();

        List<Point> crossingPoints = new ArrayList<Point>();

        double distanceFromCenterToAxis = Math.abs(centerPoint.getX());

        double lengthOfHalfChordFormedByAxis = calculateLengthOfHalfChord(circle, distanceFromCenterToAxis);
        double crossing1 = centerPoint.getY() + lengthOfHalfChordFormedByAxis;
        double crossing2 = centerPoint.getY() - lengthOfHalfChordFormedByAxis;

        Point point1 = new Point(0, crossing1);
        Point point2 = new Point(0, crossing2);

        crossingPoints.add(point1);
        crossingPoints.add(point2);

        return crossingPoints;
    }


}
