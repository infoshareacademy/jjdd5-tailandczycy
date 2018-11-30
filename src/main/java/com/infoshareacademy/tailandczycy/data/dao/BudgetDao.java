package com.infoshareacademy.tailandczycy.data.dao;

import com.infoshareacademy.tailandczycy.data.FileOperations;
import com.infoshareacademy.tailandczycy.service.Budget;

import java.math.BigDecimal;

public class BudgetDao {

    public BudgetDao() {
        FileOperations fileOperations = new FileOperations();
        BigDecimal budget = fileOperations.getBudget();
    }
}
