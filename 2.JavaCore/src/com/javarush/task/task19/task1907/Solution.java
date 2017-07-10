package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();
        int count = 0;
        String s = "";
        while (fileReader.ready()) {
            int d = fileReader.read();
            char c = (char) d;
            s += String.valueOf(c) + '.';
        }
        String[] w = s.split(", ");
        for (int i = 0; i < w.length; i++) {
            if (w[i].equals("world")) {
                count++;
            }
        }
        System.out.println(count);
        fileReader.close();
    }
}

//c:\Users\Vladislav.Klochkov\Desktop\JavaRush\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1907\test1.txt
