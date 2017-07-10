package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;/*
Какое сегодня число?
*/
import java.util.*;
import java.text.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        Date date = new Date(s);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        System.out.println(dateFormat.format(date).toUpperCase());
        //напишите тут ваш код
    }
}
