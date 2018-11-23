package com.infoshareacademy.tailandczycy.service;

import java.math.BigDecimal;

public enum Category {
    FOOD("Jedzenie"), CAR("Auto"), GIFTS("Prezenty");

    private final String label;

    Category(String label) {
        this.label = label;
    }
}
