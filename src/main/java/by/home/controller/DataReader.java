package by.home.controller;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private final static Logger LOGGER = Logger.getLogger(DataReader.class);

    public List<String> read(String FilePath) throws DataException {

        BufferedReader bufferedReader = null;
        List<String> lines = new ArrayList<String>();

        try {

            FileReader fileReader = new FileReader(FilePath);
            bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while (line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new DataException("file error", e);

        } finally {

            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                LOGGER.error(e.getMessage(),e);
            }
        }
        return lines;
    }

}

