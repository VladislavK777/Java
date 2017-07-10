package com.javarush.task.task14.task1401;

/* 
Bingo!
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws ParseException {
        Date bd = new SimpleDateFormat("dd-MM-yyyy").parse("17/07/1988");
        System.out.println(bd);
    }



}
