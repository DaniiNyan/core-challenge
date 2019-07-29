package com.daniinyan.core.challenge.parser;

import com.daniinyan.core.challenge.domain.Customer;
import com.daniinyan.core.challenge.domain.Item;
import com.daniinyan.core.challenge.domain.Sale;
import com.daniinyan.core.challenge.domain.Salesman;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public static String getDelimiter(String record) {
        return record.substring(3, 4);
    }

    public static String parseId(String record) {
        String[] recordSlice = record.split(getDelimiter(record));
        return recordSlice[0];
    }

    public static Customer parseCustomer(String record) {
        String[] recordSlice = record.split(getDelimiter(record));

        String cnpj = recordSlice[1];
        String name = recordSlice[2];
        String business = recordSlice[3];

        return new Customer(cnpj, name, business);
    }

    public static long parseSaleId(String record) {
        String[] recordSlice = record.split(getDelimiter(record));
        return Long.parseLong(recordSlice[1]);
    }

    public static Sale parseSale(String record) {
        String[] recordSlice = record.split(getDelimiter(record));

        long id = Long.parseLong(recordSlice[1]);
        List<Item> items = parseItems(record);
        String salesmanName = recordSlice[3];

        return new Sale(id, items, salesmanName);
    }

    public static List<Item> parseItems(String record) {
        String[] recordSlice = record.split(getDelimiter(record));
        String itemsRecord = recordSlice[2];
        itemsRecord = itemsRecord.substring(1, itemsRecord.length() - 1);
        String[] items = itemsRecord.split(",");

        List<Item> itemsList = new ArrayList<>();
        for (String itemRecord : items) {
            String[] itemSlice = itemRecord.split("-");
            long id = Long.parseLong(itemSlice[0]);
            int quantity = Integer.parseInt(itemSlice[1]);
            Double price = Double.parseDouble(itemSlice[2]);
            itemsList.add(new Item(id, quantity, price));
        }
        return itemsList;
    }

    public static Salesman parseSalesman(String record) {
        String[] recordSlice = record.split(getDelimiter(record));

        String cpf = recordSlice[1];
        String name = recordSlice[2];
        Double salary = Double.parseDouble(recordSlice[3]);

        return new Salesman(cpf, name, salary);
    }
}
