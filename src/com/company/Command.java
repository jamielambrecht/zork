package com.company;

interface Command {
    void execute();
//    void setTarget(Room target);
}

class LookCommand implements Command {
    Room room;

    public void execute() {
        System.out.println("This is an open field west of a white house, with a boarded front door.");
        System.out.println("\nThere is a small mailbox here.");
        System.out.println("\nA rubber mat saying 'Welcome to Zork!' lies by the door.");
    }
    public void setTarget(Room target) {
        this.room = target;
    };
    public String toString() {
        return "look";
    }
}
class GoCommand implements Command {
    Entity target;

    public void execute() {};
    public void setTarget(Entity target) {};
}
class OpenCommand implements Command {
    Entity target;

    public void execute() {};
    public void setTarget(Entity target) {};
}
class InventoryCommand implements Command {
    Entity target;

    public void execute() {};
    public void setTarget(Entity target) {};
}
class TakeCommand implements Command {
    Entity target;

    public void execute() {};
    public void setTarget(Entity target) {};
}
class GetCommand implements Command {
    Entity target;

    public void execute() {};
    public void setTarget(Entity target) {};
}
class ReadCommand implements Command {
    Entity target;

    public void execute() {};
    public void setTarget(Entity target) {};
}
class ExamineCommand implements Command {
    Entity target;

    public void execute() {};
    public void setTarget(Entity target) {};
}
class ThrowCommand implements Command {
    Entity target;

    public void execute() {};
    public void setTarget(Entity target) {};
}
class DropCommand implements Command {
    Entity target;

    public void execute() {};
    public void setTarget(Entity target) {};
}
class AttackCommand implements Command {
    Entity target;

    public void execute() {};
    public void setTarget(Entity target) {};
}
class DrinkCommand implements Command {
    Entity target;

    public void execute() {};
    public void setTarget(Entity target) {};
}
class NoCommand implements Command {
    Entity target;

    public void execute() {};
    public void setTarget(Entity target) {};
}