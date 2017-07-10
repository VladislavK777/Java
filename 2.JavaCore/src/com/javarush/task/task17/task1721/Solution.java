package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name1 = reader.readLine();
            String name2 = reader.readLine();
            BufferedReader file1 = new BufferedReader(new FileReader(name1));
            BufferedReader file2 = new BufferedReader(new FileReader(name2));
            String line1;
            String line2;
            while ((line1 = file1.readLine()) != null) {
                allLines.add(line1);
            }
            while ((line2 = file2.readLine()) != null) {
                forRemoveLines.add(line2);
            }
            file1.close();
            file2.close();
            Solution solution = new Solution();
            solution.joinData();
        } catch (CorruptedDataException e) {
            System.out.println("Файл 2 не содержит строки из файла 1");
        }
    }

    public void joinData () throws CorruptedDataException, IOException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            if (allLines.size() > 0) {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
    }
}
