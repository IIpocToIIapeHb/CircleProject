package by.home.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CircleValidator {

    private static final String CIRCLE_LINE_VALIDATOR = "([\\-]?[\\d]+[\\,]{1}){2}([\\-]?[\\d]+)";
    private final Pattern pattern = Pattern.compile(CIRCLE_LINE_VALIDATOR);

    public boolean isCircle(String line) {
        Matcher matcher = pattern.matcher(line);
        boolean result = matcher.matches();
        return result;
    }
}
