package com.company;

import java.util.ArrayList;
import static java.lang.System.exit;

abstract class Room {
    protected String name;
    protected String description;
    protected ArrayList<String> roomView;

    ArrayList<Item> items = new ArrayList<Item>();
    ArrayList<StaticObject> staticObjects = new ArrayList<StaticObject>();
    private Enemy enemy;
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
            for (String s : door.getIdentifiers()) {
                targetsList.add(s);
            }
        }
        for (StaticObject obj : staticObjects) {
            for (String s : obj.getIdentifiers()) {
                targetsList.add(s);
            }
        }
        for (Item item : items) {
            for (String s : item.getIdentifiers()) {
                targetsList.add(s);
            }
        }
        if (this.enemy != null) {
            targetsList.add(enemy.toString());
        }
        // We can copy/modify the previous for loop to add any list of targets/entities/objects in the room
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
        for (Room.Item item : this.items) {
            System.out.println(item.lookString());
        }
        if (this.enemy != null) {
            System.out.println(enemy.lookString());
        }
    }

    public Item take(String target) {
        Item returnedItem = null;
        for (Item item : items) {
            for (String s : item.getIdentifiers()) {
                if (target.equals(s)) {
                    returnedItem = item;
                    for (StaticObject obj : staticObjects) {
                        if (obj.containedItem.equals(item)) {
                            obj.containedItem = null;
                        }
                    }
                }
            }
        }
        if (returnedItem != null) {
            items.remove(returnedItem);
            System.out.println(String.format("Took the %s", returnedItem.getName()));
        }
        return returnedItem;
    }

    public class Door {
        private ArrayList<String> identifiers = new ArrayList<String>();
        private String string = new String();
        private String destinationName = new String();
        private Room destination;
        private boolean locked;
        private boolean open = true;
        private String lockedMsg = new String();
        private String closedMsg = new String();
        private String openLockedMsg = new String();
        private String openMsg = new String();
        public Door(String string, String destinationName, boolean locked) {
            this.string = string;
            this.identifiers.add(this.string);
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
        public void open() {
            if (!isOpen()) {
                if (!isLocked()) {
                    System.out.println(openMsg);
                    this.setOpen(true);
                } else {
                    System.out.println(lockedMsg);
                }
            }
        }
        public boolean isLocked() {
            return locked;
        }
        public boolean isOpen() {
            return open;
        }
        public void setOpen(boolean open) {
            this.open = open;
        }
        public void setLockedMsg(String message) {
            this.lockedMsg = message;
        }
        public void setClosedMsg(String message) {
            this.closedMsg = message;
        }
        public void setOpenLockedMsg(String message) {
            this.openLockedMsg = message;
        }
        public void setOpenMsg(String message) {
            this.openMsg = message;
        }
        public String getLockedMsg() {
            return lockedMsg;
        }
        public String getClosedMsg() {
            return closedMsg;
        }
        public void addIdentifier(String s) {
            this.identifiers.add(s);
        }
        public ArrayList<String> getIdentifiers() {
            return this.identifiers;
        }
    }

    public class StaticObject {
        private ArrayList<String> identifiers = new ArrayList<String>();
        private Item containedItem;
        private String name = new String();
        private boolean locked;
        private boolean open;
        private String lockedMsg = new String();
        private String openLockedMsg = new String();
        private String openMsg = new String();
        public StaticObject(String name, boolean locked, Item containedItem) {
            this.name = name;
            this.identifiers.add(this.name);
            this.locked = locked;
            this.containedItem = containedItem;
            this.open = false;
        }
        public void open() {
            if (!isOpen()) {
                if (!isLocked()) {
                    System.out.println(getOpenMsg());
                    this.open = true;
                    if (containedItem != null) {
                        items.add(containedItem);
                    }
                } else {
                    System.out.println(openLockedMsg);
                }
            } else {
                System.out.println("It is already open!");
            }
        }
        //  Mutators =====================================
        public void setLockedMsg(String message) {
            this.lockedMsg = message;
        }
        public void setOpenLockedMsg(String message) {
            this.openLockedMsg = message;
        }
        public void setOpenMsg(String message) {
            this.openMsg = message;
        }
        public String setOpenMsg() {
            return this.openMsg;
        }
        //  Accessors =====================================
        public boolean isLocked() {
            return locked;
        }
        public boolean isOpen() {
            return open;
        }
        public String getLockedMsg() {
            return this.lockedMsg;
        }
        public String getOpenMsg() {
            return this.openMsg;
        }
        public void addIdentifier(String s) {
            this.identifiers.add(s);
        }
        public ArrayList<String> getIdentifiers() {
            return this.identifiers;
        }
    }

    public class Item {
        protected ArrayList<String> identifiers = new ArrayList<String>();
        protected String name = new String();

        public Item() {}
        public Item(String name) {
            this.name = name;
            this.identifiers.add(this.name);
        }
        public void open() {
            System.out.println("You can't open that!");
        }
        public void addIdentifier(String s) {
            this.identifiers.add(s);
        }
        public ArrayList<String> getIdentifiers() {
            return this.identifiers;
        }
        public String getName() {
            return this.name;
        }
        public void read() {
            System.out.println("Cannot read this!");
        }
        public String lookString() {return new String(); }
    }

    class LeafletItem extends Item {
        public LeafletItem() {
            this.name = "leaflet";
            this.addIdentifier(this.name);
        };
        @Override
        public void read() {
            System.out.println(this.toString());
        }
        @Override
        public String toString() {
            return "WELCOME TO ZORK!\n" +
                    "\n" +
                    "ZORK is a game of adventure, danger, and low cunning. In it you will explore some of the most amazing territory ever seen by mortals. No computer should be without one!\n";
        }
        @Override
        public String lookString() { return "There is a leaflet in this room."; };
    }

    class SackOfPeppersItem extends Item {
        public SackOfPeppersItem() {
            this.name = "sack";
            this.addIdentifier(this.name);
        };
        @Override
        public void read() {
            System.out.println(this.toString());
        }
        @Override
        public String toString() {
            return "Read a sack of peppers?";
        }
        @Override
        public String lookString() { return "On the table is an elongated brown sack, smelling of hot peppers."; };
    }

    class WaterBottleItem extends Item {
        public WaterBottleItem() {
            this.name = "bottle";
            this.addIdentifier(this.name);
        };
        @Override
        public void read() {
            System.out.println(this.toString());
        }
        @Override
        public String toString() {
            return "Read a water bottle?";
        }
        @Override
        public String lookString() { return "A bottle is sitting on the table.\n" +
                "The glass bottle contains:\n" +
                "A quantity of water"; };
    }

    class ElvishSword extends Item {
        public ElvishSword() {
            this.name = "sword";
            this.addIdentifier(this.name);
        };
        @Override
        public void read() {
            System.out.println(this.toString());
        }
        @Override
        public String toString() {
            return "Read a sword?";
        }
        @Override
        public String lookString() { return "Above the trophy case hangs an elvish sword of great antiquity."; };
    }

    class Lantern extends Item {
        public Lantern() {
            this.name = "lantern";
            this.addIdentifier(this.name);
        };
        @Override
        public void read() {
            System.out.println(this.toString());
        }
        @Override
        public String toString() {
            return "Read a lantern?";
        }
        @Override
        public String lookString() { return "A battery-powered brass lantern is on the trophy case."; };
    }


    public class Enemy {
        private String name;
        private int health;
        private int damageDealt;
        protected boolean isDead = false;

        public Enemy(String name, int health, int damageDealt) {
            this.name = name;
            this.health = health;
            this.damageDealt = damageDealt;
        }

        public int getHealth() {
            return this.health;
        }
        public int getDamageDealt() {
            return this.damageDealt;
        }
        public void setHealth(int value) {
            this.health = value;
        }

        public boolean fight(Player player) {
            Combat battle = new Combat(player, this);
            boolean quitFlag = battle.fight();
            if (this.isDead) {
                setEnemy(null);
            }
            return quitFlag;
        }

        public String lookString() {
            return "There is a " + this.toString() + " here.";
        }
        @Override
        public String toString() {
            return this.name;
        }
    }

    public void setEnemy(Enemy enemy) { this.enemy = enemy; }
    public Enemy getEnemy() { return this.enemy; }
}

class WestOfHouse extends Room {

    public WestOfHouse() {
        super();
        this.name = "West of House";
        this.description = "This is an open field west of a white house, with a boarded front door.\n"
        + "There is a small mailbox here.\n"
        + "A rubber mat saying 'Welcome to Zork!' lies by the door.";
        roomView.add(name);
        this.roomView.add(description);

        this.doors.add(new Door("north", "North of House", false));

        this.doors.add(new Door("east", " ", true));
        this.doors.get(1).addIdentifier("door");
        this.doors.get(1).setOpen(false);
        this.doors.get(1).setClosedMsg("The door is boarded and you can't remove the boards.");
        this.doors.get(1).setLockedMsg("The door cannot be opened.");

        this.staticObjects.add(new StaticObject("mailbox", false, new LeafletItem()));
        this.staticObjects.get(0).setOpenMsg("Opening the small mailbox reveals a leaflet.");
    }
}

class NorthOfHouse extends Room {

    public NorthOfHouse() {
        this.name = "North of House";
        this.description = "You are facing the north side of a white house.\n"
                + "There is no door here, and all the windows are boarded up. \n"
                + "To the north a narrow path winds through the trees.";
        this.roomView.add(name);
        this.roomView.add(description);

        this.doors.add(new Door("west", "West of House", false));
        this.doors.add(new Door("north", "Northern Forest", false));
        this.doors.add(new Door("east", "East of House", false));
    }
}

class EastOfHouse extends Room {

    public EastOfHouse() {
        this.name = "East of House";
        this.description = "You are behind the white house.\n"
                + "A path leads into the forest to the east.\n"
                + "In one corner of the house there is a small window which is slightly ajar.";
        this.roomView.add(name);
        this.roomView.add(description);

        this.doors.add(new Door("north", "North of House", false));
        this.doors.add(new Door("west", "Kitchen", false));
        this.doors.get(1).addIdentifier("window");
        this.doors.get(1).setOpen(false);
        this.doors.get(1).setClosedMsg("The kitchen window is closed.");
        this.doors.get(1).setOpenMsg("With great effort, you open the window far enough to allow entry.");
    }
}

class NorthernForest extends Room {

    public NorthernForest() {
        this.name = "Northern Forest";
        this.description = "You are in the forest north of the house.\n"
                + "There is a path to the south.";
        this.setEnemy(new Enemy("skeleton", 75, 25));

        this.roomView.add(name);
        this.roomView.add(description);

        this.doors.add(new Door("south", "North of House", false));
    }
}

class Kitchen extends Room {

    public Kitchen() {
        this.name = "Kitchen";
        this.description = "You are in the kitchen of the white house.\n"
                + "A table seems to have been used recently for the preparation of food.\n"
                + "A passage leads to the west and a dark staircase can be seen leading upward.\n"
                + "A dark chimney leads down and to the east is a small window which is open.";

        this.roomView.add(name);
        this.roomView.add(description);

        this.doors.add(new Door("east", "East of House", false));
        this.doors.add(new Door("west", "Living Room", false));

        this.items.add(new SackOfPeppersItem());
        this.items.get(0).addIdentifier("peppers");

        this.items.add(new WaterBottleItem());
        this.items.get(1).addIdentifier("water");

    }
}

class LivingRoom extends Room {

    public LivingRoom() {
        this.name = "Living Room";
        this.description = "You are in the living room.\n"
            + "There is a doorway to the east, a wooden door\n"
            + "with strange gothic lettering to the west, which appears to be nailed shut,\n"
            + "a trophy case, and a large oriental rug in the center of the room.";

        this.roomView.add(name);
        this.roomView.add(description);

        this.doors.add(new Door("east", "Kitchen", false));

        this.items.add(new ElvishSword());
        this.items.add(new Lantern());

    }
}
