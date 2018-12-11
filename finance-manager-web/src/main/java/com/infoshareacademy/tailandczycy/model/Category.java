package com.infoshareacademy.tailandczycy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "CATEGORIES")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "spending_limit")
    @NotNull
    private BigDecimal limit;

    @ManyToMany
    @JoinTable(name = "CATEGORIES_TO_EXPENSES",
            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "expense_id", referencedColumnName = "id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"category_id", "expense_id"}))
    private List<Expense> expenses;

    public Category(){
    }

    public Category(@NotNull String name, @NotNull BigDecimal limit, List<Expense> expenses) {
        this.name = name;
        this.limit = limit;
        this.expenses = expenses;
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
    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(@NotNull BigDecimal limit) {
        this.limit = limit;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", limit=" + limit +
                ", expenses=" + expenses +
                '}';
    }
}
