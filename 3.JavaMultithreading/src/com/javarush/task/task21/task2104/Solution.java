package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/*
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Overrid
    public boolean equals(Object n) {
        if (n == null || n.getClass() != this.getClass()) {
            return false;
        }

        if (n == this) {
            return true;
        }

        if (n instanceof Solution) {
            return true;
        }

        Solution s = (Solution) n;

        return s.first == first && s.last == last;
    }


    @Overrid
    public int hashCode() {
        int result = 24;
        result = 31 * result + (first == null ? 0 : first.hashCode() + (last == null ? 0 : last.hashCode()));
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
