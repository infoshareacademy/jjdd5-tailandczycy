package com.infoshareacademy.tailandczycy.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Expense {
    private String category;
    private String comment;
    private BigDecimal amount;
    private LocalDate date;


    public Expense(String category, String comment, BigDecimal amount, String date) {
        this.category = category;
        this.comment = comment;
        this.amount = amount;
        this.date = LocalDate.parse(date);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public void setDate(String date) {
        this.date = LocalDate.parse(date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Objects.equals(category, expense.category) &&
                Objects.equals(comment, expense.comment) &&
                Objects.equals(amount, expense.amount) &&
                Objects.equals(date, expense.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, comment, amount, date);
    }

    @Override
    public String toString() {
        return "{" +
                "category='" + category + '\'' +
                ", comment='" + comment + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
