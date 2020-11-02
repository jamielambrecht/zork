package com.company;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Combat {
    Player player;
    Room.Enemy enemy;

    public Combat() {    }
    public Combat(Player player, Room.Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public boolean fight() {
	    Scanner in = new Scanner(System.in);
	    Random rand = new Random();

	    /*
	    //Game variables
        ArrayList<String> enemies = new ArrayList<String>();
        enemies.add("Skeleton");
        enemies.add("Zombie");
        enemies.add("Warrior");
        enemies.add("Assassin");
        //System.out.println(enemies);
        */

        //int maxEnemyHealth = 75;
        //int enemyAttackDamage = 25;

        //Player variables
        //int health = 100;
        //int attackDamage = 50;
        int numHealthPots = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50;

        boolean running = true;

        System.out.println("Welcome to Zork");

        GAME:
        while (running){
            System.out.println("-----------------------------------------");

            enemy.setHealth(rand.nextInt(enemy.getHealth()));
            //String enemy = enemies.get(rand.nextInt(enemies.size()));
            System.out.println("\t# " + this.enemy + " appeared! #\n");

            while(enemy.getHealth() > 0) {
                System.out.println("\tYour Hp: " + this.player.getHealth());
                System.out.println("\t" + this.enemy + "'s HP: " + this.enemy.getHealth());
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");

                String input = in.nextLine();
                if(input.equals("1")){
                    int damageDealt = rand.nextInt(player.getDamageDealt());
                    int damageTaken = rand.nextInt(enemy.getDamageDealt());

                    enemy.setHealth(enemy.getHealth() - damageDealt);
                    player.setHealth(player.getHealth() - damageTaken);

                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You receive " + damageTaken + " in retaliation!");

                    if(player.getHealth() < 1){
                        System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                        break;
                    }
                }
                else if(input.equals("2")){
                    if(numHealthPots > 0){
                        player.setHealth(player.getHealth() + healthPotionHealAmount);
                        numHealthPots--;
                        System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount + "."
                        + "\n\t> You now have " + player.getHealth() + " HP."
                        + "\n\t> You have " + numHealthPots + " health potions left.\n");
                    }
                    else {
                        System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get a random drop");
                    }
                }
                else if(input.equals("3")){
                    System.out.println("\tYou run away from the " + enemy + "!");
                    running = false;
                    continue GAME;
                }
                else{
                    System.out.println("\tInvalid command!");
                }
            }
            if(player.getHealth() < 1){
                System.out.println("You are dead af.");
                return true;
            }

            System.out.println("---------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! # ");
            System.out.println(" # You have " + player.getHealth() + " HP left. #");
            if(rand.nextInt(100) < healthPotionDropChance){
                numHealthPots++;
                System.out.println(" # The " + enemy + " dropped a health potion! # ");
                System.out.println(" # You now have " + numHealthPots + " health potion(s). # ");

            }
            this.enemy.isDead = true;
            running = false;
        }
        return false;
    }
}
