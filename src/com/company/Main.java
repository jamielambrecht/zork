package com.company;
import java.util.ArrayList;
import java.io.*;

public class Main {
        public static void main(String[] args) {
        PlayerUI playerUI = PlayerUI.createUI();

        // Todo : instantiate rooms,
		/* Plan of Action
		 - Call MazeBuilder or MazeFactory to build your maze
		 	 - Rooms made :)
			 - One room is called Room westOfHouse = new Room("West of House" //...)
		 - Call Player constructor, and put the player in a rooms
			 - Player player = new Player(15, 5, westOfHouse);
			 								OR YOU CAN DO
			 - Or you can do: Player player = new Player();
			 - player.setLocation(westOfHouse);
		 - Create all initial objects in each room
		*/


        playerUI.input();

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

interface RoomFactory {

}

abstract class Room {
    // private ArrayList<Item> items;
    String name;
    String description;
    public Room() {};

    //ArrayList<Item> getItems();
    
}

class WestOfHouse extends Room {
    public WestOfHouse() {
        name = "West of House";
        description = ""
        ArrayList<String> roomView = new ArrayList<String>();

    }
}


