package com.mycompany.s104junit1;

//@author Geremias Bristot

import java.util.ArrayList;

public class S104JUnit1 {

    public static void main(String[] args) {
        MonthList monthList = new MonthList();
        ArrayList<String> months = monthList.getMonths();
        
        for (String month : months) {
            System.out.println(month);
        }
    }
    
}