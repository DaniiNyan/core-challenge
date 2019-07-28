package com.daniinyan.core.challenge.domain;

public class Item {
    private long id;
    private int quantity;
    private Double price;

    public Item(long id, int quantity, Double price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }
}