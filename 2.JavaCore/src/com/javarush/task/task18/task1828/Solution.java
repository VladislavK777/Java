package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerName = new BufferedReader(new InputStreamReader(System.in));
        String name = readerName.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(new File(name)));
        List<String> list = new ArrayList();
        while (reader.ready()) {
            list.add(String.format("%s%n", reader.readLine()));
        }
        switch (args[0]) {
            case "-d":
                for (int i = 0; i < list.size(); i++) {
                    String str = String.valueOf(list.get(i));
                    if (str.substring(0,8).trim().equals(args[1])) {
                        list.remove(i);
                    }
                }
                break;
            case "-u":
                for (int i = 0; i < list.size(); i++) {
                    String str = String.valueOf(list.get(i));
                    if (str.substring(0,8).trim().equals(args[1])) {
                        String s = args[2];
                        for (int k = 3; k < args.length - 2; k++) {
                            s += " " + args[k];
                        }
                        list.set(i, String.format("%-8s%-30s%-8s%-4s%n", args[1].trim() + " ", s.trim() + " ", args[args.length - 2].trim() + " ", args[args.length - 1].trim()));
                    }
                }
                break;

        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(name));
        for (String s : list) {
            bufferedWriter.write(s);
        }
        reader.close();
        bufferedWriter.close();
    }
}

//c:\Users\Vladislav.Klochkov\Desktop\JavaRush\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1828\test1.txt