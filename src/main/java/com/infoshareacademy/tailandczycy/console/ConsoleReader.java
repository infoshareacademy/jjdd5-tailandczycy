package com.infoshareacademy.tailandczycy.console;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleReader {

    private Scanner scanner;

    public ConsoleReader(){
        scanner = new Scanner(System.in);
    }

    public String readString(){
        return scanner.next();
    }

    public int readInt(){ return scanner.nextInt(); }

    public BigDecimal readBigDecimal(){
        return scanner.nextBigDecimal();
    }
}
