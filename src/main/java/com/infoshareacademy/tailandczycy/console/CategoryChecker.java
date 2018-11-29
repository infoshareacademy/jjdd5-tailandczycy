package com.infoshareacademy.tailandczycy.console;

import com.infoshareacademy.tailandczycy.service.Category;

import java.util.List;
import java.util.Optional;

public class CategoryChecker extends ConsoleReader {
    public Optional<Category> checkForCategory(List<Category> categories) {
        String categoryString = readString();
        return categories.stream()
                .filter(o -> o.getName().equals(categoryString))
                .findAny();
    }

}
