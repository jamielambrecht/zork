package com.company;

import java.util.ArrayList;

public class World {
    private static World instance;
    private ArrayList<Room> rooms = new ArrayList<Room>();

    private World() {
        rooms.add(new WestOfHouse());
        rooms.add(new NorthOfHouse());
        rooms.add(new EastOfHouse());
        rooms.add(new NorthernForest());
        rooms.add(new Kitchen());
        rooms.add(new LivingRoom());
        rooms.add(new Upstairs());
    }

    public static World buildWorld() {
        if (instance == null) {
            instance = new World();
        }
        return instance;
    }

    public ArrayList<Room> getRooms() { return this.rooms; }
}
