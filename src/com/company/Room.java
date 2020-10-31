package com.company;

import java.util.ArrayList;

abstract class Room {
    //private ArrayList<Item> items;
    String name;
    String description;
    ArrayList<String> roomView;
    ArrayList<Object> targetsList;

    abstract public void look();
    abstract ArrayList<Object> getTargets();
}

class WestOfHouse extends Room {
    public WestOfHouse() {
        name = "West of House";
        description = "This is an open field west of a white house, with a boarded front door.\n" 
        + "There is a small mailbox here.\n"
        + "A rubber mat saying 'Welcome to Zork!' lies by the door.\n";
        roomView = new ArrayList<String>();
        roomView.add(name);
        roomView.add(description);
    }

    public void look() { 
      for (String s : roomView) {
        System.out.println(s);
      }
    };

    public ArrayList<Object> getTargets() { 
        //targetsList.clear();
        /*  Add all elements of lists of objects from Room, providing
            a means to search for the intended target by calling 
            toString (in PlayerUI) for all potential targets in the room
        */
        return targetsList;
      };
}