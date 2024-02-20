package com.mycompany.s104junit1;
import java.util.ArrayList;
import java.util.Arrays;

public class MonthList {
    private final ArrayList<String> months;

    public MonthList() {
        months = new ArrayList<>();
        initializeMonths();
    }

    private void initializeMonths() {
        
        String[] list = {"January", "February", "March", "April", "May", "June", 
            "July", "August", "September", "October", "November", "December"};
        months.addAll(Arrays.asList(list));
    }
    
    public ArrayList<String> getMonths() {
        return months;
    }
}