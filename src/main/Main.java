package main;

import javax.swing.*;

public class Main {

    public static void main(String[] args){

        JFrame windowMain= new JFrame();
        windowMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowMain.setResizable(false);
        windowMain.setTitle("2D GAME GO BRRRR");

        GamePanel gPanel = new GamePanel();

        windowMain.add(gPanel);
        windowMain.pack();
        windowMain.setLocationRelativeTo(null);
        windowMain.setVisible(true);

        gPanel.setupGame();
        gPanel.startGameThread();
    }

}
