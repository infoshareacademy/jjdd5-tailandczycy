package com.infoshareacademy.tailandczycy.console;

import java.math.BigDecimal;
import java.util.Scanner;

public class Reader {

    private Scanner scanner;


    public String readString(){
        String string = scanner.next();
        return string;
    }
    public int readInt(){
        int integer = scanner.nextInt();
        return integer;
    }
    public BigDecimal readBigDecimal(){
        BigDecimal decimal = scanner.nextBigDecimal();
        return decimal;
    }

}
