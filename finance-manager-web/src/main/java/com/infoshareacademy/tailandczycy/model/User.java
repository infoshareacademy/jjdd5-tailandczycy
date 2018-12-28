package com.infoshareacademy.tailandczycy.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "profile")
    private String profile;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Expense> expenses;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Category> categories;

    @OneToOne
    @JoinColumn(name = "budget_id", unique = true)
    private Budget budget;
}
