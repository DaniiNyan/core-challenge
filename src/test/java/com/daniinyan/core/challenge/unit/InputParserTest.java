package com.daniinyan.core.challenge.unit;

import com.daniinyan.core.challenge.domain.Customer;
import com.daniinyan.core.challenge.parser.InputParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputParserTest {

    @Test
    public void mustReturnIdFromRecord() {
        String salesmanRecord = "001ç1234567891234çDiegoç50000";
        String customerRecord = "002ç2345675434544345çJose da SilvaçRural";
        String saleRecord = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego";

        assertEquals("001", InputParser.parserId(salesmanRecord));
        assertEquals("002", InputParser.parserId(customerRecord));
        assertEquals("003", InputParser.parserId(saleRecord));
    }

    @Test
    public void mustReturnCustomerFromRecord() {
        String record = "002ç2345675434544345çJose da SilvaçRural";
        Customer parsedCustomer = InputParser.parserCustomer(record);

        assertEquals("2345675434544345", parsedCustomer.getCnpj());
        assertEquals("Jose da Silva", parsedCustomer.getName());
        assertEquals("Rural", parsedCustomer.getBusinessArea());
    }

    @Test
    public void mustFindTheDelimiterFromRecord() {
        String sample01 = "001ç2345675434544345çJose da SilvaçRural";
        String sample02 = "002/2345675434544345/Jose da Silva/Rural";
        String sample03 = "003-2345675434544345-Jose da Silva-Rural";

        assertEquals("ç", InputParser.getDelimiter(sample01));
        assertEquals("/", InputParser.getDelimiter(sample02));
        assertEquals("-", InputParser.getDelimiter(sample03));
    }
}
