package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(name));
        String line = bufferedReader.readLine();
        String s = "";
        while (line != null) {
            s += line + " ";
            line = bufferedReader.readLine();
        }
        StringBuilder result = new StringBuilder(s);
        result = getLine(result.toString().split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0)
            return new StringBuilder();
        if ("".equals(words[0]) || words.length == 1)
            return new StringBuilder(words[0]);

        List<String> list = new ArrayList<>();
        for (String l : words) {
            list.add(l);
        }

        boolean isCorrect;
        int a = 0;
        while (true) {
            Collections.shuffle(list);
            isCorrect = true;
            for (int i = 0; i < list.size(); i++) {
                if (i + 1 != list.size()) {
                    if (!list.get(i).substring(list.get(i).length() - 1).equalsIgnoreCase(list.get(i + 1).substring(0, 1))) {
                        isCorrect = false;
                        break;
                    }
                }
            }
            if(isCorrect)
                break;
        }

        StringBuilder result = new StringBuilder("");
        result.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            result.append(" " + list.get(i));
        }


        return result;
    }
}


//c:\Users\Vladislav.Klochkov\Desktop\JavaRush\JavaRushTasks\3.JavaMultithreading\src\com\javarush\task\task22\task2209\test1.txt
