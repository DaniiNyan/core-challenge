package com.daniinyan.core.challenge.dao;

import com.daniinyan.core.challenge.domain.FilePath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputFileDAO {

    private static final String SUPPORTED_FILE_EXTENSION = ".dat";

    private Path inputFilesPath;
    private List<String> inputFiles = new ArrayList<>();

    public InputFileDAO(String directoryPath) {
        this.inputFilesPath = Paths.get(directoryPath + FilePath.INPUT_FOLDER.getPath());
    }

    public List<String> readAllInputFiles() {
        findInputFiles();
        List<String> allRecordsList = new ArrayList<>();

        inputFiles
                .forEach(file -> insertRecordsFromFileToList(file, allRecordsList));

        return allRecordsList;
    }

    private void findInputFiles() {
        try (Stream<Path> paths = Files.walk(this.inputFilesPath)) {
            inputFiles = paths
                    .filter(file -> file.toString().endsWith(SUPPORTED_FILE_EXTENSION))
                    .map(Path::toString)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
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
