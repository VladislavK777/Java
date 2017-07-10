package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        BufferedReader reader1 = new BufferedReader(new FileReader(name));
        reader.close();
        while (reader1.ready()){
            int count = 0;
            String line = reader1.readLine();
            String[] s = line.split(" ");
            for (String word : s) {
                for (String simple : words) {
                    if (word.equals(simple)) {
                        count++;
                    }
                }
            }
            if (count == 2) {
                System.out.println(line);
            }
        }
        reader1.close();
    }
}

//c:\Users\Vladislav.Klochkov\Desktop\JavaRush\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1922\test1.txt