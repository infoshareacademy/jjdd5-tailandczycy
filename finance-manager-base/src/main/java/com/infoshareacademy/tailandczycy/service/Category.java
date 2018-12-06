package com.infoshareacademy.tailandczycy.service;

import java.math.BigDecimal;
import java.util.Objects;

public class Category {

    private String name;
    private BigDecimal limit;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", limit=" + limit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(limit, category.limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, limit);
    }
}
