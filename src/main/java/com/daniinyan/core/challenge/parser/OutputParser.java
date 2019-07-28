package com.daniinyan.core.challenge.parser;

public class OutputParser {

    private static final String DELIMITER = "=";

    public static int parserTotalCustomers(String record) {
        String[] recordSlice = record.split(DELIMITER);
        return Integer.parseInt(recordSlice[1]);
    }

    public static int parserTotalSellers(String record) {
        String[] recordSlice = record.split(DELIMITER);
        return Integer.parseInt(recordSlice[1]);

    }
}
