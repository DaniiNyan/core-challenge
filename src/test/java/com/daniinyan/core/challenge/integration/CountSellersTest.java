package com.daniinyan.core.challenge.integration;

import com.daniinyan.core.challenge.dao.OutputFileDAO;
import com.daniinyan.core.challenge.domain.DataAnalyzer;
import com.daniinyan.core.challenge.domain.Field;
import com.daniinyan.core.challenge.domain.FilePath;
import com.daniinyan.core.challenge.parser.OutputParser;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class CountSellersTest {

    private static final String FILES_PATH = "testdata/";
    private static final String INPUT_FILES_PATH = FILES_PATH + FilePath.INPUT_FOLDER.getPath();
    private static final String OUTPUT_FILE_PATH = FILES_PATH + FilePath.OUTPUT_FILE.getPath();

    private DataAnalyzer dataAnalyzer = new DataAnalyzer(FILES_PATH);
    private OutputFileDAO outputFileDAO = new OutputFileDAO(FILES_PATH);

    @Before
    public void setUp() throws IOException {
        Files.list(Paths.get(INPUT_FILES_PATH))
                .map(Path::toFile)
                .forEach(File::delete);

        Files.createFile(Paths.get(INPUT_FILES_PATH + "0001.dat"));
        Files.write(Paths.get(INPUT_FILES_PATH + "0001.dat"), getSampleRecordsFile01(), StandardOpenOption.APPEND);

        Files.createFile(Paths.get(INPUT_FILES_PATH + "0002.dat"));
        Files.write(Paths.get(INPUT_FILES_PATH + "0002.dat"), getSampleRecordsFile02(), StandardOpenOption.APPEND);

        Files.deleteIfExists(Paths.get(OUTPUT_FILE_PATH));
        Files.createFile(Paths.get(OUTPUT_FILE_PATH));
        outputFileDAO.create();
    }

    @Test
    public void mustCountSellersOfInputFileWriteInOutputFile() {
        dataAnalyzer.setTotalSellers();
        String totalSellersField = readOutputFile()
                .stream()
                .filter(line -> line.contains(Field.TOTAL_SELLERS.getFieldName()))
                .collect(Collectors.toList())
                .get(0);

        assertEquals(5, OutputParser.parseTotalSellers(totalSellersField));
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
                "001ç1234567891234çDeniseç50000",
                "002ç2345675434544345çJose da SilvaçRural",
                "002ç2345675433444345çEduardoPereiraçRural",
                "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenata");
    }

    private List<String> getSampleRecordsFile02() {
        return Arrays.asList("001ç3245678865434çBeatrizç10000.99",
                "001ç3245678865434çClaudiaç40000.99",
                "002ç2345675445544785çAlberto RibeiroçRural",
                "002ç2345625893444123çRoberto PereiraçRural",
                "003ç12ç[1-3-10,2-3-1.50,3-44-0.10]çDenise");
    }
}
