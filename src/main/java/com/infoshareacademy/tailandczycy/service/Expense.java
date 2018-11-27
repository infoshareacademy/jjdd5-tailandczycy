package com.infoshareacademy.tailandczycy.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Expense {
    private List<Category>categories;
    private String comment;
    private BigDecimal amount;
    private LocalDate date;

    public Expense(List<Category> categoryList, String comment, BigDecimal amount, LocalDate date) {
        this.categories = categoryList;
        this.comment = comment;
        this.amount = amount;
        this.date = date;
    }

    public List<Category> getCategoryList() {
        return categories;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categories = categoryList;
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
                "categoryList=" + categories +
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
        return Objects.equals(categories, expense.categories) &&
                Objects.equals(comment, expense.comment) &&
                Objects.equals(amount, expense.amount) &&
                Objects.equals(date, expense.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categories, comment, amount, date);
    }
}
