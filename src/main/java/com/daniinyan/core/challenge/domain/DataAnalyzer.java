package com.daniinyan.core.challenge.domain;

import com.daniinyan.core.challenge.dao.InputFileDAO;
import com.daniinyan.core.challenge.dao.OutputFileDAO;
import com.daniinyan.core.challenge.service.InputFileService;
import com.daniinyan.core.challenge.service.OutputFileService;

public class DataAnalyzer {

    private InputFileService inputFileService;
    private OutputFileService outputFileService;

    public DataAnalyzer(String directoryPath) {
        inputFileService = new InputFileService(new InputFileDAO(directoryPath));
        outputFileService = new OutputFileService(new OutputFileDAO(directoryPath));
    }

    public void createOutputFile() {
        outputFileService.create();
    }

    public void update() {
        setTotalCustomers();
    }

    private void setTotalCustomers() {
        String fieldName = Field.TOTAL_CUSTOMERS.getFieldName();
        long numberOfCostumers =  inputFileService.countCustomers();
        outputFileService.updateTotalCustomers(fieldName, numberOfCostumers);
    }

}
