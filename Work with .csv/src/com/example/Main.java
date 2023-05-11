package com.example;

import java.util.List;

public class Main {
    public static void printList(List<List<String>> list) {
        // Null-check
        if (list.isEmpty()) {
            System.out.println("Empty list");
            return;
        }

        // Read headers from first line
        List<String> headers = list.get(0);

        // Print header
        System.out.println(String.join("\t", headers));

        // Data output
        for (int i = 1; i < list.size(); i++) {
            List<String> data = list.get(i);
            System.out.println(String.join("\t", data));
        }
    }

    public static void main(String[] args) {
        // Enter filepath
        String csvFilePath = "data/foreign_names.csv";

        // Define separator
        char separator = ';';

        CsvReader csvReader = new CsvReader();
        List<List<String>> info = csvReader.readCsv(csvFilePath, separator);

        // Print result
        printList(info);
    }
}
