package by.home.controller;

import java.io.IOException;

public class DataException extends Exception {
    public DataException(IOException e) {
        System.out.println("File error");
    }
}
