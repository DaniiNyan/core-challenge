package com.daniinyan.core.challenge.integration;

import com.daniinyan.core.challenge.domain.DataAnalyzer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountCustomersTest {

    private static final String FILES_PATH = "testdata/";
    private DataAnalyzer dataAnalyzer;


    @Before
    public void setUp() {
        dataAnalyzer = new DataAnalyzer(FILES_PATH);
    }

    @Test
    public void mustCountCustomersOfInputFileAndWriteInOutputFile() {
        assertEquals(4, dataAnalyzer.getCustomers());
    }

}
