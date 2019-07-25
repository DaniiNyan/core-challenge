package com.daniinyan.core.challenge;

import com.daniinyan.core.challenge.domain.Report;

public class Application {
    public static void main(String[] args) {
        Report report = new Report("data");
        report.update();
    }
}
