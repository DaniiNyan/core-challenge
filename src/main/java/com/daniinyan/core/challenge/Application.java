package com.daniinyan.core.challenge;

import com.daniinyan.core.challenge.domain.DataAnalyzer;

public class Application {
    public static void main(String[] args) {
        Watcher watcher = new Watcher("data/");
        DataAnalyzer dataAnalyzer = new DataAnalyzer("data/");

        dataAnalyzer.start();
        watcher.start();
    }
}
