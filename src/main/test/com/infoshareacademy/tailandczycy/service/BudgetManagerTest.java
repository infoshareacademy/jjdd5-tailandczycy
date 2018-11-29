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
    }

}