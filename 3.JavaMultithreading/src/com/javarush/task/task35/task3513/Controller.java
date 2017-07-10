package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Vladislav.Klochkov on 30.06.2017.
 */
public class Controller extends KeyAdapter {
    private static final int WINNING_TILE = 2048;
    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
    }

    public void resetGame() {
        model.score = 0;
        view.isGameWon = false;
        view.isGameLost = false;
        model.resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore() {
        return model.score;
    }

    public View getView() {
        return view;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) resetGame();
        if (!model.canMove()) view.isGameLost = true;
        if (!view.isGameLost & !view.isGameWon) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) model.left();
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT) model.right();
            else if (e.getKeyCode() == KeyEvent.VK_UP) model.up();
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) model.down();
            else if (e.getKeyCode() == KeyEvent.VK_Z) model.rollback();
            else if (e.getKeyCode() == KeyEvent.VK_R) model.randomMove();
            else if (e.getKeyCode() == KeyEvent.VK_A) model.autoMove();
        }
        if (model.maxTile == WINNING_TILE) view.isGameWon = true;
        view.repaint();
    }
}
