package com.infoshareacademy.tailandczycy.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Expenses {

   private List<Expense> expenseList;
   private List<Category>categoryList;
   private Map<Category, Integer>categoryToLimit;
   private BigDecimal budget;

}
