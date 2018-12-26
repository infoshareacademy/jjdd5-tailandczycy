package com.infoshareacademy.tailandczycy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "EXPENSES")
@NamedQueries({
        @NamedQuery(
                name = "Expense.findExpensesPerCategory",
                query = "SELECT e FROM Expense e WHERE :param1 MEMBER OF e.categories ORDER BY e.date"
        ),
        @NamedQuery(
                name = "Expense.findExpensesCreatedAfterOrEven",
                query = "SELECT e FROM Expense e WHERE e.date >= :param1 ORDER BY e.date"
        ),
        @NamedQuery(
                name = "Expense.findExpensesCreatedBeforeOrEven",
                query = "SELECT e FROM Expense e WHERE e.date <= :param1 ORDER BY e.date"
        ),
        @NamedQuery(
                name = "Expense.findExpensesByDateBetween",
                query = "SELECT e FROM Expense e WHERE e.date >= :param1 AND e.date <= :param2"
        ),
        @NamedQuery(
                name = "Expense.findExpensesCreatedAt",
                query = "SELECT e From Expense e WHERE e.date = :param1"
        ),
        @NamedQuery(
                name = "Expense.findExpensesCheaperOrEven",
                query = "SELECT e FROM Expense e WHERE e.amount <= :param1 ORDER BY e.date"
        ),
        @NamedQuery(
                name = "Expense.findExpensesMoreExpOrEven",
                query = "SELECT e FROM Expense e WHERE e.amount >= :param1 ORDER BY e.date"
        ),
        @NamedQuery(
                name = "Expense.findExpensesEven",
                query = "SELECT e FROM Expense e WHERE e.amount = :param1 ORDER BY e.date"
        ),
        @NamedQuery(
                name = "Expense.findExpensesByName",
                query = "SELECT e FROM Expense e WHERE e.name = :param1 ORDER BY e.date"
        ),
        @NamedQuery(
                name = "Expense.orderByDateAsc",
                query = "SELECT e FROM Expense e ORDER BY e.date"
        ),
        @NamedQuery(
                name = "Expense.orderByDateDesC",
                query = "SELECT e FROM Expense e ORDER BY e.date DESC"
        ),
        @NamedQuery(
                name = "Expense.orderByAmountAsc",
                query = "SELECT e FROM Expense e ORDER BY e.amount"
        ),
        @NamedQuery(
                name = "Expense.orderByAmountDesc",
                query = "SELECT e FROM Expense e ORDER BY e.amount DESC"
        )
})
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

    @ManyToMany
    @JoinTable(name = "EXPENSES_TO_CATEGORIES",
            joinColumns = @JoinColumn(name = "expense_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"expense_id", "category_id"}))
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
