package com.daniinyan.core.challenge.integration;

import com.daniinyan.core.challenge.domain.DataAnalyzer;
import com.daniinyan.core.challenge.domain.Field;
import com.daniinyan.core.challenge.parser.OutputParser;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class FindMostExpensiveSale {

    private static final String FILES_PATH = "testdata/";
    private static final String OUTPUT_FILE_PATH = FILES_PATH + "out/data_analysis.done.dat";

    private DataAnalyzer dataAnalyzer = new DataAnalyzer(FILES_PATH);

    @Before
    public void setUp() {
        dataAnalyzer.update();
    }

    @Test
    public void mustFindMostExpensiveSaleAndWriteInOutputFile() {
        dataAnalyzer.setMostExpensiveSale();

        String mostExpensiveSaleField = readOutputFile()
                .stream()
                .filter(line -> line.contains(Field.MOST_EXPENSIVE_SALE.getFieldName()))
                .collect(Collectors.toList())
                .get(0);

        assertEquals(4, OutputParser.parseMostExpensiveSale(mostExpensiveSaleField));
    }

    private List<String> readOutputFile() {
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Paths.get(OUTPUT_FILE_PATH));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return lines;
    }
}