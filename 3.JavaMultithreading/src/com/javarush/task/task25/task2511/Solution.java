package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String message = e.getMessage();
                String name = Thread.currentThread().getName();
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < name.length(); i++) {
                    s.append("*");
                }
                message= message.replaceAll(name, s.toString());
                System.out.println(message);
            }
        }
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new MyUncaughtExceptionHandler();    //init handler here

    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {

    }
}