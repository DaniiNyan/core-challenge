package com.daniinyan.core.challenge.service;

import com.daniinyan.core.challenge.dao.OutputFileDAO;

public class OutputFileService {

    private OutputFileDAO outputFileDAO;

    public OutputFileService(OutputFileDAO outputFileDAO) {
        this.outputFileDAO = outputFileDAO;
    }

    public void create() {
        outputFileDAO.create();
    }

    public void updateTotalCustomers(String fieldName, long numberOfCustomers) {
        outputFileDAO.updateData(fieldName, String.valueOf(numberOfCustomers));
    }

    public void updateTotalSellers(String fieldName, long numberOfSellers) {
        outputFileDAO.updateData(fieldName, String.valueOf(numberOfSellers));
    }

    public void updateMostExpensiveSale(String fieldName, long idFromMostExpensiveSale) {
        outputFileDAO.updateData(fieldName, String.valueOf(idFromMostExpensiveSale));
    }
}
