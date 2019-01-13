package com.infoshareacademy.tailandczycy.dto;

import com.infoshareacademy.tailandczycy.model.Expense;
import com.infoshareacademy.tailandczycy.model.User;

import java.math.BigDecimal;
import java.util.List;

public class CategoryDto {
    private Long id;
    private String name;
    private BigDecimal total;
    private BigDecimal limit;
    private List<Expense> expenses;
    private User user;

    public CategoryDto() {
    }

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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
