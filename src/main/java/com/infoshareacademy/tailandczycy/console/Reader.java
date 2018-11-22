package com.infoshareacademy.tailandczycy.console;

import java.math.BigDecimal;
import java.util.Scanner;

public class Reader {

<<<<<<< HEAD
    private Scanner scanner;

=======
    private Scanner scanner = new Scanner(System.in);
>>>>>>> 9c7e558f49e1a43e888502abb802e250fb231a72

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
