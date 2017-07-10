package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader_org = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader fileReader_edit = new BufferedReader(new FileReader(reader.readLine()));
        ArrayList<String> org = new ArrayList<>();
        ArrayList<String> edit = new ArrayList<>();
        while (fileReader_org.ready()) {
            org.add(fileReader_org.readLine());
        }
        while (fileReader_edit.ready()) {
            edit.add(fileReader_edit.readLine());
        }
        reader.close();
        fileReader_org.close();
        fileReader_edit.close();
        int j = 0;
        for (int i = 0; i < org.size(); i++){
            if (j >= edit.size()) {
                lines.add(new LineItem(Type.REMOVED, org.get(i)));

                break;
            } else
            if (org.get(i).equals(edit.get(j))) {
                lines.add(new LineItem(Type.SAME, org.get(i)));
                j++;
            } else
            if (j < (edit.size() - 1) && org.get(i).equals(edit.get(j + 1))) {
                lines.add(new LineItem(Type.ADDED, edit.get(j)));

                j++;
                i--;
            } else
            if (i < (org.size() - 1) && org.get(i + 1).equals(edit.get(j))) {
                lines.add(new LineItem(Type.REMOVED, org.get(i)));

            }
        }
        if (lines.get(lines.size() - 1).type == Type.SAME && j <= (edit.size() - 1) ) {
            lines.add(new LineItem(Type.ADDED, edit.get(j)));

        }
        for (LineItem ii : lines) {
            System.out.println(ii.type + " " + ii.line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
/*
c:\Users\Vladislav.Klochkov\Desktop\JavaRush\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1916\test1.txt
c:\Users\Vladislav.Klochkov\Desktop\JavaRush\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1916\test2.txt
*/