package com.daniinyan.core.challenge;

public class Application {
    public static void main(String[] args) {
        Watcher watcher = new Watcher("data/");
        watcher.createOutputFile();
        watcher.watchInput();
    }
}
