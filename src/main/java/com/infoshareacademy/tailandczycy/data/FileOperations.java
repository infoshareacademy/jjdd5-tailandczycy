package com.infoshareacademy.tailandczycy.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.tailandczycy.service.Category;
import com.infoshareacademy.tailandczycy.service.Expense;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;


public class FileOperations {

    private Gson gsonBuilder = new GsonBuilder()
            .registerTypeHierarchyAdapter(LocalDate.class, new GsonLocalDateTypeAdapter())
            .create();
    private Gson gson = new Gson();

    private final Path budgetFile = Paths.get("data", "budget.txt");
    private final Path expenseFile = Paths.get("data", "expenses.json");
    private final Path categoryFile = Paths.get("data", "categories.json");
    private List<String> lines = new ArrayList<>();

    public List<Expense> getExpenses() {

        String json = getStringFromFile(expenseFile);

        Expense[] array = gsonBuilder.fromJson(json, Expense[].class);
        List<Expense> tmpList = Arrays.asList(array);
        return new ArrayList<>(tmpList);
    }

    private String getStringFromFile(Path file) {
        try {
            lines = Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.join("", lines);
    }

    public List<Category> getCategories() {
        String json = getStringFromFile(categoryFile);
        return Arrays.asList(gson.fromJson(json, Category[].class));
    }

    public BigDecimal getBudget() {
        return new BigDecimal(getStringFromFile(budgetFile));
    }

    public void saveExpenses(List<Expense> expenses) {
        try {
            Files.write(expenseFile, Collections.singletonList(gsonBuilder.toJson(expenses)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveCategories(List<Category> categories) {
        try {
            Files.write(categoryFile, Collections.singletonList(gson.toJson(categories)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveBudget(BigDecimal budget){
        try {
            Files.write(budgetFile, Collections.singletonList(budget.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
