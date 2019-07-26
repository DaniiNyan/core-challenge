package com.daniinyan.core.challenge.service;

import com.daniinyan.core.challenge.dao.OutputFileDAO;

public class OutputFileService {

    private OutputFileDAO outputFileDAO;

    public OutputFileService(OutputFileDAO outputFileDAO) {
        this.outputFileDAO = outputFileDAO;
    }

    public void updateTotalCustomers(String fieldName, long numberOfCustomers) {
        outputFileDAO.updateData(fieldName, String.valueOf(numberOfCustomers));
    }
}
