package by.home.entity;

public class Circle {

    private Point point;
    private double radios;

    public Circle(Point point, double radios) {
        super();
        this.point = point;
        this.radios = radios;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public double getRadios() {
        return radios;
    }

    public void setRadios(double radios) {
        this.radios = radios;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((point == null) ? 0 : point.hashCode());
        long temp;
        temp = Double.doubleToLongBits(radios);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Circle other = (Circle) obj;
        if (point == null) {
            if (other.point != null)
                return false;
        } else if (!point.equals(other.point))
            return false;
        if (Double.doubleToLongBits(radios) != Double.doubleToLongBits(other.radios))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[point=" + point + ", radios=" + radios + "]";
    }


}
