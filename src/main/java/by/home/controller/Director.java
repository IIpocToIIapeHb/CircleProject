package by.home.controller;

import by.home.entity.Circle;

import java.util.ArrayList;
import java.util.List;

public class Director {

    private DataReader dataReader;
    private CircleValidator circleValidator;
    private CircleCreator circleCreator;

    public Director(DataReader dataReade, CircleValidator circleValidator, CircleCreator circleCreator) {
        this.dataReader = new DataReader();
        this.circleValidator = new CircleValidator();
        this.circleCreator = new CircleCreator();
    }

    public List<Circle> read(String filepath) throws DataException, RadiusException {

        List<String> lines = dataReader.read(filepath);
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
