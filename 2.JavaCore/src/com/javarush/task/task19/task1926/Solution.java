package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            StringBuilder stringBuilder = new StringBuilder(line);
            System.out.println(stringBuilder.reverse());
        }
        fileReader.close();
    }
}
//c:\Users\Vladislav.Klochkov\Desktop\JavaRush\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1926\test1.txt