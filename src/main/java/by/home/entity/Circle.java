package by.home.entity;

public class Circle {

    private Point point;
    private double radius;

    public Circle(Point point, double radios) {
        this.point = point;
        this.radius = radios;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((point == null) ? 0 : point.hashCode());
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Circle other = (Circle) obj;
        if (point == null) {
            if (other.point != null) {
                return false;
            }
        } else if (!point.equals(other.point)) {
            return false;
        }
        if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + point + ", radios=" + radius + "]";
    }


}
