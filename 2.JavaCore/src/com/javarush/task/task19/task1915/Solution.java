package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());

        PrintStream consolStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        char[] chArray = result.toCharArray();
        System.setOut(consolStream);
        outputStream.writeTo(fileOutputStream);
        System.out.println(result);
        //fileOutputStream.write(buffer);
        reader.close();
        fileOutputStream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
//c:\Users\Vladislav.Klochkov\Desktop\JavaRush\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1915\test1.txt
