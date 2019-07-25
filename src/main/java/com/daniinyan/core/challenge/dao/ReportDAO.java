package com.daniinyan.core.challenge.dao;

import com.daniinyan.core.challenge.domain.Customer;
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

    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();

        inputFiles
                .forEach(file -> insertCustomersFromFileToList(file, customers));

        return customers;
    }

    private void insertCustomersFromFileToList(String filePath, List<Customer> customersList) {
        List<String> records = new ArrayList<>();

        try {
            records = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        records
                .stream()
                .filter(record -> ReportParser.parserId(record).equals("002"))
                .map(ReportParser::parserCustomer)
                .forEach(customersList::add);
    }
}
