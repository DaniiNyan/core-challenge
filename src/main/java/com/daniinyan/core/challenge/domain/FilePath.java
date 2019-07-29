package com.daniinyan.core.challenge.domain;

public enum FilePath {
    DEFAULT_FOLDER("data/"),
    INPUT_FOLDER("in/"),
    OUTPUT_FILE("out/data_analysis.done.dat");

    private String path;

    private FilePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
