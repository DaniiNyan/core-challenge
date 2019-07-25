package com.daniinyan.core.challenge.dao;

import com.daniinyan.core.challenge.parser.ReportParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReportDAO {

    private Path filesPath;
    private List<String> inputFiles = new ArrayList<>();

    public ReportDAO(String filesPath) {
        this.filesPath = Paths.get(filesPath);
        readInputFiles();
    }

    private void readInputFiles() {
        try (Stream<Path> paths = Files.walk(this.filesPath)) {
            inputFiles = paths
                    .filter(Files::isRegularFile)
                    .filter(file -> file.endsWith(".dat"))
                    .map(Path::toString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<String> getCustomers() {

//        List<String> customers = inputFiles
//                .stream()
//                .map(ReportParser::parserCustomer)
//                .collect(Collectors.toList());

        return inputFiles;
    }
}
