package com.company;
import java.util.ArrayList;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        World world = World.buildWorld();
        Player player = new Player(100, 50, world);
        PlayerUI playerUI = PlayerUI.createUI(player);
        boolean quit = false;
        
        while(!quit) {
            quit = playerUI.input();
        }
    }
}

