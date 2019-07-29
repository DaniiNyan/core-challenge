package com.daniinyan.core.challenge.integration;

import com.daniinyan.core.challenge.domain.DataAnalyzer;
import com.daniinyan.core.challenge.domain.Field;
import com.daniinyan.core.challenge.parser.OutputParser;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class FindWorstSalesmanTest {

    private static final String FILES_PATH = "testdata/";
    private static final String INPUT_FILES_PATH = FILES_PATH + "in/";
    private static final String OUTPUT_FILE_PATH = FILES_PATH + "out/data_analysis.done.dat";

    private DataAnalyzer dataAnalyzer = new DataAnalyzer(FILES_PATH);

    @Before
    public void setUp() throws IOException {
        Files.deleteIfExists(Paths.get(INPUT_FILES_PATH + "0001.dat"));
        Files.deleteIfExists(Paths.get(INPUT_FILES_PATH + "0002.dat"));

        Files.createFile(Paths.get(INPUT_FILES_PATH + "0001.dat"));
        Files.write(Paths.get(INPUT_FILES_PATH + "0001.dat"), getSampleRecordsFile01(), StandardOpenOption.APPEND);

        Files.createFile(Paths.get(INPUT_FILES_PATH + "0002.dat"));
        Files.write(Paths.get(INPUT_FILES_PATH + "0002.dat"), getSampleRecordsFile02(), StandardOpenOption.APPEND);
    }

    @Test
    public void mustFindWorstSalesmanAndWriteInOutputFile() {
        dataAnalyzer.setWorstSalesman();

        String worstSalesmanField = readOutputFile()
                .stream()
                .filter(line -> line.contains(Field.WORST_SALESMAN.getFieldName()))
                .collect(Collectors.toList())
                .get(0);

        assertEquals("Denise", OutputParser.parseWorstSalesman(worstSalesmanField));

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

    private List<String> getSampleRecordsFile01() {
        return Arrays.asList("001ç1234567891234çDianaç50000",
                "001ç3245678865434çRenataç40000.99",
                "002ç2345675434544345çJose da SilvaçRural",
                "002ç2345675433444345çEduardoPereiraçRural",
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiana",
                "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenata");
    }

    private List<String> getSampleRecordsFile02() {
        return Arrays.asList("001ç1234567891234çDeniseç50000",
                "001ç3245678865434çClaudiaç40000.99",
                "001ç3245678865434çBeatrizç10000.99",
                "002ç2345675445544785çAlberto RibeiroçRural",
                "002ç2345625893444123çRoberto PereiraçRural",
                "003ç11ç[1-10-10,2-3-2.50,3-8-3.10]çDenise",
                "003ç09ç[1-5-10,2-33-1.50,3-40-0.10]çClaudia",
                "003ç12ç[1-3-10,2-3-1.50,3-44-0.10]çDenise",
                "003ç13ç[1-1-10,2-38-1.50,3-14-0.10]çDiana",
                "003ç14ç[1-30-10,2-9-1.50,3-3-0.10]çBeatriz",
                "003ç15ç[1-30-10,2-1-1.50,3-60-0.10]çBeatriz",
                "003ç16ç[1-70-10,2-10-1.50,3-4-0.10]çClaudia");
    }

}
