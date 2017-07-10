package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        int min = 9999999;
        while (file.available() > 0){
            int a = file.read();
            if (a < min)min = a;
        }
        System.out.println(min);
        file.close();
    }
}
