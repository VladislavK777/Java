package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(name));
        String line = bufferedReader.readLine();
        String s = "";
      //  Map<String, String> map = new HashMap<String, String>();
        while (line != null) {
            s += line + " ";
            //System.out.println(line);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        // System.out.println(s);
        String[] s1 = s.split(" ");
       // int a = 0;
        for (int i = 0; i < s1.length; i++) {
            try {
                StringBuilder stringBuilder = new StringBuilder(s1[i]);
                String total = stringBuilder.reverse().toString();
                // System.out.println("i= " + i + " " + total);
                for (int j = i + 1; j < s1.length; j++) {
                    try {
                        if (s1[j].equals(total)) {
                            //map.put(s1[i], s1[j]);
                           // System.out.println("i= " + i + " si= " + s1[i] + " total " + total + " j=" + j + " sj= " + s1[j]);
                            Pair pair = new Pair();
                            pair.first = s1[i];
                            pair.second = s1[j];
                            result.add(pair);
                            //a = j;
                            s1[j] = null;
                            break;
                        }
                    } catch (NullPointerException e) {

                    }
                }
            } catch (NullPointerException e) {

            }
        }
        /*for (Map.Entry<String, String> p : map.entrySet()) {
            Pair pair = new Pair();
            pair.first = p.getValue();
            pair.second = p.getKey();
            result.add(pair);
        }*/
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString());
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}

//c:\Users\Vladislav.Klochkov\Desktop\JavaRush\JavaRushTasks\3.JavaMultithreading\src\com\javarush\task\task22\task2207\test1.txt
