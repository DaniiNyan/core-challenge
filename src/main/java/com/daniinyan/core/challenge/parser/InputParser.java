package com.daniinyan.core.challenge.parser;

import com.daniinyan.core.challenge.domain.Customer;

public class InputParser {

    public static String getDelimiter(String record) {
        return record.substring(3, 4);
    }

    public static String parserId(String record) {
        String[] recordSlice = record.split(getDelimiter(record));
        return recordSlice[0];
    }

    public static Customer parserCustomer(String record) {
        String[] recordSlice = record.split(getDelimiter(record));

        String cnpj = recordSlice[1];
        String name = recordSlice[2];
        String business = recordSlice[3];

        return new Customer(cnpj, name, business);
    }
}
