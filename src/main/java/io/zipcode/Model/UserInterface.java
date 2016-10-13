package io.zipcode.Model;

/**
 * Created by kyle on 10/12/16.
 */
public class UserInterface extends Engine{
    private String[] userCommands = {"QUIT, PLAY BLACKJACK, PLAY HEARTS, PLAY GOFISH, PLAY SLOTS, PLAY ROULETTE, PLAY WAR, PLAY RUSSIAN PLAY ROULETTE, PLAY BACCARAT"};

    public UserInterface(){
        super();
        System.out.println("Welcome to the Casino!");
    }
    public Class getPlayerInfo(String playerName, int playerBet){
        String name = User.stringInput("Please enter your name");
        int bet = User.integerInput("Please enter your betting amount");
        Player newPlayer = new Player(playerName, playerBet);
        players.add(newPlayer);
        return evaluateUserCommand();
    }
    public Class evaluateUserCommand() {
        String userCommand = null;
        while (!"QUIT".equals(userCommand)) {
            userCommand = getValidUserCommand().toUpperCase();
            switch (userCommand) {
                case "PLAY GOFISH":
                    return
                    break;

                case "QUIT":
                    System.out.println("Bye, Bye!");
                    System.exit(0);
                    break;
            }
        }
    }


    public void displayUserCommands() {
        System.out.println("Displaying a list of valid user commands...");
        for (String command : userCommands) {
            System.out.println("\t" + command);
        }
    }

    public String getValidUserCommand() {
        displayUserCommands();
        String userCommand = User.stringInput("Enter a command");
        while (!isValidUserCommand(userCommand)) {
            userCommand = User.stringInput("Enter a command");
        }
        return userCommand;
    }

    public boolean isValidUserCommand(String userCommand) {
        for (String command : this.userCommands) {
            if (command.equals(userCommand.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}

