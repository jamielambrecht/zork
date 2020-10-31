package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class PlayerUI {
    private static PlayerUI instance;
    private Scanner in;
    String inputString;
    Command currentCommand;
    Player player;

    private ArrayList<Command> commandsList;
    private Command noCommand = new NoCommand();
    //private Command noTarget = new NoTarget();

    private PlayerUI(Player player) {
        this.player = player;
        this.in = new Scanner(System.in);
        inputString = new String();
        Command currentCommand = new NoCommand();
        Object target = new Object();

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
        System.out.print(">");
        inputString = in.nextLine();
        String[] words = inputString.trim().split("\\s+");
        boolean foundCommand = false;
        for (String s : words) {
            if (!foundCommand) {
              currentCommand = checkForCommand(s);
            } else {
              //target = checkForTarget(s);
            }

        }
        currentCommand.execute(player);
    }

    /*
    public Command checkForTarget(String word) {
        for (Entity en : targetsList) {
            if (word.equals(en.toString())) {
                return en;
            }
        }
        return noTarget;
    }
    */

    public Command checkForCommand(String word) {
        for (Command cmd : commandsList) {
            if (word.equals(cmd.toString())) {
                return cmd;
            }
        }
        return noCommand;
    }

    public static PlayerUI createUI() {
        if (instance == null) {
            instance = new PlayerUI();
        }
        return instance;
    }
}