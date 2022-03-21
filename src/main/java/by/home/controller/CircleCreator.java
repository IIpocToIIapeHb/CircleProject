package by.home.controller;

import by.home.entity.Circle;
import by.home.entity.Point;

public class CircleCreator {

    public Circle create(String line) throws RadiusException {
        String[] parametrs = line.split(",");

        double x = Double.parseDouble(parametrs[0]);
        double y = Double.parseDouble(parametrs[1]);

        Point point = new Point(x, y);

        double radius = Double.parseDouble(parametrs[2]);

        if (radius <= 0) {
            throw new RadiusException("Radius is negative");
        }



        Circle circle = new Circle(point, radius);

        return circle;

    }
}
