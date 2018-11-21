package com.infoshareacademy.tailandczycy.data;

import com.google.gson.*;
import com.infoshareacademy.tailandczycy.service.Expense;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Parser {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(LocalDate.class, new GsonLocalDateTypeAdapter())
                .create();
        //Read from a file
        InputStream resourceAsStream = Parser.class.getResourceAsStream("test.json");
        //Read Stream
        InputStreamReader reader = new InputStreamReader(resourceAsStream);

        //Reading from Json to Array
        Expense[] expenseArray = gson.fromJson(reader, Expense[].class);
        //Changing Array to List
        List<Expense> listOfExpens = Arrays.asList(expenseArray);
        //Printing full list
        for (Expense expense : listOfExpens
        ) {
            System.out.println(expense);
        }
    }
}
