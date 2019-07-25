package com.daniinyan.core.challenge.unit;

import com.daniinyan.core.challenge.domain.Customer;
import com.daniinyan.core.challenge.parser.ReportParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReportParserTest {

    @Test
    public void mustReturnCustomerFromRecord() {
        String record = "002ç2345675434544345çJose da SilvaçRural";
        Customer parsedCustomer = ReportParser.parserCustomer(record);

        assertEquals("2345675434544345", parsedCustomer.getCnpj());
        assertEquals("Jose da Silva", parsedCustomer.getName());
        assertEquals("Rural", parsedCustomer.getBusinessArea());
    }
}
