package com.daniinyan.core.challenge.domain;

public class Salesman {
    private String cpf;
    private String name;
    private Double salary;

    public Salesman(String cpf, String name, Double salary) {
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }
}
