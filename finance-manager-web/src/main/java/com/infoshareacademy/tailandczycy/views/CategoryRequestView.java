package com.infoshareacademy.tailandczycy.views;

import java.math.BigDecimal;

public class CategoryRequestView {
    Long id;
    String name;
    BigDecimal limit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
