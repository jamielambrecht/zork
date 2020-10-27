package com.company;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Main {
    // Change name if you wish
    public enum SIDE {NORTH, SOUTH, EAST, WEST}

    public static void main(String[] args) {
        CommandUI playerUI = CommandUI.createUI();

        // Todo : instantiate rooms,
		/* Plan of Action
		 - Call MazeBuilder or MazeFactory to build your maze
		 	 - Rooms made :)
			 - One room is called Room westOfHouse = new Room("West of House" //...)
		 - Call Player constructor, and put the player in a rooms
			 - Player player = new Player(15, 5, westOfHouse);
			 								OR YOU CAN DO
			 - Or you can do: Player player = new Player();
			 - player.setLocation(westOfHouse);
		 - Create all initial objects in each room
		*/
        SIDE temp = SIDE.NORTH;
        int index = temp.ordinal(); // This is the thing from C++!  Hooray!
        System.out.println(index);

        int myNum = 5;
        Room westOfHouse = new Room();
        boolean isOpen = true;

        playerUI.input();

    }
} // This is the bottom of Main class

class CommandUI {
    private static CommandUI instance;
    private Scanner in;

    private ArrayList<Command> commandsList;
    private Command noCommand = new NoCommand();

    private CommandUI() {
        this.in = new Scanner(System.in);

        commandsList = new ArrayList<Command>();
        Command noCommand = new NoCommand();
        commandsList.add(new LookCommand());
        commandsList.add(new GoCommand());
        commandsList.add(new OpenCommand());
        commandsList.add(new InventoryCommand());
        commandsList.add(new TakeCommand());
        commandsList.add(new GetCommand());
        commandsList.add(new ReadCommand());
        commandsList.add(new ExamineCommand());
        commandsList.add(new ThrowCommand());
        commandsList.add(new DropCommand());
        commandsList.add(new AttackCommand());
        commandsList.add(new DrinkCommand());
    }

    public void input()  {
        System.out.print(">: ");
        while (in.hasNext()) {
            String word = in.next();
            // Check for valid input
            System.out.println(word);
        }
    }

    public Command checkForCommand(String word) {
        for (Command cmd : commandsList) {
            if (word == cmd.toString()) {
                return cmd;
            }
        }
        return noCommand;
    }

    public static CommandUI createUI() {
        if (instance == null) {
            instance = new CommandUI();
        }
        return instance;
    }
}

interface Command {
    void execute();
    void setTarget(Entity target);
}

class LookCommand implements Command {
    Entity target;

    public void execute() {};
    public void setTarget(Entity target) {};
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

abstract class Entity {
    protected String name;
    protected int hitPoints;
    protected int damageDealt;
    protected Room location;

    public String getName() { return name; }
    public int hitPoints() { return hitPoints; }
    // public Room getLocation() { return location; }
}

class Player extends Entity {
    // int playerHP;
    // public void Player() {
    //     this(15, null);
    // }
    // public void Player(int playerHP, Room location) {
    //     this.playerHP = playerHP;
    //     this.location = location;
    // }
    public Player() { this(15, 5, null); }

    public Player(int hitPoints, int damageDealt, Room location) {
        this.hitPoints = hitPoints;
        this.damageDealt = damageDealt;
        this.location = location;
    }

		/*
		public int damage() {
			return damageDealt;
		}
		public int damage(Weapon weapon) {
			return damage() + weapon.damageDealt;
		}
		*/

    /*
    class Sword {
        private int damageDealt;
        public int damage(Player player) {
            return this.damageDealt + player.damageDealt;
        }
    }
    */
    // Room location = new Room();
    void look() { }
    void take() { }
}

interface MapSite {
    void enter();
}

class Room implements MapSite {
    // private SIDE[] side = {"north", "south", "east", "west"}; // Not needed at all
    private MapSite[] sides = new MapSite[6]; // NEWS + UP + DOWN
    // private ArrayList<Item> items;


    public void Room() {};

    //ArrayList<Item> getItems();
    // public String toString() {
    // }
    public void enter() {};
}

class WestOfHouse extends Room {
    public void WestOfHouse() {

    }
}

/*
public static void combat(Enemy enemy) {
	System.out.printf("You have encountered a %s\n", enemy.getName());
	int gruedam = rand.nextint(3) + enemy.damageDealt; // Crit damage???
	String input;
	int hpgrue; // you get this from enemy.hitPoints;
	hpgrue = 1;
	if(HP <= 0) { // player.hitPoints <= 0
		gameover();
	}
	if (hpgrue <= 0) {
		System.out.println("You Defeated A Grue");
	} else if (hpgrue > 0) {
		input = UI.nextLine();
		if (input.equals("attack")) {
			hpgrue = hpgrue - dam - atk;
			HP = HP - gruedam;
			System.out.format("You Have Been Hit, Your HP is %d", HP);
			System.out.println("");
			combat(enemy);
		}
		else if(input.equals("heal")) {
			if (medicine <= 0) {
				System.out.println("You do not have enough potions");
				combat(enemy);
			}
			else {
				HP = HP + heal;
				System.out.println("You have been healed");
				System.out.format("You have been hit, your HP is %d", HP);
				System.out.println("");
				HP = HP - gruedam;
				System.out.format("You have been hit, Your HP is %d", HP);
				System.out.println("");
				combat(enemy);
			}
		}
	}
}
*/

