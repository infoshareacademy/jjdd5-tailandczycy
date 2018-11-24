package com.infoshareacademy.tailandczycy.data;

import com.google.gson.*;

import com.infoshareacademy.tailandczycy.service.Expense;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Parser {
    //Initializing objects necessary to read from json file
    private Gson gson = new GsonBuilder()
            .registerTypeHierarchyAdapter(LocalDate.class, new GsonLocalDateTypeAdapter())
            .create();
    private InputStream resourceAsStream = new FileInputStream("data/test.json");
    private InputStreamReader reader = new InputStreamReader(resourceAsStream);
    private Expense[] expenseArray = gson.fromJson(reader, Expense[].class);

    public Parser() throws FileNotFoundException {
    }

    public List<Expense> getDataList() {
        return arrayToList(expenseArray);
    }

    private List<Expense> arrayToList(Expense[] expenseArray) {

        return Arrays.asList(expenseArray);
    }
}
