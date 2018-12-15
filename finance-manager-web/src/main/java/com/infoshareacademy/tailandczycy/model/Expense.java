package com.infoshareacademy.tailandczycy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity
@Table(name = "EXPENSES")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "comment")
    @NotNull
    private String comment;

    @Column(name = "amount")
    @NotNull
    private BigDecimal amount;

    @Column(name = "date")
    @NotNull
    private LocalDate date;

    @ManyToMany(mappedBy = "expenses")
    private List<Category> categories;

    public Expense() {
    }

    public Expense(String name, String comment, BigDecimal amount, LocalDate date, List<Category> categories) {
        this.name = name;
        this.comment = comment;
        this.amount = amount;
        this.date = date;
        this.categories = categories;
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

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", categories=" + categories +
                '}';
    }
}
