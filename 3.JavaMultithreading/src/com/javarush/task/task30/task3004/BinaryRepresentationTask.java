package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Vladislav.Klochkov on 29.06.2017.
 */
public class BinaryRepresentationTask extends RecursiveTask<String> {
    private int i;
    public BinaryRepresentationTask(int i) {
        this.i = i;
    }

    private String binaryRepresentationMethod(int x) {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            return binaryRepresentationMethod(b) + result;
        }
        return result;
    }

    @Override
    protected String compute() {
        boolean isTrue = false;
        if (isTrue) {
            fork();
            join();
        }
        return binaryRepresentationMethod(i);
    }
}
