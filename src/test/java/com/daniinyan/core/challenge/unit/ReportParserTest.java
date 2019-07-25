package com.daniinyan.core.challenge.unit;

import com.daniinyan.core.challenge.domain.Customer;
import com.daniinyan.core.challenge.parser.ReportParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReportParserTest {

    @Test
    public void mustReturnIdFromRecord() {
        String salesmanRecord = "001ç1234567891234çDiegoç50000";
        String customerRecord = "002ç2345675434544345çJose da SilvaçRural";
        String saleRecord = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego";

        assertEquals("001", ReportParser.parserId(salesmanRecord));
        assertEquals("002", ReportParser.parserId(customerRecord));
        assertEquals("003", ReportParser.parserId(saleRecord));
    }

    @Test
    public void mustReturnCustomerFromRecord() {
        String record = "002ç2345675434544345çJose da SilvaçRural";
        Customer parsedCustomer = ReportParser.parserCustomer(record);

        assertEquals("2345675434544345", parsedCustomer.getCnpj());
        assertEquals("Jose da Silva", parsedCustomer.getName());
        assertEquals("Rural", parsedCustomer.getBusinessArea());
    }
}
