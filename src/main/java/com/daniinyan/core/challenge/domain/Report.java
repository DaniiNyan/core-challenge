package com.daniinyan.core.challenge.domain;

import com.daniinyan.core.challenge.dao.ReportDAO;
import com.daniinyan.core.challenge.parser.ReportParser;

import java.util.List;
import java.util.stream.Collectors;

public class Report {

    private ReportDAO reportDAO;

    public Report(String filesPath) {
        reportDAO = new ReportDAO(filesPath);
    }

    public int getTotalCustomers() {
        return getCustomers().size();
    }

    private List<Customer> getCustomers() {
        return reportDAO.readAllInputFiles()
                .stream()
                .filter(record -> ReportParser.parserId(record).equals("002"))
                .map(ReportParser::parserCustomer)
                .collect(Collectors.toList());
    }
}
