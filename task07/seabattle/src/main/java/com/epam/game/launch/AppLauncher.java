package com.epam.game.launch;

public class AppLauncher {

    public void launchRandom() {
        showInfo();
        GameProcess gameProcess = new GameProcess();
        gameProcess.process();
    }

    private void showInfo() {
        System.out.println("Welcome to the Sea Battle!");
        System.out.println();
        System.out.println("Commands possible at any time:");
        System.out.println("'Menu' - to enter this menu game.");
        System.out.println("'Quit' - to quit application.");
        System.out.println();
        System.out.println("Commands possible at the game:");
        System.out.println("'Fire A0' - to shoot the cell.");
        System.out.println("'Ships' - to show amount of enemy's ships that are alive.");
        System.out.println();
    }
}