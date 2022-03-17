package by.home.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CircleValidator {

    private static final Pattern PATTERN = Pattern.compile("([\\-]?[\\d]+[\\,]{1}){2}([\\-]?[\\d]+)");

    public boolean isCircle(String line) {
        Matcher matcher = PATTERN.matcher(line);
        boolean result = matcher.matches();
        return result;
    }
}
