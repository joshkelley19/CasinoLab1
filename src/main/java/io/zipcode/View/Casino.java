package io.zipcode.View;

import io.zipcode.Model.Engine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshuakelley on 10/11/16.
 */
public class Casino {
    Engine engine = new Engine();
    UserInput ui = new UserInput();
//
//    public void startGame(){
//        Display.whatsYourName();
//        String name = ui.getString();
//        Display.howMuchMoney();
//        int balance = ui.getInt();
//        engine.createPlayer(name, balance);
//    }
//
//    public void enterCasino(){
//        Display.welcomeMessage();
//        String answer;
//        do{
//            Display.requestGame();
//            answer = ui.getString();
//        }while (gameChoice(answer));
//        Display.leaveCasino();
//    }
//
//    public boolean gameChoice(String game){
//        //regex
//        try{
//            switch (game.toUpperCase()){
//                case "SLOTS": playSlots();break;
//                case "BLACKJACK": playBlackjack();break;
//                case "ROULETTE": playRoulette();break;
//                case "AGRAM": playAgram();break;
//                case "GO FISH": playGoFish();break;
//                case "RUSSIAN ROULETTE": playRussianRoulette();break;
//                case "BACCARAT": playBaccarat();break;
//                case "WAR": playWar();break;
//                case "QUIT": return false;
//                default:
//                    System.out.println("We did not understand your request, please try again.");return true;
//            }
//        }catch (InvalidBetException e){
//            Display.weakBet();
//        }catch (ZeroBalanceException z){
//
//        }catch (GameSizeException g){
//
//        }finally {
//            return true;
//        }
//    }
//

    public void playAgram(){

        engine.createPlayer("John", 100);
        engine.createPlayer("Jen", 100);
        engine.createPlayer("Jeb", 100);
        engine.createPlayer("Joan", 100);

        List<Integer> bets = new ArrayList<Integer>();
        int length = engine.players.size();
        int startingPlayer;
        int currentPlayer;
        Display.agramWelcome();

        for (int i = 0; i < length; i++) {
            bets.add(requestBet());
        }

        engine.initializeAgram(bets);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < length; j++) {
                if (j > 0 ) {
                    Display.printAgram("The current suit is " + engine.getAgramPlayedSuit());
                }
                startingPlayer = engine.getAgramStartingPlayer();
                currentPlayer = (startingPlayer + j) % length;
                Display.printAgram("Player " + (currentPlayer + 1) + " select a card by number.");
                Display.printAgram(engine.getAgramHand(j));
                while(!(engine.playAgram(ui.getInt(), currentPlayer))) {
                    Display.printAgram("You cannot play that card.");
                }
                Display.printAgram("Player " + (currentPlayer + 1) + " played " + engine.getAgramLastPlayed());
            }
            engine.finishAgramRound();

        }

        engine.settleAgramBets(bets);

        for (int winnings : bets) {
            Display.result(winnings);
        }

    }

    public int requestBet(){
        Display.requestBet();
        return ui.getInt();
    }

}
