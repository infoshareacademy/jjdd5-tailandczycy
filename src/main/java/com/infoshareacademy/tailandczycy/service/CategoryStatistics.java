package com.infoshareacademy.tailandczycy.service;

import java.math.BigDecimal;
import java.util.List;

public class CategoryStatistics {

    private int id;
    private BigDecimal totalCash;
    private BigDecimal upperLimit;

    public CategoryStatistics() {
        totalCash = new BigDecimal(0.0);
    }

    public CategoryStatistics(BigDecimal bigDecimal) {
        totalCash = bigDecimal;
    }

    public fillInformation(List<Expense> expenses, Category categoryName) {
        this.totalCash =
                expenses.stream()
                .filter(expense -> expense.getCategory() == categoryName)
                        .mapToInt()
                        .sum();
    }

}
