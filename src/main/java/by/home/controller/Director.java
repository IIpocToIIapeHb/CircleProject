package by.home.controller;

import by.home.entity.Circle;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Director {

    private final static Logger LOGGER = Logger.getLogger(Director.class);

    private DataReader dataReader;
    private CircleValidator circleValidator;
    private CircleCreator circleCreator;

    public Director(DataReader dataReader, CircleValidator circleValidator, CircleCreator circleCreator) {
        this.dataReader = dataReader;
        this.circleValidator = circleValidator;
        this.circleCreator = circleCreator;
    }

    public List<Circle> read(String filepath)  {
        List<Circle> circles = new ArrayList<Circle>();
        try {

            LOGGER.info("Programm start");
            List<String> lines = dataReader.read(filepath);

            for (String line : lines) {
                if (circleValidator.isCircle(line)) {
                    Optional<Circle> circle = circleCreator.create(line);
                    if (circle.isPresent()) {
                        circles.add(circle.get());
                    }
                }
            }
            LOGGER.info("Circles read = " + circles.size());
        }catch(DataException e){
            LOGGER.error(e.getMessage(),e);
        }
        return circles;
    }
}
