package by.home.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    public List<String> read(String FilePath) {

        BufferedReader bufferedReader = null;
        List<String> lines = new ArrayList<String>();

        try {

            FileReader fileReader = new FileReader(FilePath);
            bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while (line != null) {
                if (!line.isEmpty()) {
                    lines.add(line);
                }
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            try {
                throw new DataException(e);
            } catch (DataException ex) {
                ex.printStackTrace();
            }

        } finally {

            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lines;
    }

}

