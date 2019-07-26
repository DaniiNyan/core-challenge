package com.daniinyan.core.challenge.service;

import com.daniinyan.core.challenge.dao.InputFileDAO;
import com.daniinyan.core.challenge.parser.InputParser;

public class InputFileService {

    private static final String ID_CUSTOMER = "002";

    private InputFileDAO inputFileDAO;

    public InputFileService(InputFileDAO inputFileDAO) {
        this.inputFileDAO = inputFileDAO;
    }

    public long countCustomers() {
        return inputFileDAO
                .readAllInputFiles()
                .stream()
                .filter(record -> InputParser.parserId(record).equals(ID_CUSTOMER))
                .count();
    }
}
