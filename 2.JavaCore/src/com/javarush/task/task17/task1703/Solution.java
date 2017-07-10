package com.javarush.task.task17.task1703;

import java.util.ArrayList;
import java.util.List;

/* 
Синхронизированные заметки
*/

public class Solution {

    public static void main(String[] args) {
        Note note = new Note(0, "первая");
        Note note1 = new Note(0, "первая1");
        note.start();
        note1.start();
        System.out.println(note.notes);
    }

    public static class Note extends Thread {
        String note;
        int index;

        public Note(int index, String note) {
            this.note = note;
            this.index = index;
        }

        public synchronized String getNote() {
            return note;
        }

        public synchronized int getIndex() {
            return index;
        }

        public final List<String> notes = new ArrayList<String>();

        public synchronized void addNote(int index, String note) {
            System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
            //synchronized (notes) {
                notes.add(index, note);
           // }
            System.out.println("Уже добавлена заметка [" + note + "]");
        }

        public synchronized void removeNote(int index) {
            System.out.println("Сейчас будет удалена заметка с позиции " + index);
            String note = "";
           // synchronized (notes) {
                note = notes.remove(index);
           // }
            System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
        }
        public void run() {
            addNote(getIndex(), getNote());
        }
    }

}
