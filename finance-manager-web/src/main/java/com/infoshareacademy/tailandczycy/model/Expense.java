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

    public Expense(@NotNull String name, @NotNull String comment, @NotNull BigDecimal amount, @NotNull LocalDate date, List<Category> categories) {
        this.name = name;
        this.comment = comment;
        this.amount = amount;
        this.date = date;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @NotNull
    public String getComment() {
        return comment;
    }

    public void setComment(@NotNull String comment) {
        this.comment = comment;
    }

    @NotNull
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(@NotNull BigDecimal amount) {
        this.amount = amount;
    }

    @NotNull
    public LocalDate getDate() {
        return date;
    }

    public void setDate(@NotNull LocalDate date) {
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
                ", categories=" + categories.stream()
                                .map(Category::getId)
                                .collect(toList())+
                '}';
    }
}
