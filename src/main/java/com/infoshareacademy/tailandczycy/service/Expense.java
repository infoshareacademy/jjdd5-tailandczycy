package com.infoshareacademy.tailandczycy.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Expense {
    private List<Category>categoryList;
    private String comment;
    private BigDecimal amount;
    private LocalDate date;

    public Expense(List<Category> categoryList, String comment, BigDecimal amount, LocalDate date) {
        this.categoryList = categoryList;
        this.comment = comment;
        this.amount = amount;
        this.date = date;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "categoryList=" + categoryList +
                ", comment='" + comment + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Objects.equals(categoryList, expense.categoryList) &&
                Objects.equals(comment, expense.comment) &&
                Objects.equals(amount, expense.amount) &&
                Objects.equals(date, expense.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryList, comment, amount, date);
    }
}
