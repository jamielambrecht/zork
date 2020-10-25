package com.company;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {



    }
}

class World {
    public void World() {

    }
}

interface RoomFactory {


}


abstract class Room {
    // Each Room is a "Singleton"
    private static Room uniqueInstance;
    //ArrayList<Item> getItems();
}

class ExampleRoom extends Room {
    private ExampleRoom() {
    }

    static public Room getInstance() {
        if (uniqueInstance == null) {
                uniqueInstance = new ExampleRoom();
        }
        return uniqueInstance;
    }
}

class Door {


}

class Wall {


}

class WestOfHouse extends Room {
    public void WestOfHouse() {

    }
}

class Player {
    int playerHP;
    public void Player() {
        this(15, null);
    }
    public void Player(int playerHP, Room location) {
        this.playerHP = playerHP;
        this.location = location;
    }


    Room location = new Room();
    void look() { }
    void take() { }
}



