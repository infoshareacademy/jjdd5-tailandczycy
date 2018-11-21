package com.infoshareacademy.tailandczycy.console;

import com.infoshareacademy.tailandczycy.data.Parser;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Menu menu = new Menu();
        System.out.println(menu.showMenu());
    }

}
