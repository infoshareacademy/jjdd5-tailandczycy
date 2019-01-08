package com.infoshareacademy.tailandczycy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "BUDGETS")
public class    Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    @NotNull
    private BigDecimal amount;

    public Budget() {
    }

    public Budget(@NotNull BigDecimal amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    @NotNull
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(@NotNull BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
