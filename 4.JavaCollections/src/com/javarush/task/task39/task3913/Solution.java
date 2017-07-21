package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {
        LogParser logParser = new LogParser(Paths.get("c:/logs/"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
        Set<String> set = logParser.getIPsForEvent(Event.LOGIN, null, new Date());
        for (String s: set) System.out.println(s);
       /* System.out.println("-----after null-----");
        logParser.getUniqueIPs1("LOGIN",null, new Date());
        System.out.println("-----befor null-----");
        logParser.getUniqueIPs1("LOGIN", new Date(), null);
        System.out.println("-----null------");
        logParser.getUniqueIPs1("LOGIN", null, null);*/
    }
}