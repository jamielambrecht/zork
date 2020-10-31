package com.company;
import java.util.Scanner;

interface Command {
    boolean execute(Player player);
}

class LookCommand implements Command {

    public LookCommand() {}
    public boolean execute(Player player) {
        player.location.look();
        return false;
    }
    public String toString() {
        return "look";
    }
}
class GoCommand implements Command {
    Object target;

    public boolean execute(Player player) {
        return false;
    };
    public void setTarget(Object target) {};
}
class OpenCommand implements Command {
    Object target;

    public boolean execute(Player player) {
        return false;
    };
    public void setTarget(Object target) {};
}
class InventoryCommand implements Command {
    Object target;

    public boolean execute(Player player) {
        return false;
    };
    public void setTarget(Object target) {};
}
class TakeCommand implements Command {
    Object target;

    public boolean execute(Player player) {
        return false;
    };
    public void setTarget(Object target) {};
}
class GetCommand implements Command {
    Object target;

    public boolean execute(Player player) {
        return false;
    };
    public void setTarget(Object target) {};
}
class ReadCommand implements Command {
    Object target;

    public boolean execute(Player player) {
        return false;
    };
    public void setTarget(Object target) {};
}
class ExamineCommand implements Command {
    Object target;

    public boolean execute(Player player) {
        return false;
    };
    public void setTarget(Object target) {};
}
class ThrowCommand implements Command {
    Object target;

    public boolean execute(Player player) {
        return false;
    };
    public void setTarget(Object target) {};
}
class DropCommand implements Command {
    Object target;

    public boolean execute(Player player) {
        return false;
    };
    public void setTarget(Object target) {};
}
class AttackCommand implements Command {
    Object target;

    public boolean execute(Player player) {
        return false;
    };
    public void setTarget(Object target) {};
}
class DrinkCommand implements Command {
    Object target;

    public boolean execute(Player player) {
        return false;
    };
    public void setTarget(Object target) {};
}
class QuitCommand implements Command {
    Object target;

    public boolean execute(Player player) {
        System.out.println("Are you sure that you want to quit playing? (y/N)");
        Scanner quitInput = new Scanner(System.in);
        if(quitInput.nextLine().toLowerCase().equals("y")) {
            return true;
        }
        return false;
    };
    public void setTarget(Object target) {};

    public String toString() { return "quit"; }
}
class NoCommand implements Command {
    Object target;

    public boolean execute(Player player) {
        return false;
    };
    public void setTarget(Object target) {};
}