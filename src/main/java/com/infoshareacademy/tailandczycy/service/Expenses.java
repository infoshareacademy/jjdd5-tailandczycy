package com.infoshareacademy.tailandczycy.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Expenses {

    private List<Expense> expenses;
    private List<Category> categories;
    //If category dont have limit then Integer can be 0
    private Map<Category, Integer> categoriesLimits;
    private BigDecimal budget;
}
