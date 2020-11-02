package com.company;
import java.util.Scanner;

import static java.lang.System.exit;

abstract public class Command {
    protected Player player;
    public Command(Player player) { this.player = player; };
    abstract public boolean execute(String target);
}

class LookCommand extends Command {

    public LookCommand(Player player) { super(player); }
    public boolean execute(String target) {
        this.player.getLocation().look();
        return false;
    }
    public String toString() {
        return "look";
    }
}
class GoCommand extends Command {
    public GoCommand(Player player) { super(player); }

    public boolean execute(String target) {
        if (target != null) {
            if (target.isBlank() || target == null) {
                System.out.println("Where to?");
            }
            for (Room.Door door : player.getLocation().doors) {
                for (String s : door.getIdentifiers()) {
                    if (target.equals(s)) {
                        if (door.isOpen() && !door.isLocked()) {
                            player.setLocation(door.enter(player.world));
                            player.getLocation().look();
                        } else {
                            System.out.println(door.getClosedMsg());
                        }
                    }
                }
            }
        } else {
            System.out.println("I don't know where that is.");
        }
        return false;
    };
    public String toString() { return "go"; };
}
class OpenCommand extends Command {
    public OpenCommand(Player player) { super(player); }

    public boolean execute(String target) {
        if (target != null) {
            for (Room.Door door : player.getLocation().doors) {
                for (String s : door.getIdentifiers()) {
                    if (target.equals(s)) {
                        door.open(player);
                    }
                }
            }
            for (Room.StaticObject obj : player.getLocation().staticObjects) {
                for (String s : obj.getIdentifiers()) {
                    if (target.equals(s)) {
                        obj.open(player);
                    }
                }
            }
        }
        return false;
    };

    public String toString() { return "open"; }
}
class InventoryCommand extends Command {
    public InventoryCommand(Player player) { super(player); }
    public boolean execute(String target) {
        player.getInventory().display();
        return false;
    };

    public String toString() { return "inventory"; }
}
class TakeCommand extends Command {
    public TakeCommand(Player player) { super(player); }
    public boolean execute(String target) {
        player.playerInventory.addItemToInventory(player.getLocation().take(target));
        return false;
    };

    public String toString() { return "take"; };
}
class ReadCommand extends Command {
    public ReadCommand(Player player) { super(player); }
    public boolean execute(String target) {
        for (Room.Item item : player.getInventory().getItems()) {
            for (String s : item.getIdentifiers()) {
                if (target.equals(s)) {
                    item.read();
                }
            }
        }
        return false;
    };

    public String toString() {
        return "read";
    }
}
class ExamineCommand extends Command {
    public ExamineCommand(Player player) { super(player); }
    public boolean execute(String target) {
        return false;
    };
}
class ThrowCommand extends Command {
    public ThrowCommand(Player player) { super(player); }
    public boolean execute(String target) {
        return false;
    };
}
class DropCommand extends Command {
    public DropCommand(Player player) { super(player); }
    public boolean execute(String target) {
        return false;
    };
}
class FightCommand extends Command {
    public FightCommand(Player player) { super(player); }
    public boolean execute(String target) {
        if (player.getLocation().getEnemy() != null) {
            if (target != null) {
                if (target.equals(player.getLocation().getEnemy().toString())) {
                    boolean hasSword = false;
                    for (Room.Item item : player.getInventory().getItems()) {
                        if (item.getName() == "sword") {
                            hasSword = true;
                        }
                    }
                    if (hasSword == true) {
                        return player.getLocation().getEnemy().fight(player);
                    } else {
                        System.out.println("How will you fight without a weapon?");
                    }
                }
            } else {
                System.out.println("Fight who?");
            }

        } else {
            System.out.println("There's no enemy here.");
        }
        return false;
    };
    public String toString() { return "fight"; }
}
class DrinkCommand extends Command {
    public DrinkCommand(Player player) { super(player); }
    public boolean execute(String target) {
        return false;
    };
}
class QuitCommand extends Command {
    public QuitCommand(Player player) { super(player); }
    public boolean execute(String target) {
        System.out.println("Are you sure that you want to quit playing? (y/N)");
        Scanner quitInput = new Scanner(System.in);
        if(quitInput.nextLine().toLowerCase().equals("y")) {
            return true;
        }
        return false;
    };

    public String toString() { return "quit"; }
}
class NoCommand extends Command {
    public NoCommand(Player player) { super(player); }
    public boolean execute(String target) {
        return false;
    };
}