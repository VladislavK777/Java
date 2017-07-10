package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
       /* String s = " 12. 23 3.4 4.5 56 fg fg7 5hj dfkjh 59 ";
        String a = s.replaceAll("\\.", "!");
        System.out.println(a);*/
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String f1 = rd.readLine();
        String f2 = rd.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(f1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(f2));
        String s = "";
        while (reader.ready()) {
            int date = reader.read();
            char c = (char) date;
            s += c;
        }
        String result = s.replaceAll("\\.", "!");
        writer.write(result);
        rd.close();
        reader.close();
        writer.close();
    }
}
//c:\Users\Vladislav.Klochkov\Desktop\JavaRush\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1909\test1.txt