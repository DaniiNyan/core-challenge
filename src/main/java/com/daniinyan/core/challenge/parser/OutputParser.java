package com.daniinyan.core.challenge.parser;

public class OutputParser {

    private static final String DELIMITER = "=";

    public static int parseTotalCustomers(String record) {
        String[] recordSlice = record.split(DELIMITER);
        return Integer.parseInt(recordSlice[1]);
    }

    public static int parseTotalSellers(String record) {
        String[] recordSlice = record.split(DELIMITER);
        return Integer.parseInt(recordSlice[1]);

    }

    public static int parseMostExpensiveSale(String record) {
        String[] recordSlice = record.split(DELIMITER);
        return Integer.parseInt(recordSlice[1]);
    }
}
