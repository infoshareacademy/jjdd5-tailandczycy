package com.infoshareacademy.tailandczycy.service;

import java.math.BigDecimal;

public class Category {

    private final String name;
    private BigDecimal limit;

    public Category(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public BigDecimal getLimit() {
        return limit;
    }
}
