package com.infoshareacademy.tailandczycy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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

    public Expense(String name, String comment, BigDecimal amount, LocalDate date) {
        this.name = name;
        this.comment = comment;
        this.amount = amount;
        this.date = date;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Objects.equals(id, expense.id) &&
                Objects.equals(name, expense.name) &&
                Objects.equals(comment, expense.comment) &&
                Objects.equals(amount, expense.amount) &&
                Objects.equals(date, expense.date) &&
                Objects.equals(categories, expense.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, comment, amount, date, categories);
    }
}
