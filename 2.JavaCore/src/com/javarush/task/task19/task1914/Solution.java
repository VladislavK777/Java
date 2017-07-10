package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consolStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consolStream);
        String[] s = result.split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[2]);
        int c = 0;
        if (s[1].equals("+")) {
            c = a + b;
        } else if (s[1].equals("-")) {
            c = a + b;
        } else if (s[1].equals("*")) {
            c = a * b;
        }
        String sNew = s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " " + c;
        System.out.println(sNew);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

