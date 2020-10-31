package com.company;
import java.util.ArrayList;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Room> world = new ArrayList<Room>();
        world.add(new WestOfHouse());
        Player player = new Player();
        PlayerUI playerUI = PlayerUI.createUI(player);
        player.setLocation(world.get(0));
        boolean quit = false;
        
        while(!quit) {
            quit = playerUI.input(player);
        }
    }
}

abstract class Entity {
    protected String name;
    protected int hitPoints;
    protected int damageDealt;
    protected Room location;

    public String getName() { return name; }
    public int hitPoints() { return hitPoints; }
    // public Room getLocation() { return location; }
}