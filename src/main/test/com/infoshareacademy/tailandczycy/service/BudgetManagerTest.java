package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.data.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.data.dao.ExpenseDao;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.Matchers.anyInt;

public class BudgetManagerTest {

    @Mock
    CategoryDao categoryDaoMock;

    @Mock
    ExpenseDao expenseDaoMock;

    @Test
    public void modifyExpense() {
        // given
        Expense sampleExpense = new Expense("food", "dsadsasa0", BigDecimal.TEN, "");
        Expense expenseToBeModified = new Expense("food", "dsadsasa0", BigDecimal.TEN, "");
        Expense expenseModified = new Expense("food", "dsadsasa0", BigDecimal.TEN, "");
        Mockito.when(expenseDaoMock.getExpenseById(anyInt())).thenReturn(sampleExpense);
        BudgetManager subject = new BudgetManager(expenseDaoMock, categoryDaoMock);

        // when
        subject.modifyExpense(1, expenseToBeModified);

        //then
        Mockito.verify(expenseDaoMock).save(expenseModified);

    }
}