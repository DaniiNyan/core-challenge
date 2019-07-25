package com.daniinyan.core.challenge.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReportDAO {

    private Path inputFilesPath;
    private Path outputFilePath;
    private List<String> inputFiles = new ArrayList<>();

    public ReportDAO(String filesPath) {
        this.inputFilesPath = Paths.get(filesPath + "in");
        this.outputFilePath = Paths.get(filesPath + "out");
        findInputFiles();
    }

    private void findInputFiles() {
        try (Stream<Path> paths = Files.walk(this.inputFilesPath)) {
            inputFiles = paths
                    .filter(file -> file.toString().endsWith(".dat"))
                    .map(Path::toString)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<String> readAllInputFiles() {
        List<String> allRecordsList = new ArrayList<>();

        inputFiles
                .forEach(file -> insertRecordsFromFileToList(file, allRecordsList));

        return allRecordsList;
    }

    private void insertRecordsFromFileToList(String filePath, List<String> allRecordsList) {
        List<String> records = new ArrayList<>();

        try {
            records = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        allRecordsList.addAll(records);
    }
}
