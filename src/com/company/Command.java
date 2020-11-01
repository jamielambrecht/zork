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
        for (Room.Door door : player.getLocation().doors) {
            if (target.equals(door.toString())) {
                if (!door.isLocked()) {
                    player.setLocation(door.enter(player.world));
                    player.getLocation().look();
                } else {
                    System.out.println(door.getLockedMsg());
                }
            }
        }
        return false;
    };
    public String toString() { return "go"; };
}
class OpenCommand extends Command {
    public OpenCommand(Player player) { super(player); }
    public boolean execute(String target) {
        return false;
    };
}
class InventoryCommand extends Command {
    public InventoryCommand(Player player) { super(player); }
    public boolean execute(String target) {
        return false;
    };
}
class TakeCommand extends Command {
    public TakeCommand(Player player) { super(player); }
    public boolean execute(String target) {
        return false;
    };

    public String toString() {return "take";};
}
class GetCommand extends Command {
    public GetCommand(Player player) { super(player); }
    public boolean execute(String target) {
        return false;
    };
}
class ReadCommand extends Command {
    public ReadCommand(Player player) { super(player); }
    public boolean execute(String target) {
        return false;
    };
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
class AttackCommand extends Command {
    public AttackCommand(Player player) { super(player); }
    public boolean execute(String target) {
        return false;
    };
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