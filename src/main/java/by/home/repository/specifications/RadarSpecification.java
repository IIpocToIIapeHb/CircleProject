package by.home.repository.specifications;

import by.home.CircleObservable;

public class RadarSpecification implements Specification {

    private final double distanceFromZero;

    public RadarSpecification(double distanceFromZero) {
        this.distanceFromZero = distanceFromZero;
    }

    @Override
    public boolean specified(CircleObservable circle) {

        double distanceFromZeroToCircleCenter = distanceFromCircleCenterToZero(circle);

        return (distanceFromZero > (distanceFromZeroToCircleCenter - circle.getRadius()));
    }

    private double distanceFromCircleCenterToZero(CircleObservable circle) {

        double centerX = circle.getPoint().getX();
        double centerY = circle.getPoint().getY();

        double distance = Math.sqrt(Math.pow(centerX, 2) + Math.pow(centerY, 2));

        return distance;
    }
}
