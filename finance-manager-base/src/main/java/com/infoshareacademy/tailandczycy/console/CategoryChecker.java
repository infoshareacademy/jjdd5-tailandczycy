package com.infoshareacademy.tailandczycy.console;

import com.infoshareacademy.tailandczycy.data.FileOperations;
import com.infoshareacademy.tailandczycy.service.Category;

import java.io.IOException;
import java.util.Optional;

public class CategoryChecker extends ConsoleReader {
    private FileOperations fileOperations = new FileOperations();

    public Optional<Category> checkForCategory() throws IOException {
        String categoryString = readString();
        return findCategory(categoryString);
    }

    private Optional<Category> findCategory(String categoryString) {
        return fileOperations.getListOfCategories().stream()
                .filter(o -> o.getName().equals(categoryString))
                .findAny();
    }

}
