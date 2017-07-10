package com.javarush.task.task19.task1913;


/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        /*String s = "it's 1 a 23 text 4 f5-6or7 tes8ting";
        String pattern = "\\d";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);
        StringBuilder sb2 = new StringBuilder();
        while (m.find()) {
            String nomber;
            nomber = s.substring(m.start(), m.end());
            sb2.append(nomber);
        }
        System.out.println(sb2);*/
        PrintStream consolStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consolStream);
        System.out.println(outputStream.toString().replaceAll("\\D",""));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
