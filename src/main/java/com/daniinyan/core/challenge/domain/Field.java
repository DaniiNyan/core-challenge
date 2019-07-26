package com.daniinyan.core.challenge.domain;

public enum Field {
    TOTAL_CUSTOMERS("Total Customers="),
    TOTAL_SELLERS("Total Sellers="),
    MOST_EXPENSIVE_SALE("ID Most Expensive Sale="),
    WORST_SALESMAN("Worst Salesman=");

    private String fieldName;

    private Field(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
