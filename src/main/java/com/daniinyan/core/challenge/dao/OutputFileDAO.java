package com.daniinyan.core.challenge.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputFileDAO {

    private static final String OUTPUT_FILE_NAME = "data_analysis.done.dat";
    private Path outputFilePath;

    public OutputFileDAO(String outputFilePath) {
        this.outputFilePath = Paths.get(outputFilePath + "out/" + OUTPUT_FILE_NAME);
        create(this.outputFilePath);
    }

    public void updateData(String field, int totalCustomers) {
        List<String> updatedRecord = read()
                .stream()
                .map(line -> {
                    if(line.contains(field)) {
                        return field + totalCustomers;
                    }
                    return line;
                }).collect(Collectors.toList());

        try {
            Files.delete(outputFilePath);
            Files.createFile(outputFilePath);
            Files.write(outputFilePath, updatedRecord, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<String> read() {
        List<String> records = new ArrayList<>();

        try {
            records = Files.readAllLines(outputFilePath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return records;
    }

    private void create(Path outputFilePath) {
        try {
            Files.deleteIfExists(outputFilePath);
            Files.createFile(outputFilePath);
            Files.write(outputFilePath, getDefaultLines(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<String> getDefaultLines() {
        String totalCustomers = "Total Customers=\n";
        String totalSellers = "Total Sellers=\n";
        String mostExpensiveSale = "ID of the most expensive sale=\n";
        String worstSalesman = "Worst salesman=";

        return Arrays.asList(totalCustomers, totalSellers, mostExpensiveSale, worstSalesman);
    }
}
