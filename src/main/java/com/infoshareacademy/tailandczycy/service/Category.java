package com.infoshareacademy.tailandczycy.service;

import java.math.BigDecimal;

public class Category {

    private int id;
    private BigDecimal totalCash;
    private BigDecimal upperLimit;

    public Category(){
        totalCash = new BigDecimal(0.0);
    }
    public Category(BigDecimal bigDecimal){
        totalCash = bigDecimal;
    }

}
