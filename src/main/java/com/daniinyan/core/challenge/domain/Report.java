package com.daniinyan.core.challenge.domain;

import com.daniinyan.core.challenge.dao.InputFileDAO;
import com.daniinyan.core.challenge.dao.OutputFileDAO;
import com.daniinyan.core.challenge.parser.ReportParser;

import java.util.List;
import java.util.stream.Collectors;

public class Report {

    private InputFileDAO inputFileDAO;
    private OutputFileDAO outputFileDAO;

    private static final String TOTAL_COSTUMER_FIELD = "Total Costumer=";

    public Report(String filesPath) {
        inputFileDAO = new InputFileDAO(filesPath);
        outputFileDAO = new OutputFileDAO(filesPath);
    }

    public void update() {
        setTotalCustomers();
    }

    public List<Customer> getCustomers() {
        return inputFileDAO.readAllInputFiles()
                .stream()
                .filter(record -> ReportParser.parserId(record).equals("002"))
                .map(ReportParser::parserCustomer)
                .collect(Collectors.toList());
    }

    private void setTotalCustomers() {
        outputFileDAO.updateData(TOTAL_COSTUMER_FIELD, getCustomers().size());
    }

}
