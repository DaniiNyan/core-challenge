package com.daniinyan.core.challenge.parser;

import com.daniinyan.core.challenge.domain.Customer;

public class ReportParser {

    private static final String DELIMITER = "ç";

    public static Customer parserCustomer(String record) {
        String[] recordSlice = record.split(DELIMITER);

        String cnpj = recordSlice[1];
        String name = recordSlice[2];
        String business = recordSlice[3];

        return new Customer(cnpj, name, business);
    }
}
