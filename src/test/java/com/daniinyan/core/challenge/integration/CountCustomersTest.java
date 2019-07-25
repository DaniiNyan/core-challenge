package com.daniinyan.core.challenge.integration;

import com.daniinyan.core.challenge.domain.Report;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountCustomersTest {

    private static final String FILES_PATH = "testdata/";
    private Report report;


    @Before
    public void setUp() {
        report = new Report(FILES_PATH);
    }

    @Test
    public void mustCountCustomersOfInputFile() {
        assertEquals(4, report.getCustomers().size());
    }
}
