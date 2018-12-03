package com.infoshareacademy.tailandczycy.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Expense {
    private int id;
    private List<String> categories;
    private String comment;
    private BigDecimal amount;
    private LocalDate date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
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
                "id=" + id +
                ", categories=" + categories +
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
        return id == expense.id &&
                Objects.equals(categories, expense.categories) &&
                Objects.equals(comment, expense.comment) &&
                Objects.equals(amount, expense.amount) &&
                Objects.equals(date, expense.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categories, comment, amount, date);
    }
}
