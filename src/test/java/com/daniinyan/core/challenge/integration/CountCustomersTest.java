package com.daniinyan.core.challenge.integration;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class CountCustomersTest {

    private InputFile inputFile;
    private static final String FILE_PATH = "";

    @Before
    public void setUp() throws IOException {
        inputFile = new InputFile(FILE_PATH);
    }

    @Test
    public void mustCountCustomersOfInputFile() {
        List<String> customers = inputFile.getCustomers();
    }
}
