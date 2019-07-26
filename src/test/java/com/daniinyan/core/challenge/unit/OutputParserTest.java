package com.daniinyan.core.challenge.unit;

import com.daniinyan.core.challenge.parser.OutputParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OutputParserTest {

    @Test
    public void mustReturnTotalCustomersFromRecord() {
        String record = "Total Customers=6120";
        assertEquals(6120, OutputParser.parserTotalCustomer(record));
    }
}
