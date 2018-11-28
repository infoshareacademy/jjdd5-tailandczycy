package com.infoshareacademy.tailandczycy.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.infoshareacademy.tailandczycy.service.Expense;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileOperations {

    public static void main(String[] args) throws IOException{
        final Path originalFile=Paths.get("data","test.json");


        List<String>lines=Files.readAllLines(originalFile);
        String json = lines.stream()
                .collect(Collectors.joining());


        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(LocalDate.class, new GsonLocalDateTypeAdapter())
                .create();
        Expense[] array = gson.fromJson(json, Expense[].class);
        List<Expense>expenses = Arrays.asList(array);
        System.out.println(expenses.get(0).getComment());
    }

//    private final Path originalFile=Paths.get("data","test.json");
//
//    public void foo() throws IOException {
//            List<String>lines=Files.readAllLines(originalFile);
//            String json = lines.stream()
//                    .collect(Collectors.joining());
//        }
}
