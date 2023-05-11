package com.example;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
    public List<List<String>> parseCsv(CSVReader reader) throws IOException {
        List<List<String>> peopleData = new ArrayList<>();

        // Read first line with column names
        String[] headers = reader.readNext();

        // Add column names in list
        peopleData.add(List.of(headers));

        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            // Add line of data in list
            peopleData.add(List.of(nextLine));
        }

        return peopleData;
    }
}
