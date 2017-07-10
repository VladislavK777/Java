package com.javarush.task.task19.task1904;

/*
И еще один адаптер
*/

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;
        PersonScannerAdapter (Scanner scanner) {
            this.fileScanner = scanner;
        }

        public void close() {
            this.fileScanner.close();
        }

        public Person read() throws FileNotFoundException, IOException, ParseException {
            BufferedReader reader = new BufferedReader(new FileReader(new File("c:\\Users\\Vladislav.Klochkov\\Desktop\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1904\\test1.txt")));
            String line;
            line = reader.readLine();
            String[] s = line.split(" ");
            String sd = s[3] + "." + s[4] + "." + s[5];
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            Date date = format.parse(sd);
            return new Person(s[1], s[2], s[0], date);
        }
    }
}
