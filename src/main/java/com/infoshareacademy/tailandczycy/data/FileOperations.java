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
import java.util.Arrays;
import java.util.List;


public class FileOperations {

    private final Path budgetFile=Paths.get("data", "budget.txt");
    private final Path expenseFile=Paths.get("data","expenses.json");
    private final Path categoryFile=Paths.get("data", "categories.json");

    public List<Category> deserializeListOfCategories() throws IOException{

        String json = getStringFromFile(categoryFile);
        Gson gson = new Gson();
        Category[] array = gson.fromJson(json, Category[].class);
        return Arrays.asList(array);
    }

    public List<Expense> deserializeListOfExpense() throws IOException {

        String json = getStringFromFile(expenseFile);
        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(LocalDate.class, new GsonLocalDateTypeAdapter())
                .create();
        Expense[] array = gson.fromJson(json, Expense[].class);
        return Arrays.asList(array);
    }

    private String getStringFromFile(Path file) throws IOException {
        List<String> lines = Files.readAllLines(file);
        return String.join("", lines);
    }

    public List<Expense> getListOfExpenses() throws IOException{
        return deserializeListOfExpense();
    }

    public List<Category> getListOfCategories() throws IOException{
        return deserializeListOfCategories();
    }

    public BigDecimal getBudget() throws IOException{
        return new BigDecimal(getStringFromFile(budgetFile));
    }
}
