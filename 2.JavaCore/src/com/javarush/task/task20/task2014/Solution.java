package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {

    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("c:\\Users\\Vladislav.Klochkov\\Desktop\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014\\test1.txt");
        FileInputStream fiStream = new FileInputStream("c:\\Users\\Vladislav.Klochkov\\Desktop\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014\\test1.txt");
        Solution solution = new Solution(4);
        solution.savedObject(fileOutput);

        Solution solution1 = new Solution(6);
        solution1.loadedObject(fiStream);

        if (solution.hashCode() == solution1.hashCode()) System.out.println(true);

        System.out.println(solution.string);
        System.out.println(solution1.string);

    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) throws FileNotFoundException {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    public void savedObject(FileOutputStream fileOutput) throws Exception {
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeChars(this.string);
        outputStream.close();
    }

    public void loadedObject(FileInputStream fiStream) throws Exception {
        ObjectInputStream inputStream= new ObjectInputStream(fiStream);
        this.string = inputStream.readLine();
        inputStream.close();
    }

    @Override
    public String toString() {
        return this.string;
    }

}
