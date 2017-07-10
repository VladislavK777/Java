package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       // String fileName = reader.readLine();
        //reader.close();
        BufferedReader fr = new BufferedReader(new FileReader("c:\\Users\\Vladislav.Klochkov\\Desktop\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1918\\test1.txt"));
        String text = "";
        String forPrint = "";
        while (fr.ready()) {
            text += fr.readLine();//читаем всё в линию, без учёта новых строк, получается одна строка.
        }
        System.out.println("text1: " + text);
        fr.close();
        while (text.contains("<" + args[0])) {
            text = text.substring(text.indexOf("<" + args[0])); //отрезаем по первый открывающий тег
            System.out.println("text2: " + text);
           String tmp = extractTag(text, args[0]); //получаем строку с вложенными тегами если есть
            System.out.println("tmp: " + tmp);
           forPrint += tmp + System.getProperty("line.separator"); //записываем строку на печать в консоль
            text = text.substring(args[0].length()); //обрезаем у текста первый открывающий тег
            System.out.println("text3: " + text);

        }
        //System.out.println(forPrint.trim());
    }

    public static String extractTag(String text, String tag) {
        int tagFirstTag = text.indexOf("<" + tag); //индекс первого тега
        int tagBegin = text.indexOf("<" + tag);//индекс текущего учтёного вложения
        int tagEnd = text.indexOf("/" + tag + ">") + tag.length() + 2;//индекс закрывающего тега

        //пока подстрока содержит открывающие теги двигаем индекс закрывающего тега на количество открывающих через мнимое обрезание строки (то есть строку не обрезаем, чтобы ее блину не потерять, а выцепляем подстроку)
        while (text.substring(tagBegin + tag.length(), tagEnd).contains("<" + tag)) { // n xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
            tagBegin += text.substring(tagBegin + tag.length(), tagEnd).indexOf(("<" + tag)) + tag.length(); //33
            tagEnd += text.substring(tagEnd).indexOf(("/" + tag + ">")) + tag.length() + 2;
        }
        return text.substring(tagFirstTag, tagEnd);
    }
}
