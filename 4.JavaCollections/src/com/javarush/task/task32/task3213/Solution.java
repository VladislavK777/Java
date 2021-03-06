package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        try {
            int i = 0;
            String result = new String();
            while ((i = reader.read()) != -1) {
                result += String.valueOf((char) (i + key));
            }
            return result;
        } catch (Exception e) {
            return "Error";
        }
    }
}
