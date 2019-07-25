package com.daniinyan.core.challenge.domain;

import com.daniinyan.core.challenge.dao.ReportDAO;

public class Report {

    private ReportDAO reportDAO;

    public Report(String filesPath) {
        reportDAO = new ReportDAO(filesPath);
    }

    public int getTotalCustomers() {
        return reportDAO.getCustomers().size();
    }
}
