package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String a=reader.readLine();
        String b=reader.readLine();
        String c=reader.readLine();
        int ar=Integer.parseInt(a);
        int br=Integer.parseInt(b);
        int cr=Integer.parseInt(c);
        if(ar==br && br!=cr)
            System.out.println(ar+" "+br);
        if(br==cr && cr!=ar)
            System.out.println(br+" "+cr);
        if(ar==cr && cr!=br)
            System.out.println(ar+" "+cr);
        if(ar==br && br==cr)
            System.out.print(ar+" "+br+" "+cr);
    }
}
