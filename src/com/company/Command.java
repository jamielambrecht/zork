package com.company;

interface Command {
    void execute(Player player);
}

class LookCommand implements Command {

    public LookCommand() {}
    public void execute(Player player) {
        player.location.look();
    }
    public String toString() {
        return "look";
    }
}
class GoCommand implements Command {
    Entity target;

    public void execute(Player player) {};
    public void setTarget(Entity target) {};
}
class OpenCommand implements Command {
    Entity target;

    public void execute(Player player) {};
    public void setTarget(Entity target) {};
}
class InventoryCommand implements Command {
    Entity target;

    public void execute(Player player) {};
    public void setTarget(Entity target) {};
}
class TakeCommand implements Command {
    Entity target;

    public void execute(Player player) {};
    public void setTarget(Entity target) {};
}
class GetCommand implements Command {
    Entity target;

    public void execute(Player player) {};
    public void setTarget(Entity target) {};
}
class ReadCommand implements Command {
    Entity target;

    public void execute(Player player) {};
    public void setTarget(Entity target) {};
}
class ExamineCommand implements Command {
    Entity target;

    public void execute(Player player) {};
    public void setTarget(Entity target) {};
}
class ThrowCommand implements Command {
    Entity target;

    public void execute(Player player) {};
    public void setTarget(Entity target) {};
}
class DropCommand implements Command {
    Entity target;

    public void execute(Player player) {};
    public void setTarget(Entity target) {};
}
class AttackCommand implements Command {
    Entity target;

    public void execute(Player player) {};
    public void setTarget(Entity target) {};
}
class DrinkCommand implements Command {
    Entity target;

    public void execute(Player player) {};
    public void setTarget(Entity target) {};
}
class NoCommand implements Command {
    Entity target;

    public void execute(Player player) {};
    public void setTarget(Entity target) {};
}