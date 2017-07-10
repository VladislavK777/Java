package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
        map.put(13, "тринадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(name));
        reader.close();
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] s = line.split(" ");
            for (int i = 0; i < s.length; i++) {
                Pattern pattern = Pattern.compile("(?<!\\w)\\d+(?!\\w)");
                Matcher matcher = pattern.matcher(s[i]);
                if (matcher.find()) {
                    int word = Integer.parseInt(s[i]);
                    for (Map.Entry<Integer, String> p : map.entrySet()) {
                        if (p.getKey().equals(word)) {
                            s[i] = p.getValue();
                        }
                    }
                }
            }
            StringBuilder res = new StringBuilder();
            for(String t : s) res.append(t).append(" ");
            String out = res.delete(res.length()-1, res.length()).toString();
            System.out.println(out);
        }
        fileReader.close();
    }
}
//c:\Users\Vladislav.Klochkov\Desktop\JavaRush\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1924\test1.txt