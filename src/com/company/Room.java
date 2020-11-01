package com.company;

import java.util.ArrayList;
import static java.lang.System.exit;

abstract class Room {
    //private ArrayList<Item> items;
    protected String name;
    protected String description;
    protected ArrayList<String> roomView;

    //ArrayList<Item> items = new ArrayList<Item>;
    //ArrayList<Monster> monsters = new ArrayList<Monster>;
    //ArrayList<StaticObjects> staticObjects = new ArrayList<StaticObjects>;
    protected ArrayList<Door> doors;
    protected ArrayList<String> targetsList;

    public Room() {
        this.name = new String();
        this.description = new String();
        this.roomView = new ArrayList<String>();
        this.doors = new ArrayList<Door>();
        this.targetsList = new ArrayList<String>();
    }
    public String getName() { return this.name; }
    public ArrayList<String> getTargets() {
        targetsList.clear();
        /*  Add all elements of lists of objects from Room, providing
        a means to search for the intended target by calling
        toString (in PlayerUI) for all potential targets in the room
        */
        for (Door door : doors) {
            targetsList.add(door.toString());
        }
        // We can copy/modify this for loop to add any list of targets/entities/objects in the room
        if (targetsList.isEmpty()) {
            System.err.println("ERROR ROOM::getTargets()::Room must have at least one viable target");
            exit(1);
        }
        return targetsList;
    };

    public void look() {
        for (String s : roomView) {
            System.out.println(s);
        }
    }

    public class Door {
        private String string = new String();
        private String destinationName = new String();
        private Room destination;
        private boolean locked;
        private String lockedMsg = new String();
        public Door(String string, String destinationName, boolean locked) {
            this.string = string;
            this.destinationName = destinationName;
            this.locked = locked;
        }
        public Room enter(World world) {
            for (Room room : world.getRooms()) {
                if (destinationName.equals(room.getName())) {
                    this.destination = room;
                }
            }
            return destination;
        }
        public boolean isLocked() {
            return locked;
        }
        public void setLockedMsg(String lockedMsg) {
            this.lockedMsg = lockedMsg;
        }
        public String getLockedMsg() {
            return lockedMsg;
        }

        public String toString() { return string; }
    }
}

class WestOfHouse extends Room {

    public WestOfHouse() {
        super();
        this.name = "West of House";
        this.description = "This is an open field west of a white house, with a boarded front door.\n"
        + "There is a small mailbox here.\n"
        + "A rubber mat saying 'Welcome to Zork!' lies by the door.\n";
        roomView.add(name);
        this.roomView.add(description);

        this.doors.add(new Door("north", "North of House", false));
        this.doors.add(new Door("east", " ", true));
        this.doors.get(1).setLockedMsg("The door is boarded and you can't remove the boards.");

    }
}

class NorthOfHouse extends Room {

    public NorthOfHouse() {
        this.name = "North of House";
        this.description = "You are facing the north side of a white house.\n"
                + "There is no door here, and all the windows are boarded up. \n"
                + "To the north a narrow path winds through the trees.\n";
        this.roomView.add(name);
        this.roomView.add(description);

        this.doors.add(new Door("west", "West of House", false));
    }
}