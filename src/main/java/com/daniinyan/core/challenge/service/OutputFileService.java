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

    public void updateField(String fieldName, long fieldValue) {
        outputFileDAO.updateData(fieldName, String.valueOf(fieldValue));
    }

    public void updateField(String fieldName, String fieldValue) {
        outputFileDAO.updateData(fieldName, fieldValue);
    }
}
