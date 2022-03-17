package by.home.controller;

import java.io.IOException;

public class DataException extends Exception {
    public DataException(String message, IOException e) {
        super(message, e);
    }
}
