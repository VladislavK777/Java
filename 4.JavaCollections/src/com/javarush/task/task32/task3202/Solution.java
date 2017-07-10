package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("C:\\Users\\Vladislav.Klochkov\\Desktop\\JavaRush\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task32\\task3202\\file.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        try {
            StringWriter writer = new StringWriter();
            byte[] buffer = new byte[is.available()];
            while (is.available() > 0) {
                is.read(buffer);
            }
            writer.write(new String(buffer));
            is.close();
            writer.close();
            return writer;
        } catch (Exception e) {
            return new StringWriter();
        }
    }
}