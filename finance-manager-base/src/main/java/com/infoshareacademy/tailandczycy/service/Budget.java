package com.infoshareacademy.tailandczycy.service;

import java.math.BigDecimal;

public class Budget {
    private BigDecimal budget;

    public Budget(BigDecimal budget) {
        this.budget = budget;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
