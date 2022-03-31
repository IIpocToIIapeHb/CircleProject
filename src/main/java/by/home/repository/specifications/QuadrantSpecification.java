package by.home.repository.specifications;

import by.home.CircleObservable;

public class QuadrantSpecification implements Specification {

    private final Quadrant quadrant;

    public QuadrantSpecification(Quadrant quadrant) {
        this.quadrant = quadrant;
    }

    @Override
    public boolean specified(CircleObservable circle) {

        double centerX = circle.getPoint().getX();
        double centerY = circle.getPoint().getY();

        boolean result;

        if (isCircleCrossingAnyAxis(circle)) {
            return false;
        }

        switch (quadrant) {
            case I:
                result = centerX > 0 && centerY > 0;
                break;
            case II:
                result = centerX < 0 && centerY > 0;
                break;
            case III:
                result = centerX < 0 && centerY < 0;
                break;
            case IV:
                result = centerX > 0 && centerY < 0;
                break;
            default:
                throw new UnsupportedOperationException("There is know this this type:" + quadrant);
        }
        return result;
    }

    private boolean isCircleCrossingAnyAxis(CircleObservable circle) {

        double centerX = circle.getPoint().getX();
        double centerY = circle.getPoint().getY();

        double radius = circle.getRadius();

        return (radius > Math.abs(centerX) || radius > Math.abs(centerY));
    }

    @Override
    public String toString() {
        return "QuadrantSpecification{" +
                "quadrant=" + quadrant +
                '}';
    }
}
