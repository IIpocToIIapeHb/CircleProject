package by.home.controller;

import by.home.entity.Circle;

import java.util.ArrayList;
import java.util.List;

public class Direction {

    private DataReader dataReader;
    private CircleValidator circleValidator;
    private CircleCreator circleCreator;

    public Direction() {
        dataReader = new DataReader();
        circleValidator = new CircleValidator();
        circleCreator = new CircleCreator();
    }

    public List<Circle> read(String Filepath) throws DataException, RadiusException {

        List<String> lines = dataReader.read(Filepath);
        List<Circle> circles = new ArrayList<Circle>();

        for (String line : lines) {
            if (circleValidator.isCircle(line)) {
                Circle circle = circleCreator.create(line);
                circles.add(circle);
            }
        }
        return circles;
    }
}
