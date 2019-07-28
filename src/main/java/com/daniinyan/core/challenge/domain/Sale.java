package com.daniinyan.core.challenge.domain;

import java.util.List;

public class Sale {
    private long id;
    private List<Item> items;
    private String salesmanName;

    public Sale(long id, List<Item> items, String salesmanName) {
        this.id = id;
        this.items = items;
        this.salesmanName = salesmanName;
    }

    public long getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public Double getTotal() {
        return items
                .stream()
                .mapToDouble(item -> item.getQuantity() * item.getPrice())
                .sum();
    }
}
