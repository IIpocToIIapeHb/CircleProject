package by.home.controller;

import by.home.entity.Circle;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

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
                    Circle circle = circleCreator.create(line);
                    circles.add(circle);
                }
            }
            LOGGER.info("Circles read = " + circles.size());
        }catch(DataException | RadiusException e){
            LOGGER.error(e.getMessage(),e);
        }
        return circles;
    }
}
