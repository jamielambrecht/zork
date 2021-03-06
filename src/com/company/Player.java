package com.company;

import java.util.ArrayList;

public class Player {
    private int health;
    private int damageDealt;
	protected Room location;
	protected World world;
	protected Inventory playerInventory;

    public Player(int health, int damageDealt, World world) {
        this.health = health;
        this.damageDealt = damageDealt;
        this.world = world;
        this.location = world.getRooms().get(0);
        this.location.look();
        this.playerInventory = new Inventory();
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
    public int getHealth() { return this.health; }
    public int getDamageDealt() { return this.damageDealt; }

    public void setHealth(int value) { this.health = value; }

    public Room getLocation() { return this.location; }
    public void setLocation(Room room) {
        this.location = room;
    }

    public Inventory getInventory() { return playerInventory; }

    public class Inventory {
        private ArrayList<Room.Item> items = new ArrayList<Room.Item>();
        public Inventory() { }
        public void addItemToInventory(Room.Item item) {
            if (items.size() < 10) {
                items.add(item);
            } else {
                System.out.println("You can't carry anymore items.");
            }
        }
        public void display() {
            if (!this.items.isEmpty()) {
                System.out.println("You are carrying: \n");
                for (Room.Item item : items) {
                    System.out.println(item.getName());
                }
            } else {
                System.out.println("You are empty-handed.");
            }
        }
        public ArrayList<Room.Item> getItems() {
            return items;
        }
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