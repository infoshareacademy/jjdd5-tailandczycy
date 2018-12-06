package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.data.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.data.dao.ExpenseDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BudgetManagerTest {

    @Mock
    private ExpenseDao expenseDao;

    @Mock
    private CategoryDao categoryDao;

    @Mock
    private Budget budget;

    private BudgetManager budgetManager;

    @BeforeEach
    public void setUp() {
        budgetManager = new BudgetManager();

        budgetManager.setExpenseDao(expenseDao);
        budgetManager.setBudgetDao(budget);
        budgetManager.setCategoryDao(categoryDao);
    }

    @Test
    void addExpense_singleExpense() {
        // GIVEN
        BigDecimal budgetAmount = new BigDecimal(100);
        when(budget.getBudget()).thenReturn(budgetAmount);

        Category category = new Category();
        category.setName("kategoria1");
        category.setLimit(budgetAmount);

        List<String> categories = Arrays.asList("kategoria1");
        BigDecimal amount = new BigDecimal("12.31");
        String comment = "lalalala";
        LocalDate date = LocalDate.now();

        Expense expense = new Expense();
        expense.setId(0);
        expense.setCategories(categories);
        expense.setComment(comment);
        expense.setAmount(amount);
        expense.setDate(date);

        // WHEN
        budgetManager.addExpense(categories, comment, amount, date);

        // THEN
        verify(categoryDao, times(1)).add(eq(category));
        verify(expenseDao, times(1)).add(eq(expense));
    }

    @Test
    void deleteExpense() {
    }

    @Test
    void addCategory() {
    }

    @Test
    void addCategory1() {
    }

    @Test
    void deleteCategory() {
    }

    @Test
    void displayExpensePerCategory() {
    }

    @Test
    void displayAllExpenses() {
    }

    @Test
    void displayExactExpense() {
    }

    @Test
    void defineBudget() {
    }

    @Test
    void setUpLimit() {
    }

    @Test
    void isExceedingLimit() {
    }

    @Test
    void getActualBudget() {
    }

    @Test
    void getExpense() {
    }

    @Test
    void getSumOfExpensesPerCategory() {
    }

    @Test
    void changeCategories() {
    }

    @Test
    void changeComment() {
    }

    @Test
    void changeAmount() {
    }

    @Test
    void changeDate() {
    }

    @Test
    void checkIfDateParsable() {
    }

    @Test
    void checkIfExpensePresent() {
    }

    @Test
    void checkIfCategoryPresent() {
    }
}