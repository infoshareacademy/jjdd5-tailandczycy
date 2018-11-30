package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.data.FileOperations;

import java.math.BigDecimal;

public class Budget {

    private BigDecimal budget;

    public Budget() {
        FileOperations fileOperations = new FileOperations();
        budget = fileOperations.getBudget();
    }

    public Budget(BigDecimal budget) {
        this.budget = budget;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public void saveBudget(BigDecimal budget) {
        //save to file
    }
}
