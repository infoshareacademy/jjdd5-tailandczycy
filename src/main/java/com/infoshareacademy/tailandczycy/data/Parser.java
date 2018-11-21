package com.infoshareacademy.tailandczycy.data;

import com.google.gson.*;
import com.infoshareacademy.tailandczycy.service.Expense;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

public class Parser {
    //Initializing objects necessary to read from json file
    Gson gson = new GsonBuilder()
            .registerTypeHierarchyAdapter(LocalDate.class, new GsonLocalDateTypeAdapter())
            .create();
    InputStream resourceAsStream = new FileInputStream("data/test.json");
    InputStreamReader reader = new InputStreamReader(resourceAsStream);


    Expense[] expenseArray = gson.fromJson(reader, Expense[].class);
    //Changing Array to List
    Expense[] listOfExpens = expenseArray;

    public Parser() throws FileNotFoundException {
    }

    public List<Expense> getDataList(List<Expense> list) {
        return list;
    }
    
}
