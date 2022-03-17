package by.home.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CircleValidator {

    public Boolean isCircle(String line) {

        Pattern pattern = Pattern.compile("([\\-]?[\\d]+[\\,]{1}){2}([\\-]?[\\d]+)");
        Matcher matcher = pattern.matcher(line);
        boolean result = matcher.matches();
        return result;
    }
}
