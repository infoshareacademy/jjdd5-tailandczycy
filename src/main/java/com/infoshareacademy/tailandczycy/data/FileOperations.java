package com.infoshareacademy.tailandczycy.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.infoshareacademy.tailandczycy.service.Category;
import com.infoshareacademy.tailandczycy.service.Expense;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;


public class FileOperations {

    private final Path budgetFile=Paths.get("data", "budget.txt");
    private final Path expenseFile=Paths.get("data","expenses.json");
    private final Path categoryFile=Paths.get("data", "categories.json");
    private List<String> lines = new ArrayList<>();

    public List<Expense> deserializeListOfExpense() {

        String json = getStringFromFile(expenseFile);
        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(LocalDate.class, new GsonLocalDateTypeAdapter())
                .create();
        Expense[] array = gson.fromJson(json, Expense[].class);
        return Arrays.asList(array);
    }

    private String getStringFromFile(Path file) {
        try {
            lines = Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.join("", lines);
    }

    public List<Expense> getExpenses() {
        return deserializeListOfExpense();
    }

    public List<Category> getCategories() {
        String json = getStringFromFile(categoryFile);
        Gson gson = new Gson();
        return Arrays.asList(gson.fromJson(json, Category[].class));
    }

    public BigDecimal getBudget() {
        return new BigDecimal(getStringFromFile(budgetFile));
    }
}
