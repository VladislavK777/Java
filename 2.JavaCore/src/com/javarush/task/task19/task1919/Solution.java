package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<String, Double>();
        while (reader.ready()) {
            String line = reader.readLine();
            String[] s = line.split(" ");
            double sum = 0d;
            if (map.get(s[0]) != null) {
                sum = map.get(s[0]) + Double.parseDouble(s[1]);
                map.put(s[0], sum);
            } else {
                sum = Double.parseDouble(s[1]);
                map.put(s[0], sum);
            }
        }
        for (Map.Entry<String, Double> p : map.entrySet()) {
            System.out.println(p.getKey() + " " + p.getValue());
        }
        reader.close();
    }
}
/*
Петров - 0
2 - 1
Сидоров - 3
6 - 4
Иванов - 5
1.35 - 6
Петров - 7
3.1*/
