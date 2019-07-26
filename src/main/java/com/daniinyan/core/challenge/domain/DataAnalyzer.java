package com.daniinyan.core.challenge.domain;

import com.daniinyan.core.challenge.dao.InputFileDAO;
import com.daniinyan.core.challenge.dao.OutputFileDAO;
import com.daniinyan.core.challenge.parser.InputParser;

public class DataAnalyzer {

    private InputFileDAO inputFileDAO;
    private OutputFileDAO outputFileDAO;

    private static final String TOTAL_CUSTOMER_FIELD = "Total Customers=";
    private static final String ID_CUSTOMER = "002";

    public DataAnalyzer(String filesPath) {
        inputFileDAO = new InputFileDAO(filesPath);
        outputFileDAO = new OutputFileDAO(filesPath);
        update();
    }

    public void update() {
        setTotalCustomers();
    }

    public int getCustomers() {
        update();
        return outputFileDAO.getTotalCustomers();
    }

    private void setTotalCustomers() {
        outputFileDAO.updateData(TOTAL_CUSTOMER_FIELD, String.valueOf(countCustomers()));
    }

    private long countCustomers() {
        return inputFileDAO
                .readAllInputFiles()
                .stream()
                .filter(record -> InputParser.parserId(record).equals(ID_CUSTOMER))
                .count();
    }

}
