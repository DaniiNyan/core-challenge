package com.daniinyan.core.challenge.domain;

import com.daniinyan.core.challenge.dao.InputFileDAO;
import com.daniinyan.core.challenge.dao.OutputFileDAO;
import com.daniinyan.core.challenge.service.InputFileService;
import com.daniinyan.core.challenge.service.OutputFileService;

public class DataAnalyzer extends Thread {

    private InputFileService inputFileService;
    private OutputFileService outputFileService;

    public DataAnalyzer(String directoryPath) {
        inputFileService = new InputFileService(new InputFileDAO(directoryPath));
        outputFileService = new OutputFileService(new OutputFileDAO(directoryPath));
    }

    @Override
    public void run() {
        outputFileService.create();
        update();
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
        outputFileService.updateTotalCustomers(fieldName, numberOfCostumers);
    }

    public void setTotalSellers() {
        String fieldName = Field.TOTAL_SELLERS.getFieldName();
        long numberOfSellers = inputFileService.countSellers();
        outputFileService.updateTotalSellers(fieldName, numberOfSellers);
    }

    public void setMostExpensiveSale() {
        String fieldName = Field.MOST_EXPENSIVE_SALE.getFieldName();
        long idFromMostExpensiveSale = inputFileService.getMostExpensiveSale().getId();
        outputFileService.updateMostExpensiveSale(fieldName, idFromMostExpensiveSale);
    }

    public void setWorstSalesman() {
        String fieldName = Field.WORST_SALESMAN.getFieldName();
        String worstSalesmanName = inputFileService.getWorstSalesman().getName();
        outputFileService.updateWorstSalesman(fieldName, worstSalesmanName);
    }
}
