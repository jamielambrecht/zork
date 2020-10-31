package com.company;

public class Player extends Entity {
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
    void setLocation(Room room) {
      this.location = room;
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