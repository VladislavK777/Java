package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        while (reader.ready()) {
            String line = reader.readLine();
            String[] s = line.split(" ");
            for (String worlds : s) {
                Pattern pattern = Pattern.compile(".*\\d.*");
                Matcher matcher = pattern.matcher(worlds);
                if (matcher.find()) {
                    writer.write(worlds + " ");
                }
            }
        }
        reader.close();
        writer.close();
    }
}
