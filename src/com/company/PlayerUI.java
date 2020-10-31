package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class PlayerUI {
    private static PlayerUI instance;
    private Scanner in;
    String inputString;
    Command currentCommand;
    ArrayList<Object> targetsList;
    Player player;

    private ArrayList<Command> commandsList;
    private Command noCommand = new NoCommand();

    private PlayerUI(Player player) {
        this.player = player;
        this.in = new Scanner(System.in);
        inputString = new String();

        commandsList = new ArrayList<Command>();
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
        commandsList.add(new QuitCommand());
    }

    public boolean input(Player player)  {
        targetsList = player.location.getTargets();
        Object target;
        System.out.print(">");
        inputString = in.nextLine();
        String[] words = inputString.trim().split("\\s+");
        boolean foundCommand = false;
        boolean quitFlag = false;

        for (String s : words) {
            if (!foundCommand) {
              currentCommand = checkForCommand(s);
            } else {
              target = checkForTarget(s);
            }
        }
        return currentCommand.execute(player);
    }

    
    public Object checkForTarget(String word) {
        for (Object target : targetsList) {
            if (word.equals(target.toString())) {
                return target;
            }
        }
        return null;
    }
    

    public Command checkForCommand(String word) {
        for (Command cmd : commandsList) {
            if (word.equals(cmd.toString())) {
                return cmd;
            }
        }
        return noCommand;
    }

    public static PlayerUI createUI(Player player) {
        if (instance == null) {
            instance = new PlayerUI(player);
        }
        return instance;
    }
}