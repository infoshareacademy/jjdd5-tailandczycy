package com.infoshareacademy.tailandczycy.service;

import java.math.BigDecimal;

public enum Category {
    FOOD("Jedzenie"), CAR("Auto"), GIFTS("Prezenty");

    private final String label;
    private BigDecimal total;
    private BigDecimal upperLimit;

    Category(String label) {
        this.label = label;
    }
}
