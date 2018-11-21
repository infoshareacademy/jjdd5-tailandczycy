package com.infoshareacademy.tailandczycy.data;

import com.google.gson.*;
import com.infoshareacademy.tailandczycy.service.Expenses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Parser {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(LocalDate.class, new GsonLocalDateTypeAdapter())
                .create();

        //Read from a file
        InputStream resourceAsStream = new FileInputStream("data/test.json");
        //Read Stream
        InputStreamReader reader = new InputStreamReader(resourceAsStream);
        //Reading from Json to Array
        Expenses[] expensesArray = gson.fromJson(reader, Expenses[].class);
        //Changing Array to List
        Expenses[] listOfExpenses = expensesArray;
        //Printing full list
        for (Expenses expense : listOfExpenses) {
            System.out.println(expense);
        }
    }
}
