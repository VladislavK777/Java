package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladislav.Klochkov on 30.05.2017.
 */
public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).move();
        }

    }

    public void print() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        double tmp = horses.get(0).getDistance();
        int indexWinner = 0;
        for (int i = 1; i < horses.size(); i++) {
            if (tmp < horses.get(i).getDistance()) {
                tmp = horses.get(i).getDistance();
                indexWinner = i;
            }
        }
        return horses.get(indexWinner);
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());
        Horse Kasper = new Horse("Kasper", 3, 0);
        Horse Bell = new Horse("Bell", 3, 0);
        Horse Poll = new Horse("Poll", 3, 0);
        game.getHorses().add(Kasper);
        game.getHorses().add(Bell);
        game.getHorses().add(Poll);
        game.run();
        game.printWinner();
    }
}
