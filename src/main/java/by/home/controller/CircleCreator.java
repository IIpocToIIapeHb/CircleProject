package by.home.controller;

import by.home.entity.Circle;
import by.home.entity.Point;
import org.apache.log4j.Logger;

import java.util.Optional;

public class CircleCreator {

    private final static Logger LOGGER = Logger.getLogger(CircleCreator.class);

    public Optional<Circle> create(String line) {
        String[] parametrs = line.split(",");

        double x = Double.parseDouble(parametrs[0]);
        double y = Double.parseDouble(parametrs[1]);

        Point point = new Point(x, y);

        double radius = Double.parseDouble(parametrs[2]);

        if (radius > 0) {
            Circle circle = new Circle(point, radius);
            return Optional.of(circle);
        } else {
            LOGGER.warn("negative radius= " + radius);
            return Optional.empty();
        }

    }
}
