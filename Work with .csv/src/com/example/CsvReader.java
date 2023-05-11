package com.example;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public List<List<String>> readCsv(String filePath, char separator) {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(filePath);
             CSVReader reader = new CSVReader(new InputStreamReader(in, StandardCharsets.UTF_8), separator)) {
            if (reader == null) {
                throw new FileNotFoundException(filePath);
            }

            CsvParser csvParser = new CsvParser();
            return csvParser.parseCsv(reader);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (IOException e) {
            System.err.println("Reading file error: " + e.getMessage());
        }

        return new ArrayList<>();
    }
}
