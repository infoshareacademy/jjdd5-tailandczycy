package com.infoshareacademy.tailandczycy.dto;

import com.infoshareacademy.tailandczycy.model.Category;
import com.infoshareacademy.tailandczycy.model.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ExpenseDto {
    private Long id;
    private String name;
    private String comment;
    private BigDecimal amount;
    private LocalDate date;
    private List<Category> categories;
    private User user;

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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ExpenseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", categories=" + categories +
                ", user=" + user +
                '}';
    }
}
