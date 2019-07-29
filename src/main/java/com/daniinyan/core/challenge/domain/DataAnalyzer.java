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

    public DataAnalyzer() {
        inputFileService = new InputFileService(new InputFileDAO(FilePath.DEFAULT_FOLDER.getPath()));
        outputFileService = new OutputFileService(new OutputFileDAO(FilePath.DEFAULT_FOLDER.getPath()));
    }

    public void update() {
        setTotalCustomers();
        setTotalSellers();
        setMostExpensiveSale();
        setWorstSalesman();
    }

    public void setTotalCustomers() {
        String fieldName = Field.TOTAL_CUSTOMERS.getFieldName();
        long numberOfCostumers = inputFileService.countCustomers();
        outputFileService.updateField(fieldName, numberOfCostumers);
    }

    public void setTotalSellers() {
        String fieldName = Field.TOTAL_SELLERS.getFieldName();
        long numberOfSellers = inputFileService.countSellers();
        outputFileService.updateField(fieldName, numberOfSellers);
    }

    public void setMostExpensiveSale() {
        String fieldName = Field.MOST_EXPENSIVE_SALE.getFieldName();
        long idFromMostExpensiveSale = inputFileService.getMostExpensiveSale().getId();
        outputFileService.updateField(fieldName, idFromMostExpensiveSale);
    }

    public void setWorstSalesman() {
        String fieldName = Field.WORST_SALESMAN.getFieldName();
        String worstSalesmanName = inputFileService.getWorstSalesman().getName();
        outputFileService.updateField(fieldName, worstSalesmanName);
    }
}
