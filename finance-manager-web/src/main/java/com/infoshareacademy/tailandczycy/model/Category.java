package com.infoshareacademy.tailandczycy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "CATEGORIES")
@NamedQueries({
        @NamedQuery(
                name = "Category.findCategoriesByName",
                query = "SELECT c FROM Category c WHERE c.name = :param1 ORDER BY c.limit"
        ),
        @NamedQuery(
                name = "Category.findCategoriesCheaperOrEven",
                query = "SELECT c FROM Category c WHERE c.limit <= :param1 ORDER BY c.limit"
        ),
        @NamedQuery(
                name = "Category.findCategoriesMoreExpOrEven",
                query = "SELECT c FROM Category c WHERE c.limit >= :param1 ORDER BY c.limit"
        ),
        @NamedQuery(
                name = "Category.findCategoriesEven",
                query = "SELECT c FROM Category c WHERE c.limit = :param1 ORDER BY c.name"
        )
})
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

    @ManyToMany(mappedBy = "categories")
    private List<Expense> expenses;

    public Category() {
    }

    public Category(String name, BigDecimal limit) {
        this.name = name;
        this.limit = limit;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(name, category.name) &&
                Objects.equals(limit, category.limit) &&
                Objects.equals(expenses, category.expenses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, limit, expenses);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", limit=" + limit +
                ", expenses=" + expenses.stream()
                .map(Expense::getId)
                .collect(Collectors.toList()) +
                '}';
    }
}
