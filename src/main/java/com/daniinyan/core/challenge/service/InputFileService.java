package com.daniinyan.core.challenge.service;

import com.daniinyan.core.challenge.dao.InputFileDAO;
import com.daniinyan.core.challenge.domain.Sale;
import com.daniinyan.core.challenge.parser.InputParser;

import java.util.Comparator;

public class InputFileService {

    private static final String ID_SALESMAN = "001";
    private static final String ID_CUSTOMER = "002";
    private static final String ID_SALE = "003";

    private InputFileDAO inputFileDAO;

    public InputFileService(InputFileDAO inputFileDAO) {
        this.inputFileDAO = inputFileDAO;
    }

    public long countCustomers() {
        return inputFileDAO
                .readAllInputFiles()
                .stream()
                .filter(record -> InputParser.parseId(record).equals(ID_CUSTOMER))
                .count();
    }

    public long countSellers() {
        return inputFileDAO
                .readAllInputFiles()
                .stream()
                .filter(record -> InputParser.parseId(record).equals(ID_SALESMAN))
                .count();
    }

    public long getMostExpensiveSale() {
        return inputFileDAO
                .readAllInputFiles()
                .stream()
                .filter(record -> InputParser.parseId(record).equals(ID_SALE))
                .map(InputParser::parseSale)
                .max(Comparator.comparing(Sale::getTotal))
                .get()
                .getId();
    }
}
