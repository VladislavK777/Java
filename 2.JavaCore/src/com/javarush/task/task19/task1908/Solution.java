package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String f1 = rd.readLine();
        String f2 = rd.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(f1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(f2));
        while (reader.ready()) {
            String [] arr = reader.readLine().split(" ");
            for (String s: arr) {
                try {
                    writer.write(Integer.parseInt(s) + " ");
                }
                catch (Exception e) {
                }
            }
        }
        rd.close();
        reader.close();
        writer.close();
    }
}
//c:\Users\Vladislav.Klochkov\Desktop\JavaRush\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1908\test1.txt