package com.daniinyan.core.challenge.unit;

import com.daniinyan.core.challenge.parser.OutputParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OutputParserTest {

    @Test
    public void mustReturnTotalCustomersFromRecord() {
        String record = "Total Customers=6120";
        assertEquals(6120, OutputParser.parseTotalCustomers(record));
    }

    @Test
    public void mustReturnTotalSellersFromRecord() {
        String record = "Total Sellers=510";
        assertEquals(510, OutputParser.parseTotalSellers(record));
    }

    @Test
    public void mustReturnIdFromMostExpensiveSaleFromRecord() {
        String record = "ID Most Expensive Sale=22";
        assertEquals(22, OutputParser.parseMostExpensiveSale(record));
    }

    @Test
    public void mustReturnNameFromWorstSalesmanFromRecord() {
        String record = "Worst Salesman=Alexia";
        assertEquals("Alexia", OutputParser.parseWorstSalesman(record));
    }
}
