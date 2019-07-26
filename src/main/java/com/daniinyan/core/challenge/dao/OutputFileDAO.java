package com.daniinyan.core.challenge.dao;

import com.daniinyan.core.challenge.domain.Field;

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

    private static final String OUTPUT_FILE_PATH = "out/data_analysis.done.dat";

    private Path outputFilePath;

    public OutputFileDAO(String filesPath) {
        this.outputFilePath = Paths.get(filesPath + OUTPUT_FILE_PATH);
        create(this.outputFilePath);
    }

    public void updateData(String fieldName, String value) {
        List<String> updatedLines = read()
                .stream()
                .map(line -> {
                    if(line.contains(fieldName)) {
                        return fieldName + value;
                    }
                    return line;
                }).collect(Collectors.toList());

        try {
            Files.delete(outputFilePath);
            Files.createFile(outputFilePath);
            Files.write(outputFilePath, updatedLines, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<String> read() {
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
        String totalCustomers = Field.TOTAL_CUSTOMERS.getFieldName();
        String totalSellers = Field.TOTAL_SELLERS.getFieldName();
        String mostExpensiveSale = Field.MOST_EXPENSIVE_SALE.getFieldName();
        String worstSalesman = Field.WORST_SALESMAN.getFieldName();

        return Arrays.asList(totalCustomers, totalSellers, mostExpensiveSale, worstSalesman);
    }
}
