package com.daniinyan.core.challenge.integration;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountCustomersTest {

    private static final String FILES_PATH = "/testdata";
    private Report report;


    @Before
    public void setUp() {
        report = new Report(FILES_PATH);
    }

    @Test
    public void mustCountCustomersOfInputFile() {
        assertEquals(2, report.getTotalCustomers());
    }
}
