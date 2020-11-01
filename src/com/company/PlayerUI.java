package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class PlayerUI {
    private static PlayerUI instance;
    private Scanner in;
    private String inputString;
    static private Command currentCommand;
    private ArrayList<String> targetsList = new ArrayList<String>();
    private Player player;
    private String target;

    private ArrayList<Command> commandsList;
    private Command noCommand;

    private PlayerUI(Player player) {
        this.player = player;
        this.in = new Scanner(System.in);
        this.inputString = new String();
        this.target = new String();

        commandsList = new ArrayList<Command>();
        commandsList.add(new LookCommand(player));
        commandsList.add(new GoCommand(player));
        commandsList.add(new OpenCommand(player));
        commandsList.add(new InventoryCommand(player));
        commandsList.add(new TakeCommand(player));
        commandsList.add(new GetCommand(player));
        commandsList.add(new ReadCommand(player));
        commandsList.add(new ExamineCommand(player));
        commandsList.add(new ThrowCommand(player));
        commandsList.add(new DropCommand(player));
        commandsList.add(new AttackCommand(player));
        commandsList.add(new DrinkCommand(player));
        commandsList.add(new QuitCommand(player));

        this.noCommand = new NoCommand(player);
        commandsList.add(noCommand);
    }

    public boolean input()  {
        this.targetsList = this.player.getLocation().getTargets();
        System.out.print(">");
        inputString = in.nextLine();
        String[] words = inputString.trim().split("\\s+");
        boolean foundCommand = false;
        boolean quitFlag = false;

        for (String s : words) {
            if (!foundCommand) {
              currentCommand = checkForCommand(s);
              if (currentCommand != noCommand) {
                  foundCommand = true;
              }
            } else {
                target = checkForTarget(s);
            }
        }
        quitFlag = currentCommand.execute(target);
        return quitFlag;
    }

    public Command checkForCommand(String word) {
        for (Command cmd : commandsList) {
            if (word.equals(cmd.toString())) {
                return cmd;
            }
        }
        return this.noCommand;
    }
    
    public String checkForTarget(String word) {
        for (String target : targetsList) {
            if (word.equals(target)) {
                return target;
            }
        }
        return null;
    }

    public static PlayerUI createUI(Player player) {
        if (instance == null) {
            instance = new PlayerUI(player);
        }
        return instance;
    }
}